package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.abs.service.AbstractService;
import cn.mldn.dao.IDeptDAO;
import cn.mldn.service.IDeptServiceBack;
import cn.mldn.util.Factory.Factory;
import cn.mldn.vo.Dept;

public class DeptServiceImpl extends AbstractService implements IDeptServiceBack{

	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO dao=Factory.getDAOInstance("dept.dao");
		return dao.findAll();
	}

	@Override
	public boolean add(Dept vo) throws Exception {
		IDeptDAO dao=Factory.getDAOInstance("dept.dao");
		if(vo.getDname()==null||dao.findByName(vo.getDname())!=null) {
			return false;
		}else {
			vo.setDflag(0);
			return dao.doCreate(vo);
		}
	}

	@Override
	public boolean delete(Long id) throws Exception {
		IDeptDAO dao=Factory.getDAOInstance("dept.dao");
		return dao.doEditDflag(id, 1);
	}

	@Override
	public boolean edit(Dept vo) throws Exception {
		IDeptDAO dao=Factory.getDAOInstance("dept.dao");
		Dept olddept=dao.findByName(vo.getDname());
		if(olddept!=null) {
			if(olddept.getDeptno().equals(vo.getDeptno())) {
				return dao.doEdit(vo);
			}else {
				return false;
			}
		}else {
			return dao.doEdit(vo);
		}
	}

	@Override
	public Dept preEdit(Long id) throws Exception {
		IDeptDAO dao=Factory.getDAOInstance("dept.dao");
		return dao.findById(id);
	}
	
	
}
