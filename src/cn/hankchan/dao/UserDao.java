/**
 * 
 */
package cn.hankchan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hankchan.po.User;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:06:50
 * 类说明:
 */
@Repository
public interface UserDao {
	
	/**
	 * 获取所有用户信息
	 */
	public List<User> getAllUsers() throws Exception;
	/**
	 * 根据Id获取用户名
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getUsernameById(int id) throws Exception;
	/**
	 * 获取用户状态为 1 的用户信息
	 */
	public List<User> getUserListOnLine() throws Exception;
	
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExistsId(int id) throws Exception;
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExists(String username) throws Exception;
	/**
	 * 根据username获取User
	 */
	public User getUserByUsername(String username) throws Exception;
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
	public boolean updateUserByUsername(String username, User user) throws Exception;
	/**
	 * 根据username更新username
	 */
	public boolean updateUsernameByUsername(String username, String newUsername) throws Exception;
	/**
	 * 根据username更新password
	 */
	public boolean updatePasswordByUsername(String username, String password) throws Exception;
	/**
	 * 根据username更新state
	 */
	public boolean updateStateByUsername(String username, int state) throws Exception;
	
	/**
	 * 根据username删除User
	 */
	public boolean deleteUserByUsername(String username) throws Exception;
	
	/**
	 * 新增User信息
	 */
	public boolean addUser(User user) throws Exception;
}
