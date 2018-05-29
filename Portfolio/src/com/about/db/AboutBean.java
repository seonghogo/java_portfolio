package com.about.db;

import java.sql.Timestamp;

public class AboutBean {
	private int a_num;

	private String a_contents;
	private Timestamp date;
	private String img;
	public String getA_contents() {
		return a_contents;
	}
	public void setA_contents(String a_contents) {
		this.a_contents = a_contents;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	 
}
