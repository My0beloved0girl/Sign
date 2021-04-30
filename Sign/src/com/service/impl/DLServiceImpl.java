package com.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.dao.DengLu;
import com.dao.impl.DengLuImpl;
import com.entity.Easybuy_Order;
import com.entity.Easybuy_User;
import com.entity.Grade;
import com.entity.Layui;
import com.entity.Ls_Butten;
import com.entity.Ls_Menu;
import com.entity.Ls_Role;
import com.entity.ShuZ;
import com.entity.Students;
import com.entity.User_Menu;
import com.entity.User_Role;
import com.service.DengLuService;
import com.utils.DataBaseUtil;

public class DLServiceImpl implements DengLuService {
	
	DengLu dl=new DengLuImpl();
	
	@Override
	public int Dl(String loginName2, String password2) {
		
		return dl.Dl(loginName2, password2);
	}


	@Override
	public List<Easybuy_User> Hqzh(int uid) {
		
		return dl.Hqzh(uid);
	}
	
	
	@Override
	public int Pd(int userid2) {
		
		return dl.Pd(userid2);
	}

	@Override
	public List<Ls_Menu> Zx(int roleid) {
		
		return dl.Zx(roleid);
	}

	@Override
	public List<Ls_Menu> An(int mfid,int uid) {
		
		return dl.An(mfid, uid);
	}
	
	@Override
	public Layui<Easybuy_User> FhJson() {
		
		List<Easybuy_User> list=dl.FhJson();
		//System.out.println(list);
		int num=dl.SjZs();
		//System.out.println(num);
		//System.out.println(list);
		Layui<Easybuy_User> layui=new Layui<Easybuy_User>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			//System.out.println(layui);
			
		return layui;
	}
	
	@Override
	public int SjZs() {
		
		return dl.SjZs();
	}

	@Override
	public Layui<Easybuy_User> SsCx(String name) {
		List<Easybuy_User> list=dl.SsCx(name);
		int num=dl.SjZs();
		Layui<Easybuy_User> layui=new Layui<Easybuy_User>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public Layui<Ls_Menu> QxZs() {
		List<Ls_Menu> list=dl.QxZs();
		int num=dl.SjZs();
		Layui<Ls_Menu> layui=new Layui<Ls_Menu>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public Layui<Easybuy_Order> QbDd() {
		List<Easybuy_Order> list=dl.QbDd();
		int num=dl.SjZs();
		Layui<Easybuy_Order> layui=new Layui<Easybuy_Order>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public List<Ls_Role> QbJs() {
		// TODO Auto-generated method stub
		return dl.QbJs();
	}


	@Override
	public int PdLn(String logname) {
		// TODO Auto-generated method stub
		return dl.PdLn(logname);
	}


	@Override
	public int InZh(Easybuy_User eUser) {
		// TODO Auto-generated method stub
		return dl.InZh(eUser);
	}


	@Override
	public int DlZh(int uid) {
		// TODO Auto-generated method stub
		return dl.DlZh(uid);
	}


	@Override
	public List<Easybuy_User> SeZh(int uid) {
		// TODO Auto-generated method stub
		return dl.SeZh(uid);
	}


	@Override
	public int UpZh(Easybuy_User eUser) {
		// TODO Auto-generated method stub
		return dl.UpZh(eUser);
	}


	@Override
	public int PdJs(int uid) {
		// TODO Auto-generated method stub
		return dl.PdJs(uid);
	}


	@Override
	public int FzJs(int uid) {
		// TODO Auto-generated method stub
		return dl.FzJs(uid);
	}


	@Override
	public int YhJs(User_Role ur, int uid) {
		// TODO Auto-generated method stub
		return dl.YhJs(ur, uid);
	}


	@Override
	public Layui<Ls_Role> JzJs() {
		List<Ls_Role> list=dl.JzJs();
		int num=dl.SjZs();
		Layui<Ls_Role> layui=new Layui<Ls_Role>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public int Pdjs(String name) {
		// TODO Auto-generated method stub
		return dl.Pdjs(name);
	}


	@Override
	public int InJs(Ls_Role lr) {
		// TODO Auto-generated method stub
		return dl.InJs(lr);
	}


	@Override
	public int DlJs(int idd) {
		// TODO Auto-generated method stub
		return dl.DlJs(idd);
	}


	@Override
	public List<Ls_Role> idjs(int idd) {
		// TODO Auto-generated method stub
		return dl.idjs(idd);
	}


	@Override
	public int uapjs(Ls_Role lr, int idd) {
		// TODO Auto-generated method stub
		return dl.uapjs(lr, idd);
	}


	@Override
	public int QxName(String name) {
		// TODO Auto-generated method stub
		return dl.QxName(name);
	}


	@Override
	public int InsQx(Ls_Menu lm) {
		// TODO Auto-generated method stub
		return dl.InsQx(lm);
	}


	@Override
	public List<Ls_Butten> SeAn() {
		// TODO Auto-generated method stub
		return dl.SeAn();
	}


	@Override
	public List<Ls_Menu> QxPd(int idd) {
		// TODO Auto-generated method stub
		return dl.QxPd(idd);
	}


	@Override
	public int DlQx(int idd) {
		// TODO Auto-generated method stub
		return dl.DlQx(idd);
	}


	@Override
	public List<Ls_Menu> QxHx(int idd) {
		// TODO Auto-generated method stub
		return dl.QxHx(idd);
	}


	@Override
	public List<Ls_Menu> XgQxPd(int idd) {
		// TODO Auto-generated method stub
		return dl.XgQxPd(idd);
	}


	@Override
	public int XgQx(Ls_Menu lm, int idd) {
		// TODO Auto-generated method stub
		return dl.XgQx(lm, idd);
	}


	@Override
	public Layui<ShuZ> FpQx() {
		List<Ls_Menu> seleAllMenu = dl.FpQx();
		Layui<ShuZ> layui = new Layui<ShuZ>();
		layui.setCode(0);
		layui.setCount(0);
		layui.setMsg("");
		List<ShuZ> fenList = new ArrayList<ShuZ>();
		for (Ls_Menu lsmenu : seleAllMenu) {
			ShuZ fen = new ShuZ();
			fen.setId(lsmenu.getId());
			fen.setParentId(lsmenu.getMfatherid());
			fen.setTitle(lsmenu.getMname());
			fen.setCheckArr("0");
			fenList.add(fen);
		}
		layui.setData(fenList);
		return layui;
		}


	@Override
	public List<User_Menu> Fphx(int id) {
		// TODO Auto-generated method stub
		return dl.Fphx(id);
	}


	@Override
	public int FpSc(int id) {
		// TODO Auto-generated method stub
		return dl.FpSc(id);
	}


	@Override
	public int FpTj(int id,int qid) {
		// TODO Auto-generated method stub
		return dl.FpTj(id,qid);
	}


	@Override
	public Layui<Students> selAllList() {
		List<Students> list=dl.selAllList();
		int num=dl.SjZs();
		Layui<Students> layui=new Layui<Students>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public Layui<Students> selStuList(String lognames) {
		List<Students> list=dl.selStuList(lognames);
		int num=dl.SjZs();
		Layui<Students> layui=new Layui<Students>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public Layui<Students> selTeaList(String clasb) {
		List<Students> list=dl.selTeaList(clasb);
		int num=dl.SjZs();
		Layui<Students> layui=new Layui<Students>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public int Dlm(String loginName2, String password2) {
		// TODO Auto-generated method stub
		return dl.Dlm(loginName2, password2);
	}


	@Override
	public Easybuy_User dxzh(int uid) {
		// TODO Auto-generated method stub
		return dl.dxzh(uid);
	}


	@Override
	public int insqd(Students stu) {
		// TODO Auto-generated method stub
		return dl.insqd(stu);
	}


	@Override
	public int selqd(String logname, String time) {
		// TODO Auto-generated method stub
		return dl.selqd(logname, time);
	}


	@Override
	public Layui<Easybuy_User> selbj() {
		List<Easybuy_User> list=dl.selbj();
		int num=dl.SjZs();
		Layui<Easybuy_User> layui=new Layui<Easybuy_User>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}


	@Override
	public Layui<Easybuy_User> selUser(String bj) {
		List<Easybuy_User> list=dl.selUser(bj);
		int num=dl.SjZs();
		Layui<Easybuy_User> layui=new Layui<Easybuy_User>();

			layui.setCode(0);
			layui.setMsg("");
			
			layui.setCount(num);
			layui.setData(list);
			
		return layui;
	}

	
}