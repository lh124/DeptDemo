<%@page import="javax.swing.text.StyledEditorKit.ItalicAction"%>
<%@page import="cn.mldn.util.Factory.Factory"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.service.*" %>
<%@ page import="java.util.*" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String delete_url=basePath+"pages/back/admin/dept/dept_delete_do.jsp";

%>


<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP + 业务层实现部门管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_list.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
	 IDeptServiceBack ser=Factory.getServiceInstance("dept.service");
	 List<Dept> all=ser.list();
	 Iterator<Dept> it=all.iterator();
	 
%>

	<div class="container">
		<div class="row">
			<div class="h1"><strong><span class="glyphicon glyphicon-th-list"></span>&nbsp;部门信息列表</strong></div>
		</div>
		<div class="row">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门位置</td>
					<td>操作</td>
				</tr>
				<%
				while(it.hasNext()){
					Dept vo=it.next(); 
				%>
				
				<tr>
					<td><%=vo.getDeptno() %></td>
					<td><%=vo.getDname() %></td>
					<td><%=vo.getLoc() %></td> 
					<td>
					<button id="editBtn" class="btn btn-success btn-xs">
						<span class="glyphicon "></span>&nbsp;<a href="pages/back/admin/dept/dept_edit.jsp?deptno=<%=vo.getDeptno() %>&dname=<%=vo.getDname() %>&loc=<%=vo.getLoc() %>" >修改部门信息</a>
					</button>
					<button id="deleteBtn" class="btn btn-danger btn-xs">
						<span class="glyphicon glyphicon-trash"></span>&nbsp;<a href="<%=delete_url%>?deptno=<%=vo.getDeptno() %>" >删除部门信息</a>
					</button>
					
					</td>
				</tr>
				
		 <%} %> 
			
			</table>
				<button id="addBtn" class="btn  btn-info btn-lg">
						<span class="glyphicon"></span>&nbsp;增加部门信息
				</button>
				
		</div>
	</div>
</body>
</html>