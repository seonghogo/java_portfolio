package com.member.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class MemberDAO {
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
	public int login(String id , String pass){
		int check = 0;
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pass").equals(pass)) {
					
					sql = "update member set logindate=now() where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
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
		System.out.println("check"+check);
		return check;
	}
	
	public int join(String id , String pass ,String name , String email) {
		int check = 0;
		int num = 0;
		try {
			con = getConnection();
			sql = "select count(num) as num from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				num = num+1;
			}
			System.out.println(num);
			sql = "insert into member(num,id,pass,email,name,joindate) values(?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2,id);
			pstmt.setString(3,pass);
			pstmt.setString(4,email);
			pstmt.setString(5,name);
			pstmt.executeUpdate();
			check = 1;
			System.out.println(check);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		
		System.out.println(check);
		return check;
		
		
	}
	public MemberBean dateview(String id) {
		MemberBean mb = new MemberBean();
		
		try {
			con = getConnection();
			sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setEmail(rs.getString("email"));
				mb.setName(rs.getString("name"));
				mb.setJoindate(rs.getTimestamp("joindate"));
				mb.setLogindate(rs.getTimestamp("logindate"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		
		return mb;
	}
	public int M_update(String pass ,String name, String email,String id) {
		int check = 0;
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					sql = "update member set name=?,email=? where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, email);
					pstmt.setString(3, id);
					
					pstmt.executeUpdate();
				
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
	
	public int M_delete(String id , String pass) {
		int check = 0;
		try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("pass"));
				System.out.println(pass);
				if(rs.getString("pass").equals(pass)) {
					sql = "delete from member where id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
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
		System.out.println(check);
		return check;
	}
	public int idck(String id) {
		int check = 0;
		
		 try {
			con = getConnection();
			sql = "select pass from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(id+"ududududud");
			if(rs.next()) {
				check = 1;
			}else {
				check = 2;
				System.out.println("11222");
			}
//			if(rs.next()) {
//				System.out.println(id);
//				System.out.println(rs.getString("id"));
//				if(rs.getString("id").equals(id)) {
//					System.out.println("11");
//					check = 1;
//				}else {
//					System.out.println(rs.getString("id")+id+"2222");
//					check = 2;
//				}
//			}else {
//				System.out.println(rs.getString("id")+id+"2332");
//				check =2;
//			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null)try{rs.close();}catch(SQLException se){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException se){}
			if(con!=null)try{con.close();}catch(SQLException se){}
		}
		
		System.out.println(check+"checkckckck");
		return check;
	}
}
