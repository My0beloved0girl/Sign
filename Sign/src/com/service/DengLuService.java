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
	
	//��¼
		public int Dl(String loginName2,String password2);
		//��¼
		public int Dlm(String loginName2,String password2);
		//��ȡ��¼�û���������Ϣ
		public List<Easybuy_User> Hqzh(int uid);
		//��ȡ��¼�û���������Ϣ
		public Easybuy_User dxzh(int uid);
				
		//�жϼ���
		public int Pd(int userid2);
		
		//չ��
		public List<Ls_Menu> Zx(int roleid);
		
		//���Ұ�ť
		public List<Ls_Menu> An(int mfid,int uid);
		
		//��ѯ�����û�����
		public Layui<Easybuy_User> FhJson();
		
		//��ѯ����
		public int SjZs();
		
		//������ѯ
		public Layui<Easybuy_User> SsCx(String name);
		
		//��ѯ����Ȩ��
		public Layui<Ls_Menu> QxZs();
		
		//��ѯ���ж���
		public Layui<Easybuy_Order> QbDd();
		
		//��ѯ���н�ɫ
		public List<Ls_Role> QbJs();
		
		//�ж��˺����Ƿ��ظ�
		public int PdLn(String logname);
		
		//�����û�
		public int InZh(Easybuy_User eUser);
		
		//ɾ���û�
		public int DlZh(int uid);
		

		//��ѯid��Ӧ�˺�
		public List<Easybuy_User> SeZh(int uid);
		
		//�޸��û�
		public int UpZh(Easybuy_User eUser);
		
		//�ж��û��Ƿ��н�ɫ
		public int PdJs(int uid);
		
		//�����û�id����������
		public int FzJs(int uid);
		
		//�޸��û���ʱͬʱ�޸Ľ�ɫ
		public int YhJs(User_Role ur,int uid);
		
		//��ѯ���н�ɫJ
		public Layui<Ls_Role> JzJs();	
		
		//��֤��ɫ�Ƿ��ظ�
		public int Pdjs(String name);
		
		//���ӽ�ɫ
		public int InJs(Ls_Role lr);
		
		//ɾ����ɫ
		public int DlJs(int idd);
		
		//����id��ȡ��ɫ
		public List<Ls_Role> idjs(int idd);
		
		//�޸Ľ�ɫ
		public int uapjs(Ls_Role lr,int idd);
		
		//��֤Ȩ�����Ƿ����
		public int QxName(String name);
		
		//����Ȩ��
		public int InsQx(Ls_Menu lm);
		
		//��ѯ���а�ť
		public List<Ls_Butten> SeAn();
		
		//�������Ͳ����ϼ�
		public List<Ls_Menu> QxPd(int idd);
		
		//ɾ��Ȩ��
		public int DlQx(int idd);
		
		//����id����Ȩ��
		public List<Ls_Menu> QxHx(int idd);
		
		//�������Ͳ����ϼ�(�޸�)
		public List<Ls_Menu> XgQxPd(int idd);
		
		//�޸�Ȩ��
		public int XgQx(Ls_Menu lm,int idd);
		
		//����Ȩ���õ�layui
		public Layui<ShuZ> FpQx();
		
		//�������
		public List<User_Menu> Fphx(int id);
		
		//���书��
		//1.ɾ��ȫ��
		public int FpSc(int id);
		//2.�����ѡ��
		public int FpTj(int id,int qid);
		
		
		
		//��ѯ����ǩ���û�
		public Layui<Students> selAllList();
		//����ѧ����ѯ�����ǩ��
		public Layui<Students> selStuList(String lognames);
		//������ʦ��ѯǩ����ѧ��
		public Layui<Students> selTeaList(String clasb);
		
		
		//���ǩ��
		public int insqd(Students stu);
		
		//�жϽ����Ƿ�ǩ����
		public int selqd(String logname,String time);
		
		//�鿴���а༶
		public Layui<Easybuy_User> selbj();
		
		//�鿴�༶��Ӧ��ѧ��
		public Layui<Easybuy_User> selUser(String bj);
}
