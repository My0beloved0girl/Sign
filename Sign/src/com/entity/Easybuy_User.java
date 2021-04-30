package com.entity;

public class Easybuy_User {
	
	private int id;
	private String userName;
	private String loginName;
	private String password;
	private int sex;
	private String identityCode;
	private String email;
	private String mobile;
	private int type;
	private int role;
	private String clas;
	private String rname;

	
	public Easybuy_User(){
		
	}
	
	public Easybuy_User(int id,String userName,String loginName,String password,int sex,
			String identityCode,String email,String mobile,int type,int role,String clas){
		this.id=id;
		this.userName=userName;
		this.loginName=loginName;
		this.password=password;
		this.sex=sex;
		this.identityCode=identityCode;
		this.email=email;
		this.mobile=mobile;
		this.type=type;
		this.role=role;
		this.clas=clas;
	}
	
	public Easybuy_User(int id,String userName,String loginName,String password,int sex,
			String identityCode,String email,String mobile,int type,String rname,String clas){
		this.id=id;
		this.userName=userName;
		this.loginName=loginName;
		this.password=password;
		this.sex=sex;
		this.identityCode=identityCode;
		this.email=email;
		this.mobile=mobile;
		this.type=type;
		this.rname=rname;
		this.clas=clas;
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

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	

}
