package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.abs.dao.AbstractDeptDAO;
import cn.mldn.dao.IDeptDAO;
import cn.mldn.vo.Dept;

public class IDeptDAOImpl extends AbstractDeptDAO implements IDeptDAO{

	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql="insert into dept (dname,loc,dflag) value (?,?,?)";
		super.per=super.conn.prepareStatement(sql);
		super.per.setString(1, vo.getDname());
		super.per.setString(2, vo.getLoc());
		super.per.setInt(3, 0);
		return super.per.executeUpdate()>0;
	}

	@Override
	public boolean doEdit(Dept vo) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=? and dflag=0";
		super.per=super.conn.prepareStatement(sql);
		super.per.setString(1,vo.getDname());
		super.per.setString(2, vo.getLoc());
		super.per.setLong(3,vo.getDeptno());
		
		return super.per.executeUpdate()>0;
	}

	@Override
	public boolean doRemove(Long id) throws SQLException {
		String sql="delete from dept where deptno=? and dflag=1";
		super.per=super.conn.prepareStatement(sql);
		super.per.setLong(1, id);
		return super.per.executeUpdate()>0;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all=new ArrayList<Dept>();
		String sql="select deptno,dname,loc,dflag from dept where dflag=0";
		super.per=super.conn.prepareStatement(sql);
		ResultSet rs=super.per.executeQuery();
		while(rs.next()) {
			Dept vo=new Dept();
			vo.setDeptno(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.setDflag(rs.getInt(4));
			all.add(vo);
		}

		return all;
	}

	@Override
	public Dept findByName(String name) throws Exception {
		String  sql="select deptno,dname,loc,dflag from dept where dname=? and dflag=0";
		super.per=super.conn.prepareStatement(sql);
		super.per.setString(1, name);
		ResultSet rs=super.per.executeQuery();
		Dept vo=null;
		while(rs.next()) {
			vo=new Dept();
			vo.setDeptno(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.setDflag(rs.getInt(4));
		}
		return vo;
	}

	@Override
	public Dept findById(Long id) throws SQLException {
		String  sql="select deptno,dname,loc,dflag from dept where deptno=? and dflag=0";
		super.per=super.conn.prepareStatement(sql);
		super.per.setLong(1, id);
		ResultSet rs=super.per.executeQuery();
		Dept vo=null;
		while(rs.next()) {
			vo=new Dept();
			vo.setDeptno(rs.getLong(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			vo.setDflag(rs.getInt(4));
		}
		return vo;
		
		
	}

	
	@Override
	public boolean doEditDflag(Long id, int dflag) throws Exception {
		String sql="update dept set dflag=? where deptno=?";
		super.per=super.conn.prepareStatement(sql);
		super.per.setInt(1, dflag);
		super.per.setLong(2, id);
		return super.per.executeUpdate()>0;
	}

}
