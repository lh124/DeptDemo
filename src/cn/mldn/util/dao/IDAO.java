package cn.mldn.util.dao;

import java.sql.SQLException;
import java.util.List;


public interface IDAO<K,V> {
/**
 *添加部门数据
 * @param vo dept
 * @return 没有数据返回 null
 * @throws SQLException
 */
	public boolean doCreate(V vo)throws SQLException;
	/**
	 * 修改部门数据
	 * @param vo
	 * @return
	 * @throws SQLException
	 */
	public boolean doEdit(V vo)throws SQLException;
	/**
	 * 删除数据 根据Id删除
	 * 一次只能删除一条数据
	 * 不能批量删除
	 * 删除采用逻辑删除 根据dflag=1删除 如果dflag=0 则没有删除 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean doRemove(K id)throws SQLException;
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public V findById(K id) throws SQLException;
	/**
	 * 查询数据全部  dflag=0的数据全部显示
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<V> findAll()throws SQLException;
	
	
	
}
