<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="cn.mldn.util.Factory.Factory"%>
<%@page import="cn.mldn.service.IDeptServiceBack"%>
<%@ page import="cn.mldn.vo.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>

<%
request.setCharacterEncoding("UTF-8");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
    //String dept_add_url=basePath+"pages/back/admin/dept/dept_add.jsp";
%>

<%!
int count=0;
%>
<%
//3秒后跳到doc1.html界面
	//response.setHeader("refresh","10;URL=h.jsp");
	response.setHeader("refresh","3;URL=http://192.168.28.93/DeptProject/pages/back/admin/dept/dept_list.jsp");
%>

<body>
                                                 
<%
	 
		String msg="部门信息修改失败";
		IDeptServiceBack serb=Factory.getServiceInstance("dept.service");
		Dept vo=new Dept();
		vo.setDeptno(Long.parseLong(request.getParameter("deptno")));
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		if(serb.edit(vo)){
			msg="部门信息修改成功";
		}
%>

<h1><%=msg %></h1>
<h1><%=count++ %></h1>

</body>
</html>