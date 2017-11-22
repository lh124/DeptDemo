package cn.mldn.util;

import java.util.ResourceBundle;
/**
 * 工具类 读取资源文件
 * @author Administrator
 *
 */
public class ReadResources {

	ResourceBundle rs=null;
	public ReadResources(String baseName) {
		if(baseName.contains(".")) {
			this.rs=ResourceBundle.getBundle(baseName);
		}else {
			this.rs=ResourceBundle.getBundle("cn.mldn.util.resources."+baseName);
		}
	}
	
	public String getMessage(String key) {
		try {
			String str=this.rs.getString(key);
			return str;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
