<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
</head>
<body>
<%
	Dept vo = new Dept() ;
	vo.setDeptno(10L) ;
%>
<%=vo.getDeptno()%>
</body>
</html>