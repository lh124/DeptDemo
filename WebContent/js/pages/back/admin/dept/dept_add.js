window.onload = function() {
	
	document.getElementById("deptForm").addEventListener("submit",function(event){
		if (!(validateDname() & validateLoc())) {
			event.preventDefault() ;
		}		
	},false) ;
	document.getElementById("dname").addEventListener("blur",validateDname,false) ;
	document.getElementById("loc").addEventListener("blur",validateLoc,false) ;
} 
function validateDname() {
	return validateEmpty("dname") ;
}
function validateLoc() {
	return validateEmpty("loc") ;
}