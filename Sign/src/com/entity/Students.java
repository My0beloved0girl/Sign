package com.entity;

public class Students {
	private int id;
	private String name;
	private String logname;
	private String signTime;
	private int sex;
	private String clas;
	private int role;
	private String rname;
	
	public Students() {}
	
	public Students(int id,String name,String logname,String signTime,int sex,String clas,int role) {
		this.id=id;
		this.name=name;
		this.logname=logname;
		this.signTime=signTime;
		this.sex=sex;
		this.clas=clas;
		this.role=role;
	}
	
	public Students(int id,String name,String logname,String signTime,int sex,String clas,String rname) {
		this.id=id;
		this.name=name;
		this.logname=logname;
		this.signTime=signTime;
		this.sex=sex;
		this.clas=clas;
		this.rname=rname;
	}

	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getSignTime() {
		return signTime;
	}

	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}
	
	
}
