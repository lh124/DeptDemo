/**
 * 是判断给定的元素名称的内容是否为空，如果内容为空，则在元素对应的层上显示错误信息，如果正确则显示通过的信息
 */
function validateEmpty(eleId) {
	divObject = document.getElementById(eleId + "Div") ;
	obj = document.getElementById(eleId) ;	
	if (obj != null) {
		if (obj.value != "") {
			divObject.className = "form-group has-success" ;
			return true ;
		} else {
			divObject.className = "form-group has-error" ;
			return false ;
		}
	}
}
/**
 * 是判断给定的元素名称的内容是否满足指定正则规则，如果不满足则在元素对应的层上显示错误信息，如果正确则显示通过的信息
 */
function validateRegex(eleId,regex) {
	if (validateEmpty(eleId)) {	// 首先进行是否为空的验证
		obj = document.getElementById(eleId) ;
		divObject = document.getElementById(eleId + "Div") ;
		if (regex.test(obj.value)) {	// 正则验证
			divObject.className = "form-group has-success" ;
			return true ;
		} else {
			divObject.className = "form-group has-error" ;
			return false ;
		}
	}
}