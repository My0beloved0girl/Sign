<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhanxian.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  </head>






<body class="layui-layout-body">


    
    
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <input type="hidden" class="uid" value="${uid}"/>
 			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
     <c:forEach items="${list}" var="li">
    	<c:if test="${li.type==1}">
    		  
    		    <li class="layui-nav-item">
    		 <a class="" href="javascript:;">${li.mname}</a>
    		<c:forEach items="${list}" var="ln">
	    			<c:if test="${ln.mfatherid==li.id}">
	    				 <dl class="layui-nav-child">
	    				<%-- <a href="${ln.url}?id=${ln.id}">${ln.mname}</a> --%>
	    				<dd><a href="javaScript:void(0)" onclick="demo('${ln.url}','${ln.id}')">${ln.mname}</a></dd>	
	    				 </dl>
	    			</c:if>
	    		</c:forEach>
	    		</li>
    				
    	</c:if>
    </c:forEach>
    </ul>
 	</div>
  </div>
  
  
  <div class="layui-body" id="jbdiv" >
  
    <!-- 内容主体区域 -->
    <input type="text" id="loginName" value="${user.id }" style="display:none"/>
    
   <div class="layuimini-container">
	<div class="layuimini-main">
		<blockquote class="layui-elem-quote quoteBox">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="uname" id="likename" class="layui-input" placeholder="请输入查找的登录名" />
				</div>
			</div>
			<div class="layui-inline">
				<button type="button" class="layui-btn" lay-filter="doSubmit" id="doSubmit">
		            <i class="layui-icon layui-icon-search layui-icon-normal"></i>搜索
				</button>
			</div> 
			
		</blockquote> 
		
		
		
		<table id="newsList" lay-filter="newsList"></table>
		
	<script type="text/html" id="toolbarDemo">  
		<div class="layui-btn-container">
				<c:forEach items="${list3}" var="ls">
					${ls.buttom}

				</c:forEach>
				
			
		</div> 
		
	 </script> 
<!--    	  
   	 	<table class="layui-hide" id="test" lay-filter="test"></table> -->
		
	</div>
</div>
    
</div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>

</body>
</html>




