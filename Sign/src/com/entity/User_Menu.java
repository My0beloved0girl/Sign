package com.entity;

public class User_Menu {
	private int userid;
	private int menuid;
	
	public User_Menu(){}
	
	public User_Menu(int userid,int menuid){
		this.userid=userid;
		this.menuid=menuid;
		
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	
	

}
