/**
 * 
 */
package cn.hankchan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hankchan.dao.FriendsDao;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:21:50
 * 类说明:
 */
@Service
public class FriendsService {

	@Autowired
	private FriendsDao friendsDao;
	
	/**
	 * 根据Id获取对话信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getContentById(int id) throws Exception{
		return friendsDao.getContentById(id);
	}
	
	/**获取两个好友关系对应的id
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public int getFriendsIdByBoth(String usera, String userb) throws Exception {
		return friendsDao.getFriendsIdByBoth(usera, userb);
	}
	/**
	 * 查询是否存在usera和userb对应的数据信息
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public boolean isExist(String usera, String userb) throws Exception {
		return friendsDao.isExist(usera, userb);
	}
	/**增加usera 和 userb 对应的好友关系数据
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public boolean addFriends(String usera, String userb) throws Exception {
		return friendsDao.addFriends(usera, userb);
	}
	//删除好友关系
	public boolean deleteFriends(String usera, String userb) throws Exception {
		return friendsDao.deleteFriends(usera, userb);
	}
	/**
	 * 根据Id查询两者是否为好友:1 为好友；0 非好友
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int getIsFriendById(int id) throws Exception {
		return friendsDao.getIsFriendById(id);
	}
	/**
	 * 根据Id更新usera 和userb 的好友关系状态 :1 为好友；0 非好友
	 * @param usera
	 * @param userb
	 * @param isfriend
	 * @return
	 * @throws Exception
	 */
	public boolean updateIsFriendById(int id, int isfriend) throws Exception {
		return friendsDao.updateIsFriendById(id, isfriend);
	}
	/**
	 * 根据username获取该用户所有的好友
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<String> getFriendsByUsername(String username) throws Exception {
		return friendsDao.getFriendsByUsername(username);
	}
}
