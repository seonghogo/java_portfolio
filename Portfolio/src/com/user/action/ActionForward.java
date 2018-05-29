package com.user.action;

public class ActionForward {

	private boolean isRedirect;
	private String path;
	
	//alt shift s r  setter getter 메소드
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
