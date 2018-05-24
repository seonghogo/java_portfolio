package com.member.db;

import java.sql.Timestamp;

public class MemberBean {
	private int num;
	private String id;
	private String name;
	private String pass;
	private Timestamp joindate;
	private Timestamp logindate;
	private String email;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Timestamp getJoindate() {
		return joindate;
	}
	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}
	public Timestamp getLogindate() {
		return logindate;
	}
	public void setLogindate(Timestamp logindate) {
		this.logindate = logindate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


}
