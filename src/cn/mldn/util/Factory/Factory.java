package cn.mldn.util.Factory;

import cn.mldn.service.proxy.ServiceProxy;
import cn.mldn.util.ReadResources;

public class Factory {

	private static ReadResources DAO=new ReadResources("cn.mldn.util.resources.dao");
	private static ReadResources SERVICE=new ReadResources("cn.mldn.util.resources.service");
	private Factory() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T getDAOInstance(String name) {
		try {
			return (T) Class.forName(DAO.getMessage(name)).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getServiceInstance(String name) {
		try {
			return (T) new ServiceProxy().bind(Class.forName(SERVICE.getMessage(name)).newInstance());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) throws Exception{
//			IDeptServiceBack ser=Factory.getServiceInstance("dept.service");
//			System.out.println(ser.list());
//	}
}
