package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_Order;
import com.entity.Easybuy_User;
import com.entity.Layui;
import com.entity.Ls_Menu;
import com.entity.Ls_Role;
import com.entity.Students;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
import com.utils.PrintUtil;
import com.web.AbstractServlet;

/**
 * Servlet implementation class FJN
 */
@WebServlet("/FJN")
public class FJN extends AbstractServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FJN() {
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
	public void sjzx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		DengLuService dls=new DLServiceImpl();
		Layui<Easybuy_User> layui=dls.FhJson();
		
		
		PrintUtil.write(layui, response);
	}

	public void qxgl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		DengLuService dls=new DLServiceImpl();
		Layui<Ls_Menu> layui=dls.QxZs();
		PrintUtil.write(layui, response);
        
	}
	public void qdgl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		DengLuService dls=new DLServiceImpl();
		Layui<Easybuy_Order> layui=dls.QbDd();
		PrintUtil.write(layui, response);
        
	}
	public void jsgl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		DengLuService dls=new DLServiceImpl();
		Layui<Ls_Role> layui=dls.JzJs();
		PrintUtil.write(layui, response);
        
	}
	
	public void qdaogl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int roleb=Integer.parseInt(request.getParameter("role"));
		String clasb=request.getParameter("clas");
		String lognames=request.getParameter("logname");
		if(roleb==1) {
			DengLuService dls=new DLServiceImpl();
			Layui<Students> layui=dls.selAllList();
			PrintUtil.write(layui, response);
		}else if(roleb==2) {
			DengLuService dls=new DLServiceImpl();
			Layui<Students> layui=dls.selTeaList(clasb);
			PrintUtil.write(layui, response);
		}else if(roleb==3) {
			DengLuService dls=new DLServiceImpl();
			Layui<Students> layui=dls.selStuList(lognames);
			PrintUtil.write(layui, response);
		}
		
        
	}
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return FJN.class;
	}
	

}
