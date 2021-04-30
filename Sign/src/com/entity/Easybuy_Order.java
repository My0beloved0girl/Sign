package com.entity;

import java.sql.Date;

public class Easybuy_Order {
	private int id;
	private int userId;
	private String loginName;
	private String userAddress;
	private Date createTime;
	private double cost;
	private int status;
	private int type;
	private String serialNumber;
	
	public Easybuy_Order(){
		
	}
	
	public Easybuy_Order(int id,int userId,String loginName,String userAddress,Date createTime,double cost,int status,int type,String serialNumber){
		this.id=id;
		this.userId=userId;
		this.loginName=loginName;
		this.userAddress=userAddress;
		this.createTime=createTime;
		this.cost=cost;
		this.status=status;
		this.type=type;
		this.serialNumber=serialNumber;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	

}
