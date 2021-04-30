package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Easybuy_User;
import com.entity.Layui;
import com.entity.Ls_Role;
import com.entity.User_Role;
import com.service.DengLuService;
import com.service.impl.DLServiceImpl;
import com.utils.PrintUtil;
import com.utils.ReturnResult;
import com.web.AbstractServlet;
@WebServlet("/ZHS")
public class ZHS extends AbstractServlet {
	private static final long serialVersionUID = 1L;
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
	
	//�������н�ɫ
	public ReturnResult qbjs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");	
		ReturnResult result = new ReturnResult();
		DengLuService dls=new DLServiceImpl();
		List<Ls_Role> list=dls.QbJs();
		result.returnSuccess(list);
		return result;
			}
	
	//�����˺�
	public void sszh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("uname");

		DengLuService dls=new DLServiceImpl();
		Layui<Easybuy_User> layui=dls.SsCx(name);
		
		PrintUtil.write(layui, response);
			}
	
	//�жϵ�¼���Ƿ��ظ�
	public int pdln(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String logname=request.getParameter("uname");
		ReturnResult result = new ReturnResult();
		DengLuService dls=new DLServiceImpl();
		int num=dls.PdLn(logname); 
		return num;
			}

	//����˺�
	public int inzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("name");
		String password=request.getParameter("pass");
		String loginName=request.getParameter("realName");
		int sex=Integer.parseInt(request.getParameter("sex"));
		String identityCode=request.getParameter("sfz");
		String email=request.getParameter("email");
		String mobile=request.getParameter("phone");
		String clas=request.getParameter("banji");
		int type=Integer.parseInt(request.getParameter("role"));
		
		
		ReturnResult result = new ReturnResult();
		DengLuService dls=new DLServiceImpl();
		Easybuy_User eu=new Easybuy_User();
		
		eu.setUserName(loginName);
		eu.setPassword(password);
		eu.setLoginName(userName);
		eu.setSex(sex);
		eu.setIdentityCode(identityCode);
		eu.setEmail(email);
		eu.setMobile(mobile);
		eu.setClas(clas);
		eu.setRole(type);
		
		
		
		 int num=dls.InZh(eu); 
		return num;
			}

	//ɾ���˺�
	public int dlzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		int uid=Integer.parseInt(request.getParameter("userid"));
		DengLuService dls=new DLServiceImpl();
		int num=dls.DlZh(uid); 
		return num;
			}
	
	
	//��ѯid�˺�
		public ReturnResult sezh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			ReturnResult result = new ReturnResult();
			int uid=Integer.parseInt(request.getParameter("userid"));
			DengLuService dls=new DLServiceImpl();
			List<Easybuy_User> list=dls.SeZh(uid); 
			
			
			result.returnSuccess(list);
			return result;
				}
		
	//�����û�id��ѯ��ɫ
		public int pdjs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			
			int uid=Integer.parseInt(request.getParameter("userid"));
			DengLuService dls=new DLServiceImpl();
			int num=dls.PdJs(uid); 
		
			return num;
				}
		
		//�����û�id��ѯ��ɫ
				public int fzjs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
					response.setContentType("text/html;charset=utf-8");
					request.setCharacterEncoding("utf-8");
					
					int uid=Integer.parseInt(request.getParameter("userid"));
					DengLuService dls=new DLServiceImpl();
					int num=dls.FzJs(uid); 
					
					return num;
						}
				
				//�޸Ľ�ɫ
				public int upzh(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
					response.setContentType("text/html;charset=utf-8");
					request.setCharacterEncoding("utf-8");
					
					int id=Integer.parseInt(request.getParameter("uid"));
					String userName=request.getParameter("name");
					String password=request.getParameter("pass");
					String loginName=request.getParameter("realName");
					int sex=Integer.parseInt(request.getParameter("sex"));
					String identityCode=request.getParameter("sfz");
					String email=request.getParameter("email");
					String mobile=request.getParameter("phone");
					String clas=request.getParameter("banji");
					int role=Integer.parseInt(request.getParameter("role"));
					int type=Integer.parseInt(request.getParameter("isStatus"));
					
					
					
					DengLuService dls=new DLServiceImpl();
					Easybuy_User eu=new Easybuy_User();
					User_Role ur=new User_Role();
					
					eu.setId(id);
					eu.setClas(clas);
					eu.setUserName(loginName);
					eu.setPassword(password);
					eu.setLoginName(userName);
					eu.setSex(sex);
					eu.setIdentityCode(identityCode);
					eu.setEmail(email);
					eu.setMobile(mobile);
					eu.setType(type);
					eu.setRole(role);
					

					 int num=dls.UpZh(eu);

					 return num;
					
					}	
				
	
	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return ZHS.class;
	}

}
