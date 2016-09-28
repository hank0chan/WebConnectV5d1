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

import cn.hankchan.dao.PrivateChatDao;
import cn.hankchan.po.PrivateChat;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 8 May 201617:07:53
 * 类说明:
 */
@Repository("privateChatDao")
public class PrivateChatDaoImpl implements PrivateChatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取两个用户名的所有消息列表
	 * @param sender
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PrivateChat> getAllContentByUsernameOfBoth(String sender, String receiver) throws Exception {
		String sql = "SELECT * FROM privatechat WHERE (sender = ? AND receiver = ?) OR (receiver = ? AND sender = ?) ORDER BY id";
		List<PrivateChat> messageList = new ArrayList<>();
		RowMapper<PrivateChat> rowMapper = new BeanPropertyRowMapper<>(PrivateChat.class);
		messageList = jdbcTemplate.query(sql, rowMapper, sender, receiver, sender, receiver);
		return messageList;
	}

	/**
	 * 根据两个用户名新增私聊消息
	 * @param sender
	 * @param receiver
	 * @param content
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean addPrivateChatByUserOfBoth(String sender, String receiver, String content, String time) throws Exception {
		String sql = "INSERT INTO privatechat (sender, receiver, content, time) VALUES(?, ?, ?, ?)";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, sender, receiver, content, time);
		if(result == 1){
			flag = true;
		}
		return flag;
	}

}
