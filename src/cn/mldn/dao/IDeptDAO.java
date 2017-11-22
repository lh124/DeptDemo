package cn.mldn.dao;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Dept;

public interface IDeptDAO extends IDAO<Long,Dept>  {
/**
 * 根据部门名称 查询dept表的完整数据
 * @param name 部门名称
 * @return 如果不存在 返回null 
 * @throws Exception
 */
	public Dept findByName(String name)throws Exception;
	/**
	 * 
	 * 逻辑删除 更新指定部门的标记信息
	 * @param id 
	 * @param dflag
	 * @return
	 * @throws Exception
	 */
	public boolean doEditDflag(Long id,int dflag) throws Exception;
	
	
	
}
