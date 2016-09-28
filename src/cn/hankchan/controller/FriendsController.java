/**
 * 
 */
package cn.hankchan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.User;
import cn.hankchan.service.FriendsService;
import cn.hankchan.service.UserService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:32:14
 * 类说明: 好友关系模块控制类
 * 好友关系管理模块（搜索用户信息，取消、添加关注管理）
 */
@Controller
public class FriendsController {
	
	public static final int FRIEND_RELATIONSHIP = 1;
	public static final int NOTFRIEND_RELATIONSHIP = 0;
	@Autowired
	private FriendsService friendService;
	@Autowired
	private UserService userService;
	
	/**
	 * 添加好友功能
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addFriend/{id}")
	public ModelAndView addFriend(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("myfriends");
		//根据用户id获取用户名
		String searchusername = userService.getUsernameById(id); //被搜索添加者
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername(); //登陆者
		/** 获取两个人的id并且在建立好友关系时设置为friends表中的useraId和userbId */
//		int userBId = userService.getUserByUsername(searchusername).getId(); //被搜索者id
//		int userAId = user.getId(); //登录者id
		/* *************************************************** */
		/** 显然，能够操作添加好友说明两者不是好友关系 */
		//1. 首先查询是否在friends表中存在两者的对应数据信息
		boolean flag = friendService.isExist(username, searchusername);
		if(flag){ 
			//如果存在，直接将isfriend字段置为 1 
			int friendsId = friendService.getFriendsIdByBoth(username, searchusername);
			friendService.updateIsFriendById(friendsId, FRIEND_RELATIONSHIP);
		}else {
			//不存在两者对应信息，则新增好友信息
			friendService.addFriends(username, searchusername);
		}
		//返回到myfriends页面
		List<String> friends = new ArrayList<>();
		List<User> onlineUsers = new ArrayList<>();
		//获取该用户所有的好友名的列表
		friends = friendService.getFriendsByUsername(username);
		//获取所有在线用户
		onlineUsers = userService.getUserListOnLine();
		
		request.setAttribute("friends", friends);
		request.setAttribute("onlineUsers", onlineUsers);	
		return modelAndView;
	}
	
	/**
	 * 搜索到好友后的删除请求
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteFriend/{id}")
	public ModelAndView deleteFriend(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("myfriends");
		//根据用户id获取用户名
		String searchusername = userService.getUsernameById(id);
		//根据两个用户名更新对应的friends表的isfriend字段
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		
		//查询两个用户的friends表id
		int friendsId = friendService.getFriendsIdByBoth(username, searchusername);
		//根据id改变该数据的好友关系字段
		friendService.updateIsFriendById(friendsId, NOTFRIEND_RELATIONSHIP);
		
		//返回到myfriends页面
		List<String> friends = new ArrayList<>();
		List<User> onlineUsers = new ArrayList<>();
		//获取该用户所有的好友名的列表
		friends = friendService.getFriendsByUsername(username);
		
		//获取所有在线用户
		onlineUsers = userService.getUserListOnLine();
		
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("friends", friends);
		request.setAttribute("onlineUsers", onlineUsers);
		return modelAndView;
	}
	
	/**
	 * 搜索好友功能(同时包括添加为好友功能)
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchUser")
	public ModelAndView searchUser(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("searchuser");
		User user = (User) request.getSession().getAttribute("user");
		
		String username = user.getUsername(); //登陆用户名
		String searchname = request.getParameter("searchname"); //查询对象的用户名

		//定义一个变量用于前端判断是否为好友
		int relationshipId = 2;
		/**
		 * 查询是否为好友
		 */
		boolean flag = friendService.isExist(username, searchname); //是否存在对应数据
		if(flag){ //存在对应关系数据
			int id = friendService.getFriendsIdByBoth(username, searchname);//获取两者对应关系数据的Id
			int isfriend = friendService.getIsFriendById(id);
			if(isfriend == FRIEND_RELATIONSHIP){ //是好友关系了
				//如果是好友则显示删除好友按钮
				relationshipId = 1;
			}else { //不是好友关系
				//如果不是好友则显示添加好友按钮
				relationshipId = 0;
			}
		}else { //不存在对应关系，说明不是好友
			//如果不是好友则显示添加好友按钮
			relationshipId = 0;
		}
	
		User personalInfo = null;
		//查询是否存在该用户，存在则获取对象信息
		if(userService.isExists(searchname)){
			personalInfo = userService.getUserByUsername(searchname); //获取查询对象信息并且放入request域中
			request.setAttribute("personalInfo", personalInfo);
		} else {
			request.setAttribute("messages", "很抱歉，查询不到该用户！");
			relationshipId = 2;
		}
		
		request.setAttribute("relationshipId", relationshipId);
		return modelAndView;
	}
	

	
}
