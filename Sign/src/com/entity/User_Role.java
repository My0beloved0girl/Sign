package com.entity;

public class User_Role {
	private int userid;
	private int roleid;
	
	public User_Role(){}
	
	public User_Role(int userid,int roleid){
		this.userid=userid;
		this.roleid=roleid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	
	
}
