/**
 * 
 */
package cn.hankchan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:08:16
 * 类说明:
 * 添加好友时，首先查询是否存在这两者的对应关系数据isExist()
 * 如果没有，说明不是好友；在friends表中新增这两个用户的对应关系信息，同时将 isfriend 字段置为 1 。addFriends()
 * 如果有，则直接将字段 isfriend 置为 1 。
 * 删除好友时因为是好友了，所以直接将 isfriend 字段置为 0 。updateIsFriendById()
 * 根据两个用户名查找对应的 id，getFriendsIdByBoth(); 然后可以根据 id 获取 friends表中的 isfriend 值确认两者是否为好友。getIsFriendById()
 */
@Repository
public interface FriendsDao {

	/**
	 * 根据Id获取对话信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String getContentById(int id) throws Exception;
	
	/**获取两个好友关系对应的id
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public int getFriendsIdByBoth(String usera, String userb) throws Exception;
	/**
	 * 查询是否存在usera和userb对应的数据信息
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public boolean isExist(String usera, String userb) throws Exception;
	/**增加usera 和 userb 对应的好友关系数据
	 * @param usera
	 * @param userb
	 * @return
	 * @throws Exception
	 */
	public boolean addFriends(String usera, String userb) throws Exception;
	//删除好友关系
	public boolean deleteFriends(String usera, String userb) throws Exception;
	/**
	 * 根据Id查询两者是否为好友:1 为好友；0 非好友
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int getIsFriendById(int id) throws Exception;
	/**
	 * 根据Id更新usera 和userb 的好友关系状态 :1 为好友；0 非好友
	 * @param usera
	 * @param userb
	 * @param isfriend
	 * @return
	 * @throws Exception
	 */
	public boolean updateIsFriendById(int id, int isfriend) throws Exception;
	/**
	 * 根据username获取该用户所有的好友
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<String> getFriendsByUsername(String username) throws Exception;
}
