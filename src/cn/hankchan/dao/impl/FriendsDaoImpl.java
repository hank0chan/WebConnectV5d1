/**
 * 
 */
package cn.hankchan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.hankchan.dao.FriendsDao;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:09:18
 * 类说明:
 */
@Repository("friendsDao")
public class FriendsDaoImpl implements FriendsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据Id获取对话信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getContentById(int id) throws Exception {
		String sql = "SELECT content FROM friends WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
	
	@Override
	public int getFriendsIdByBoth(String usera, String userb) throws Exception {
		String sql = "SELECT id FROM friends WHERE (usera = ? AND userb = ?) OR (userb = ? AND usera = ?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, usera, userb, usera, userb);
	}
	@Override
	public boolean isExist(String usera, String userb) throws Exception {
		String sql = "SELECT COUNT(id) FROM friends WHERE (usera = ? AND userb = ?) OR (userb = ? AND usera = ?)";
		int count =  jdbcTemplate.queryForObject(sql, Integer.class, usera, userb, usera, userb);
		if(count == 1){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean addFriends(String usera, String userb) throws Exception {
		String sql = "INSERT INTO friends (usera, userb, isfriend) VALUES(?,?,?)";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, usera, userb, 1);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	/**
	 * 暂时不需要！！！
	 */
	@Override
	public boolean deleteFriends(String usera, String userb) throws Exception {
		System.out.println("dont do this!!!");
		return false;
	}
	@Override
	public int getIsFriendById(int id) throws Exception {
		String sql = "SELECT isfriend FROM friends WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}
	@Override
	public boolean updateIsFriendById(int id, int isfriend) throws Exception {
		String sql = "UPDATE friends SET isfriend = ? WHERE id = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, isfriend, id);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public List<String> getFriendsByUsername(String username) throws Exception {
		List<String> usernameList = new ArrayList<>();
		String sql = "SELECT usera FROM friends WHERE userb = ? AND isfriend = 1";
		usernameList = jdbcTemplate.queryForList(sql, String.class, username);
		List<String> usernameList2 = new ArrayList<>();
		String sql2 = "SELECT userb FROM friends WHERE usera = ? AND isfriend = 1";
		usernameList2 = jdbcTemplate.queryForList(sql2, String.class, username);
		for(int i = 0; i < usernameList2.size(); i++){
			String name = usernameList2.get(i);
			usernameList.add(name);
		}
		return usernameList;
	}

}
