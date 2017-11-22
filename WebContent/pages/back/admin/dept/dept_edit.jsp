<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*" %>
<%@ page import="cn.mldn.service.*" %>
<%@ page import="cn.mldn.util.Factory.*" %>
<%
request.setCharacterEncoding("UTF-8");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	//String edit_url=basePath+"pages/back/admin/dept/dept_edit_do.jsp";
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
<script type="text/javascript" src="js/pages/back/admin/dept/dept_edit.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
IDeptServiceBack ser=Factory.getServiceInstance("dept.service");
//Dept vo =ser.preEdit(Long.parseLong(request.getParameter("deptno")));
request.setAttribute("deptno", request.getParameter("deptno"));
request.setAttribute("dname", request.getParameter("dname"));
request.setAttribute("loc", request.getParameter("loc"));
%>

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="pages/back/admin/dept/dept_edit_do.jsp" method="post" class="form-horizontal" id="deptForm">
					<fieldset>
						<legend>
							<label>修改部门信息</label>
						</legend>
						<div class="form-group" id="dnameDiv">
							<label class="col-md-2 control-label" for="dname">部门名称：</label>
							<div class="col-md-5">
								<input type="text" id="dname" name="dname" class="form-control" value="<%=request.getAttribute("dname") %>">
							</div>
							<span class="col-md-5" id="dnameSpan">*</span>
						</div>
						<div class="form-group" id="locDiv">
							<label class="col-md-2 control-label" for="loc">部门位置：</label>
							<div class="col-md-5">
								<input type="text" id="loc" name="loc" class="form-control" value="<%=request.getAttribute("loc") %>">
							</div>
							<span class="col-md-5" id="locSpan">*</span>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
							<input type="hidden" name="deptno" value="<%=request.getAttribute("deptno") %>">
								<input type="submit" value="提交" class="btn btn-primary">
								<input type="reset" value="重置" class="btn btn-warning">
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>