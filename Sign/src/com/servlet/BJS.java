package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_User;
import com.entity.Layui;
import com.entity.Students;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
import com.utils.PrintUtil;
import com.web.AbstractServlet;
@WebServlet("/BJS")
public class BJS extends AbstractServlet {

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
	
	public void bjxs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String clas=request.getParameter("clas");
		int role=Integer.parseInt(request.getParameter("role"));
		if(clas!=null) {
			if(role==1) {
				DengLuService dls=new DLServiceImpl();
				Layui<Easybuy_User> layui=dls.selbj();
				 PrintUtil.write(layui, response);
			}else if(role==2){
				DengLuService dls=new DLServiceImpl();
				Layui<Easybuy_User> layui=dls.selUser(clas);
				 PrintUtil.write(layui, response);
			}
			
		}
		
	}


	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return BJS.class;
	}

}
