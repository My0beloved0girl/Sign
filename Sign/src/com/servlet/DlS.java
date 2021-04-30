package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_User;
import com.entity.User_Role;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;

@WebServlet("/DlS")
public class DlS extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String loginName=request.getParameter("name");
		//System.out.println(loginName);
		String password=request.getParameter("pwd");
		
		DengLuService dls=new DLServiceImpl();
		Easybuy_User eu=new Easybuy_User();
		//System.out.println(eu.getId());
		int num=dls.Dl(loginName, password);
		int num2=dls.Dlm(loginName, password);
		if(num>0){
			request.getRequestDispatcher("JBS?id="+num+"&nid="+num2+"").forward(request, response);
		}
		
		
	}

}
