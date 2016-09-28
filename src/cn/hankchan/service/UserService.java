/**
 * 
 */
package cn.hankchan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hankchan.dao.impl.UserDaoImpl;
import cn.hankchan.po.User;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:21:16
 * 类说明:
 */
@Service
public class UserService {

	@Autowired
	private UserDaoImpl userDao;
	
	/**
	 * 获取所有用户信息
	 */
	public List<User> getAllUsers() throws Exception{
		return userDao.getAllUsers();
	}
	/**
	 * 根据Id获取用户名
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getUsernameById(int id) throws Exception {
		return userDao.getUsernameById(id);
	}
	/**
	 * 获取用户状态为 1 的用户信息
	 */
	public List<User> getUserListOnLine() throws Exception{
		return userDao.getUserListOnLine();
	}
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExistsId(int id) throws Exception{
		return userDao.isExistsId(id);
	}
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExists(String username) throws Exception{
		return userDao.isExists(username);
	}
	/**
	 * 根据username获取User
	 */
	public User getUserByUsername(String username) throws Exception{
		return userDao.getUserByUsername(username);
	}
//	/**
//	 * 根据username获取password
//	 */
//	public String getPasswordByUsername(String username) throws Exception;
//	/**
//	 * 根据username获取state
//	 */
//	public int getStateByUsername(String username)throws Exception;
	
	/**
	 * 根据username更新User
	 */
	public boolean updateUserByUsername(String username, User user) throws Exception{
		return userDao.updateUserByUsername(username, user);
	}
	/**
	 * 根据username更新username
	 */
	public boolean updateUsernameByUsername(String username, String newUsername) throws Exception{
		return userDao.updateUsernameByUsername(username, newUsername);
	}
	/**
	 * 根据username更新password
	 */
	public boolean updatePasswordByUsername(String username, String password) throws Exception{
		return userDao.updatePasswordByUsername(username, password);
	}
	/**
	 * 根据username更新state
	 */
	public boolean updateStateByUsername(String username, int state) throws Exception{
		return userDao.updateStateByUsername(username, state);
	}
	
	/**
	 * 根据username删除User
	 */
	public boolean deleteUserByUsername(String username) throws Exception{
		return userDao.deleteUserByUsername(username);
	}
	
	/**
	 * 新增User信息
	 */
	public boolean addUser(User user) throws Exception{
		return userDao.addUser(user);
	}
}
