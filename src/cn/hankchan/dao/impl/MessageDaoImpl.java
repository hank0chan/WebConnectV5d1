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

import cn.hankchan.dao.MessageDao;
import cn.hankchan.po.Message;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:08:57
 * 类说明:
 */
@Repository("messageDao")
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public boolean deleteMessageByUsername(String username) throws Exception{
		String sql = "DELETE FROM message WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}
	@Override
	public List<Message> showMessages() throws Exception {
		List<Message> messageList = new ArrayList<>();
		String sql = "SELECT * FROM message ORDER BY id ASC";
		RowMapper<Message> rowMapper = new BeanPropertyRowMapper<>(Message.class);
		messageList = jdbcTemplate.query(sql, rowMapper);
		return messageList;
	}
	
	@Override
	public boolean addMessages(Message message) throws Exception {
		String sql = "INSERT INTO message (username, content, time, receiver) VALUES(?, ?, ?, ?)";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, message.getUsername(), message.getContent(), message.getTime(), message.getReceiver());
		if(result == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Message> getMessagesByUsername(String username) throws Exception {
		List<Message> messageList = new ArrayList<>();
		String sql = "SELECT * FROM message WHERE username = ? ORDER BY id ASC";
		RowMapper<Message> rowMapper = new BeanPropertyRowMapper<>(Message.class);
		messageList = jdbcTemplate.query(sql, rowMapper, username);
		return messageList;
	}

	@Override
	public List<Message> getMessagesByReceiver(String receiver) throws Exception {
		List<Message> messageList = new ArrayList<>();
		String sql = "SELECT * FROM message WHERE receiver = ? ORDER BY id ASC";
		RowMapper<Message> rowMapper = new BeanPropertyRowMapper<>(Message.class);
		messageList = jdbcTemplate.query(sql, rowMapper, receiver);
		return messageList;
	}

	@Override
	public List<Message> showMessagesByUsernameAndReceiver(String username, String receiver) throws Exception {
		List<Message> messageList = new ArrayList<>();
		String sql = "SELECT * FROM message WHERE username = ? AND receiver = ? ORDER BY id ASC";
		RowMapper<Message> rowMapper = new BeanPropertyRowMapper<>(Message.class);
		messageList = jdbcTemplate.query(sql, rowMapper, username, receiver);
		return messageList;
	}

}
