package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_User;
import com.entity.Students;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
import com.web.AbstractServlet;
@WebServlet("/QDS")
public class QDS extends AbstractServlet {

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
	
	public int insqd(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		DengLuService dl=new DLServiceImpl();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		Easybuy_User eu=dl.dxzh(uid);
		int num=dl.selqd(eu.getLoginName(), time.format(new Date()));
		int tjia=0;

		if(num!=1) {
			Students stu=new Students();
			
			stu.setName(eu.getUserName());
			stu.setLogname(eu.getLoginName());
			
			stu.setSignTime(df.format(new Date()));// new Date()为获取当前系统时间
			stu.setSex(eu.getSex());
			stu.setClas(eu.getClas());
			stu.setRole(eu.getRole());
			tjia=dl.insqd(stu);

		}
		
		return tjia;
			}


	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return QDS.class;
	}

}
