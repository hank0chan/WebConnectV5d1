/**
 * 
 */
package cn.hankchan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hankchan.dao.RootDao;
import cn.hankchan.po.Root;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:21:42
 * 类说明:
 */
@Service
public class RootService {

	@Autowired
	private RootDao rootDao;
	/**
	 * 增加Root管理员
	 * @param root
	 * @return
	 * @throws Exception
	 */
	public boolean addRoot(Root root) throws Exception {
		return rootDao.addRoot(root);
	}
	/**
	 * 根据Root的username删除Root管理员
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRootByUsername(String username) throws Exception {
		return rootDao.deleteRootByUsername(username);
	}
	/**
	 * 根据Root的username修改password
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean updatePasswordByUsername(String username, String password) throws Exception {
		return rootDao.updatePasswordByUsername(username, password);
	}
	/**
	 * 根据Root的username修改权限等级（最高级的Root管理员才有权利操作）
	 * @param username
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public boolean updateLevelByUsername(String username, String level) throws Exception {
		return rootDao.updateLevelByUsername(username, level);
	}
	/**
	 * 根据Root的username获取Root
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Root getRootByUsername(String username) throws Exception {
		return rootDao.getRootByUsername(username);
	}
	/**
	 * 获取所有Root管理员的信息
	 * @return
	 * @throws Exception
	 */
	public List<Root> getRootList() throws Exception {
		return rootDao.getRootList();
	}
}
