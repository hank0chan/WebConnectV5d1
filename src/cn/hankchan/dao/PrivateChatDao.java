/**
 * 
 */
package cn.hankchan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.hankchan.po.PrivateChat;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 8 May 201617:03:08
 * 类说明: 
 */
@Repository
public interface PrivateChatDao {
	
	
	/**
	 * 获取两个用户名的所有消息列表
	 * @param sender
	 * @param receiver
	 * @return
	 * @throws Exception
	 */
	public List<PrivateChat> getAllContentByUsernameOfBoth(String sender, String receiver) throws Exception;
	/**
	 * 根据两个用户名新增私聊消息
	 * @param sender
	 * @param receiver
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public boolean addPrivateChatByUserOfBoth(String sender, String receiver, String content, String time) throws Exception;
}
