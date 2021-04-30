package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_Order;
import com.entity.Easybuy_User;
import com.entity.Layui;
import com.entity.Ls_Butten;
import com.entity.Ls_Menu;
import com.entity.Ls_Role;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;

/**
 * Servlet implementation class FJN
 */
@WebServlet("/QXS")
public class QXS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QXS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public int qxname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("mname");
		DengLuService dls=new DLServiceImpl();
		int num=dls.QxName(name);
		
		return num;
	}
	
	public List<Ls_Butten> sean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		DengLuService dls=new DLServiceImpl();
		List<Ls_Butten> list=dls.SeAn();
		
		return list;
	}
	
	public List<Ls_Menu> qxpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		List<Ls_Menu> list=null;
		if(request.getParameter("type")!=null) {
			int idd=Integer.parseInt(request.getParameter("type"));
			DengLuService dls=new DLServiceImpl();
			list=dls.QxPd(idd);
		}
		
		return list;
	}

	public int insqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String mname=request.getParameter("mname");
		int type=Integer.parseInt(request.getParameter("type2"));
		int mfatherid=Integer.parseInt(request.getParameter("father"));
		String url=request.getParameter("mfunction");
		String buttom=request.getParameter("mbtn");
	
		
		Ls_Menu lm=new Ls_Menu();
		lm.setMname(mname);
		lm.setMfatherid(mfatherid);
		lm.setType(type);
		lm.setUrl(url);
		lm.setButtom(buttom);
		DengLuService dls=new DLServiceImpl();
		int num=dls.InsQx(lm);
		
		return num;
	}
	
	public int dlqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int idd=Integer.parseInt(request.getParameter("menuid"));
		DengLuService dls=new DLServiceImpl();
		int num=dls.DlQx(idd);
		
		return num;
	}
	
	public ReturnResult qxhx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int idd=Integer.parseInt(request.getParameter("menuid"));
		ReturnResult result = new ReturnResult();
		DengLuService dls=new DLServiceImpl();
		List<Ls_Menu> list=dls.QxHx(idd);
		result.returnSuccess(list);
		return result;
	}
	
	public ReturnResult xgqxpd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		ReturnResult result = new ReturnResult();
		List<Ls_Menu> list=null;
		if(request.getParameter("id")!=null) {
			int idd=Integer.parseInt(request.getParameter("id"));
			DengLuService dls=new DLServiceImpl();
			list=dls.XgQxPd(idd);
		}
		result.returnSuccess(list);
		return result;
	}
	
	public int xgqx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");


		int idd=Integer.parseInt(request.getParameter("mid"));
		String mname=request.getParameter("mname");
		int type=Integer.parseInt(request.getParameter("type2"));
		int mfatherid=Integer.parseInt(request.getParameter("father"));
		String url=request.getParameter("mfunction");
		String buttom=request.getParameter("mbtn");
		
		/*
		 * System.out.println(idd); System.out.println(mname); System.out.println(type);
		 * System.out.println(mfatherid); System.out.println(url);
		 * System.out.println(buttom);
		 */
		
		
		Ls_Menu lm=new Ls_Menu();
		lm.setMname(mname);
		lm.setMfatherid(mfatherid);
		lm.setType(type);
		lm.setUrl(url);
		lm.setButtom(buttom);
		DengLuService dls=new DLServiceImpl();
		int num=dls.XgQx(lm, idd);
	
		return num;
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QXS.class;
	}
	

}
