package com.entity;

public class Ls_Menu {
	private int id;
	private String mname;
	private int mfatherid;
	private int type;
	private String url;
	private String buttom;

	public Ls_Menu(){}
	
	public Ls_Menu(int id,String mname,int mfatherid,int type,String url,String buttom){
		this.id=id;
		this.mname=mname;
		this.mfatherid=mfatherid;
		this.type=type;
		this.url=url;
		this.buttom=buttom;
	}

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	

	public String getButtom() {
		return buttom;
	}

	public void setButtom(String buttom) {
		this.buttom = buttom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getMfatherid() {
		return mfatherid;
	}

	public void setMfatherid(int mfatherid) {
		this.mfatherid = mfatherid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}
