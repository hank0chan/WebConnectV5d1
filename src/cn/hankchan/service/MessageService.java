/**
 * 
 */
package cn.hankchan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hankchan.dao.MessageDao;
import cn.hankchan.po.Message;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:21:33
 * 类说明:
 */
@Service
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	
	/**
	 * 根据用户名删除消息
	 * @return
	 * @throws Exception
	 */
	public boolean deleteMessageByUsername(String username) throws Exception{
		return messageDao.deleteMessageByUsername(username);
	}
	/**
	 * 显示所有聊天信息
	 * @return
	 * @throws Exception
	 */
	public List<Message> showMessages() throws Exception {
		return messageDao.showMessages();
	}
	
	/**
	 * 添加新的聊天信息 
	 * @throws Exception
	 */
	public boolean addMessages(Message message) throws Exception {
		return messageDao.addMessages(message);
	}
	/**
	 * 根据发送者username获取其发送的所有信息
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<Message> getMessagesByUsername(String username) 
			throws Exception {
		
		return messageDao.getMessagesByUsername(username);
	}
	/**
	 * 根据用户名获取发送给该用户的所有信息
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<Message> getMessagesByReceiver(String receiver) 
			throws Exception {
		
		return messageDao.getMessagesByReceiver(receiver);
	}
	/**
	 * 根据发送者和接收者的用户名匹配两个用户间互相发送的信息
	 * @param username
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<Message> showMessagesByUsernameAndReceiver(String username, String receiver) 
			throws Exception {
		
		return messageDao.showMessagesByUsernameAndReceiver(username, receiver);
	}
}
