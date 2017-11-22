package cn.mldn.abs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.mldn.dbc.BaseConnection;

public abstract class AbstractDeptDAO {
	protected PreparedStatement per;
	protected Connection  conn;
	public AbstractDeptDAO() {
		this.conn=BaseConnection.getConnection();
	}
	
	
}
