package com.portfolio.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.db.BoardBean;



public class P_folioDAO {
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
	public int  p_insert(P_folioBean pb){
		System.out.println(pb.getP_title()+":::title");
		int check = 0;
		int p_num = 0;
		try {
			con = getConnection();
			sql = "select count(p_num) as num from p_folio";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				p_num = rs.getInt("num");
				p_num = p_num+1;
			}
			
			sql = "insert into p_folio(p_num,p_title,p_contents,item,img,p_date) values(?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, p_num);
			pstmt.setString(2, pb.getP_title());
			pstmt.setString(3, pb.getP_contents());
			pstmt.setString(4, pb.getItem());
			pstmt.setString(5, pb.getImg());
			
			System.out.println(p_num+"11"+pb.getP_title()+"11"+pb.getP_contents()+"11"+pb.getItem()+"11"+pb.getImg());
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
	public ArrayList<P_folioBean> list(){
		ArrayList<P_folioBean> list = new ArrayList<>();
		P_folioBean pb = null; 
		
		
		try {
			con = getConnection();
			sql = "select * from p_folio";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pb = new P_folioBean();
				pb.setItem(rs.getString("item"));
				pb.setP_title(rs.getString("p_title"));
				pb.setP_contents(rs.getString("p_contents"));
				pb.setP_num(rs.getInt("p_num"));
				pb.setP_date(rs.getTimestamp("p_date"));
				list.add(pb);
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
	public P_folioBean select(int num) {
		P_folioBean pb = new P_folioBean();
		
		
		try {
			con = getConnection();
			sql = "select * from p_folio where p_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			System.out.println(num+"num");
			if(rs.next()) {
				pb.setP_num(rs.getInt("p_num"));
				pb.setImg(rs.getString("img"));
				pb.setP_title(rs.getString("p_title"));
				pb.setP_contents(rs.getString("p_contents"));
				pb.setP_date(rs.getTimestamp("p_date"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return pb;
	}
	public P_folioBean update(int num) {
		P_folioBean pb = null ;
		try {
			con = getConnection();
					sql = "select * from p_folio where p_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, num);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						pb = new P_folioBean();
						pb.setP_num(rs.getInt("p_num"));
						pb.setP_title(rs.getString("p_title"));
						pb.setP_contents(rs.getString("p_contents"));
						pb.setP_date(rs.getTimestamp("p_date"));
					}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return pb;
	}
	
	public void p_update(String title , String contents,int num) {
		System.out.println("!!!!!!!!!!!");
		System.out.println(title+""+contents+""+num);
		try {
			con = getConnection();
			sql = "select * from p_folio where p_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				System.out.println("111");
				sql = "update p_folio set p_title=? , p_contents=? where p_num=?";
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
		String id = "admin";
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
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
	public int p_del(String pass,int num,String id) {
		int check = 0;
		
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					sql = "delete from p_folio where p_num=?";
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
