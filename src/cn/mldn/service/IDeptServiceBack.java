package cn.mldn.service;

import java.util.List;

import cn.mldn.vo.Dept;

public interface IDeptServiceBack {
	/**
	 * 部门列表显示
	 * @return
	 * @throws Exception
	 */
	public List<Dept> list()throws Exception;
	/**
	 * 增加部门数据
	 * 增加数据的部门名称不能重复
	 * 
	 * @param vo vo对象
	 * @return
	 * @throws Exception
	 */
	public boolean add(Dept vo) throws Exception;
	/**
	 * 删除单条数据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Long id)throws Exception;
	/**
	 * 修改数据 
	 * 判断部门名称是否重复  
	 * 可以只修改部门位置，或者同时修改部门名称
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean edit(Dept vo) throws Exception ;
	/**
	 *回填  根据
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Dept preEdit(Long id) throws Exception;
	
	
}
