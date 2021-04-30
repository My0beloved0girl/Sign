package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_User;
import com.entity.Ls_Menu;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
@WebServlet("/JBS")
public class JBS extends HttpServlet {

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
		
		int userid=Integer.parseInt(request.getParameter("id"));
		int userid2=Integer.parseInt(request.getParameter("nid"));
		//System.out.println(userid);
		DengLuService dls=new DLServiceImpl();
		
		List<Ls_Menu> list=null;
		List<Easybuy_User> list2=null;
		if(userid>0){
			list=dls.Zx(userid);
			list2=dls.Hqzh(userid2);
			request.setAttribute("uid", userid2);
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("chushi/chushi.jsp").forward(request, response);
		}
	}

}
