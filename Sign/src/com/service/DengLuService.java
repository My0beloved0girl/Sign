package com.service;

import java.util.List;

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

public interface DengLuService {
	
	//登录
		public int Dl(String loginName2,String password2);
		//登录
		public int Dlm(String loginName2,String password2);
		//获取登录用户的所有信息
		public List<Easybuy_User> Hqzh(int uid);
		//获取登录用户的所有信息
		public Easybuy_User dxzh(int uid);
				
		//判断级别
		public int Pd(int userid2);
		
		//展现
		public List<Ls_Menu> Zx(int roleid);
		
		//查找按钮
		public List<Ls_Menu> An(int mfid,int uid);
		
		//查询所有用户数据
		public Layui<Easybuy_User> FhJson();
		
		//查询总数
		public int SjZs();
		
		//搜索查询
		public Layui<Easybuy_User> SsCx(String name);
		
		//查询所有权限
		public Layui<Ls_Menu> QxZs();
		
		//查询所有订单
		public Layui<Easybuy_Order> QbDd();
		
		//查询所有角色
		public List<Ls_Role> QbJs();
		
		//判断账号名是否重复
		public int PdLn(String logname);
		
		//新增用户
		public int InZh(Easybuy_User eUser);
		
		//删除用户
		public int DlZh(int uid);
		

		//查询id对应账号
		public List<Easybuy_User> SeZh(int uid);
		
		//修改用户
		public int UpZh(Easybuy_User eUser);
		
		//判断用户是否有角色
		public int PdJs(int uid);
		
		//根据用户id赋给下拉框
		public int FzJs(int uid);
		
		//修改用户的时同时修改角色
		public int YhJs(User_Role ur,int uid);
		
		//查询所有角色J
		public Layui<Ls_Role> JzJs();	
		
		//验证角色是否重复
		public int Pdjs(String name);
		
		//增加角色
		public int InJs(Ls_Role lr);
		
		//删除角色
		public int DlJs(int idd);
		
		//根据id获取角色
		public List<Ls_Role> idjs(int idd);
		
		//修改角色
		public int uapjs(Ls_Role lr,int idd);
		
		//验证权限名是否存在
		public int QxName(String name);
		
		//新增权限
		public int InsQx(Ls_Menu lm);
		
		//查询所有按钮
		public List<Ls_Butten> SeAn();
		
		//根据类型查找上级
		public List<Ls_Menu> QxPd(int idd);
		
		//删除权限
		public int DlQx(int idd);
		
		//根据id回显权限
		public List<Ls_Menu> QxHx(int idd);
		
		//根据类型查找上级(修改)
		public List<Ls_Menu> XgQxPd(int idd);
		
		//修改权限
		public int XgQx(Ls_Menu lm,int idd);
		
		//分配权限用到layui
		public Layui<ShuZ> FpQx();
		
		//分配回显
		public List<User_Menu> Fphx(int id);
		
		//分配功能
		//1.删除全部
		public int FpSc(int id);
		//2.添加所选的
		public int FpTj(int id,int qid);
		
		
		
		//查询所有签到用户
		public Layui<Students> selAllList();
		//根据学生查询自身的签到
		public Layui<Students> selStuList(String lognames);
		//根据老师查询签到的学生
		public Layui<Students> selTeaList(String clasb);
		
		
		//点击签到
		public int insqd(Students stu);
		
		//判断今日是否签到过
		public int selqd(String logname,String time);
		
		//查看所有班级
		public Layui<Easybuy_User> selbj();
		
		//查看班级对应的学生
		public Layui<Easybuy_User> selUser(String bj);
}
