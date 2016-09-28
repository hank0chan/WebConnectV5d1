/**
 * 
 */
package cn.hankchan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hankchan.po.Message;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:07:06
 * 类说明:
 */
@Repository
public interface MessageDao {
	
	/**
	 * 根据用户名删除消息
	 * @return
	 * @throws Exception
	 */
	public boolean deleteMessageByUsername(String username) throws Exception;
	/**
	 * 显示所有聊天信息
	 * @return
	 * @throws Exception
	 */
	public List<Message> showMessages() throws Exception;
	
	/**
	 * 添加新的聊天信息 
	 * @throws Exception
	 */
	public boolean addMessages(Message message) throws Exception;
	/**
	 * 根据发送者username获取其发送的所有信息
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<Message> getMessagesByUsername(String username) throws Exception;
	/**
	 * 根据用户名获取发送给该用户的所有信息
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<Message> getMessagesByReceiver(String receiver) throws Exception;
	/**
	 * 根据发送者和接收者的用户名匹配两个用户间互相发送的信息
	 * @param username
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<Message> showMessagesByUsernameAndReceiver(String username, String receiver) throws Exception;
}
