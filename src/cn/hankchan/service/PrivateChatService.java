/**
 * 
 */
package cn.hankchan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hankchan.dao.PrivateChatDao;
import cn.hankchan.po.PrivateChat;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 8 May 201617:20:47
 * 类说明:
 */
@Service
public class PrivateChatService {

	@Autowired
	private PrivateChatDao privateChatDao;
	
	/**
	 * 获取两个用户名的所有消息列表
	 * @param sender
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<PrivateChat> getAllContentByUsernameOfBoth(String sender, String receiver) throws Exception{
		return privateChatDao.getAllContentByUsernameOfBoth(sender, receiver);
	}
	/**
	 * 根据两个用户名新增私聊消息
	 * @param sender
	 * @param receiver
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public boolean addPrivateChatByUserOfBoth(String sender, String receiver, String content, String time) throws Exception{
		return privateChatDao.addPrivateChatByUserOfBoth(sender, receiver, content, time);
	}
}
