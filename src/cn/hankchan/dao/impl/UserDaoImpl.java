/**
 * 
 */
package cn.hankchan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.hankchan.dao.UserDao;
import cn.hankchan.po.User;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:08:35
 * 类说明:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> getAllUsers() throws Exception{
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM user";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		userList = jdbcTemplate.query(sql, rowMapper);
		return userList;
	}
	
	/**
	 * 根据Id获取用户名
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getUsernameById(int id) throws Exception {
		String sql = "SELECT username FROM user WHERE id = ?";
		String result = jdbcTemplate.queryForObject(sql, String.class, id);
		return result;
	}
	/**
	 * 获取用户状态为在线的用户信息
	 */
	public List<User> getUserListOnLine() throws Exception {
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM user WHERE state = 1";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		userList = jdbcTemplate.query(sql, rowMapper);
		return userList;
	}
	
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExistsId(int id) throws Exception{
		String sql = "SELECT COUNT(id) FROM user WHERE id = ?";
		int count =  jdbcTemplate.queryForObject(sql, Integer.class, id);
		if(count == 1){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据username查询是否存在该用户
	 */
	public boolean isExists(String username){
		String sql = "SELECT COUNT(username) FROM user WHERE username = ?";
		int count =  jdbcTemplate.queryForObject(sql, Integer.class, username);
		if(count == 1){
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据username获取User
	 */
	public User getUserByUsername(String username){
		String sql = "SELECT * FROM user WHERE username = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, username);
		return user;
	}
//	/**
//	 * 根据username获取password
//	 */
//	public String getPasswordByUsername(String username){
//		String sql = "SELECT password FROM user WHERE username = ?";
//		return jdbcTemplate.queryForObject(sql, String.class, username);
//	}
//	/**
//	 * 根据username获取state
//	 */
//	public int getStateByUsername(String username){
//		String sql = "SELECT state FROM user WHERE username = ?";
//		return jdbcTemplate.queryForObject(sql, Integer.class, username);
//	}
	@Override
	public boolean updateUserByUsername(String username, User user) throws Exception {
		String sql = "UPDATE user SET username = ?, password = ?, state = ?, "
				+ "speak = ?, nickname = ?, gender = ?, age = ?, college = ?, "
				+ "tel = ?, email = ?, weixin = ?, qq = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), 
				user.getState(), user.getSpeak(), user.getNickname(), user.getGender(), 
				user.getAge(), user.getCollege(), user.getTel(), user.getEmail(), 
				user.getWeixin(), user.getQq(), username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean updateUsernameByUsername(String username, String newUsername) throws Exception {
		String sql = "UPDATE user SET username = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, newUsername, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean updatePasswordByUsername(String username, String password) throws Exception {
		String sql = "UPDATE user SET password = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, password, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean updateStateByUsername(String username, int state) throws Exception {
		String sql = "UPDATE user SET state = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, state, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean deleteUserByUsername(String username) throws Exception {
		String sql = "DELETE FROM user WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public boolean addUser(User user) throws Exception {
		String sql = "INSERT INTO user (username, password, state, "
				+ "speak, nickname, gender, age, college, tel, "
				+ "email, weixin, qq) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, user.getUsername(), 
				user.getPassword(), user.getState(),user.getSpeak(), 
				user.getNickname(), user.getGender(), user.getAge(), 
				user.getCollege(), user.getTel(), user.getEmail(), 
				user.getWeixin(), user.getQq());
		if(result == 1){
			flag = true;
		}
		return flag;
	}
}
