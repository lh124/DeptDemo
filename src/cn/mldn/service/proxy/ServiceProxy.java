package cn.mldn.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.dbc.BaseConnection;

public class ServiceProxy  implements InvocationHandler{

	private  Object obj;
	public Object bind(Object obj) {
		this.obj=obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}
	
	public static boolean changeMethod(String method) {
		return method.startsWith("add")||
				method.startsWith("edit")||
				method.startsWith("delete");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(changeMethod(method.getName())) {
			BaseConnection.getConnection().setAutoCommit(false);
		}
		Object reobj=null;
		try {
			reobj=method.invoke(obj, args);
			if(changeMethod(method.getName())) {
				BaseConnection.getConnection().commit();
			}
		}catch(Exception e) {
			if(changeMethod(method.getName())) {
				BaseConnection.getConnection().rollback();
			}
			e.printStackTrace();
		}finally {
			BaseConnection.close();
		}
		return reobj;
	}
}
