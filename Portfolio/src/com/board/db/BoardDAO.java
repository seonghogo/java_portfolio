package com.board.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BoardDAO {
	PreparedStatement pstmt = null;
	String sql="";
	Connection con = null;
	ResultSet rs = null;


	private Connection getConnection() throws Exception{
		/*Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/memberDB","root","rfid123");
		 */
		System.out.println("asd");
		Connection con = null;
		//Context 객체생성
		Context init = new InitialContext();
		System.out.println("a");
		//DataSource ds =메소드 호출 lookup (자원의 이름)
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		//con = getConnection()
		con = ds.getConnection();
		System.out.println("asdads");
		return con;
	}
	public int  b_insert(String id , String title ,String contents){
		int check = 0;
		int b_num = 0;
		try {
			con = getConnection();
			sql = "select count(b_num) as num from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_num = rs.getInt("num");
				b_num = b_num+1;
			}

			sql = "insert into board(b_num,b_id,b_title,b_contents,b_count,b_date) values(?,?,?,?,0,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			pstmt.setString(2, id);
			pstmt.setString(3, title);
			pstmt.setString(4, contents);
			pstmt.executeUpdate();
			check = 1;

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return check;
	}
	public ArrayList<BoardBean> list(){
		ArrayList<BoardBean> list = new ArrayList<>();
		BoardBean bb = null; 

		try {
			con = getConnection();
			sql = "select * from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bb = new BoardBean();
				bb.setB_num(rs.getInt("b_num"));
				bb.setB_title(rs.getString("b_title"));
				bb.setB_id(rs.getString("b_id"));
				bb.setB_count(rs.getInt("b_count"));
				bb.setB_date(rs.getTimestamp("b_date"));
				list.add(bb);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return list;
	}

	public BoardBean b_select(int num) {
		BoardBean bb = null;

		try {
			con = getConnection();
			sql = "select * from board where b_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				int count = rs.getInt("b_count");
				count = count + 1;
				sql = "update board set b_count=? where b_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, count);
				pstmt.setInt(2,num);
				pstmt.executeUpdate();

				bb = new BoardBean();

				bb.setB_num(rs.getInt("b_num"));
				bb.setB_id(rs.getString("b_id"));
				bb.setB_title(rs.getString("b_title"));
				bb.setB_contents(rs.getString("b_contents"));
				bb.setB_count(count);
				bb.setB_date(rs.getTimestamp("b_date"));
			}




		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}

		return bb;
	}
	public BoardBean update(int num) {
		BoardBean bb = null ;
		try {
			con = getConnection();
					sql = "select * from board where b_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						bb = new BoardBean();
						bb.setB_num(rs.getInt("b_num"));
						bb.setB_id(rs.getString("b_id"));
						bb.setB_title(rs.getString("b_title"));
						bb.setB_contents(rs.getString("b_contents"));
						bb.setB_count(rs.getInt("b_count"));
						bb.setB_date(rs.getTimestamp("b_date"));
					}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return bb;
	}

	public void b_update(String title , String contents,int num) {
		System.out.println("!!!!!!!!!!!");
		System.out.println(title+""+contents+""+num);
		try {
			con = getConnection();
			sql = "select * from board where b_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("111");
				sql = "update board set b_title=? , b_contents=? where b_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, contents);
				pstmt.setInt(3, num);
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
	}
	public int updatepassck(String pass) {
		int check = 0;
		
		try {
			con = getConnection();
			sql = "select pass from member where pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					check = 1;
				}else {
					check = 2;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		
		return check;
	}
	
	public int b_del(String pass,int num,String id) {
		int check = 0;
		
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					sql = "delete from board where b_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					check = 1;
				}else {
					check = 2;
				}
			}else {
				check = 3;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		return check;
	}
}
