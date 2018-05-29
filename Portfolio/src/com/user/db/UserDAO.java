package com.user.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
}
