window.onload=function(){
	document.getElementById("addBtn").addEventListener("click",function(){
		
		window.location="pages/back/admin/dept/dept_add.jsp";
	},false);
	
	document.getElementById("editBtn").addEventListener("click",function(){
		window.location="pages/back/admin/dept/dept_edit.jsp";
		
	},false);
	
}