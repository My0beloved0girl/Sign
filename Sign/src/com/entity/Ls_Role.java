package com.entity;

public class Ls_Role {
	private int id;
	private String rname;
	
	public Ls_Role(){}
	
	public Ls_Role(int id,String rname){
		this.id=id;
		this.rname=rname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}
	
	

}
