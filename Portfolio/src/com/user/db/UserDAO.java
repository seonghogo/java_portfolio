package com.user.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.about.db.AboutBean;
import com.board.db.BoardBean;
import com.member.db.MemberBean;



public class UserDAO {
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
	public ArrayList<MemberBean>  select(){
	ArrayList<MemberBean>list = new ArrayList<>();
	MemberBean mb = null;
		try {
			con = getConnection();
			sql = "select num,id,logindate,joindate from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getInt("num"));
				mb = new MemberBean();
				System.out.println(rs.getInt("num")+rs.getString("id"));
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setLogindate(rs.getTimestamp("logindate"));
				mb.setJoindate(rs.getTimestamp("joindate"));
				System.out.println(mb.getId()+"id");
				list.add(mb);
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
	public int del(int num , String id) {
		System.out.println("유저삭제"+num+id);
		int check = 0;
		try {
			con = getConnection();
			sql = "select id from member where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("id").equals(id)) {
					sql = "delete from member where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					check = 1;
				}else {
					check =2;
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
	public int about() {
		System.out.println("about");
		int check = 0;
		
		try {
			con = getConnection();
			sql = "select * from about order by a_num desc limit 1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("a_num")+"11");
				if(rs.getInt("a_num")>0) {
					check = 1;
					sql = "select * from about order by a_contents desc limit 1";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						check = 2;
					}
				}else if(rs.getInt("a_num")==0){
					check = 2;
				}
			}
			System.out.println(check+"!!!::;check");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		return check;
	}
	public AboutBean aboutsel() {
		AboutBean ab=null;
		System.out.println("aboutsel");
		try {
			con = getConnection();
			sql = "select * from about order by a_num desc limit 1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ab = new AboutBean();
				ab.setA_num(rs.getInt("a_num"));
				ab.setA_contents(rs.getString("a_contents"));
				ab.setDate(rs.getTimestamp("date"));
				ab.setImg(rs.getString("img"));
				System.out.println(ab.getA_contents());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		return ab;
	}
	public int aboutin(AboutBean ab) {
		int check = 0;
		int num = 0;
		try {
			System.out.println("aboutin");
			con = getConnection();
			sql = "select count(a_num) as num from about";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				num = num+1;
			}
			sql = "insert into about(a_num,a_contents,date,img) values(?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, ab.getA_contents());
			pstmt.setString(3, ab.getImg());
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
}
