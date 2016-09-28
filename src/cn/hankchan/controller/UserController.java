/**
 * 
 */
package cn.hankchan.controller;

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
 * @version 创建时间: 4 May 201616:31:32
 * 类说明: 用户个人信息管理模块控制类
 * 用户信息管理模块（用户个人信息查看修改）
 */
@Controller
public class UserController {

	public static final int ONLINE_STATE = 1;
	public static final int OFFLINE_STATE = 0;
	
	public static final int FRIEND_RELATIONSHIP = 1;
	public static final int NOTFRIEND_RELATIONSHIP = 0;

	@Autowired
	private UserService userService;
	@Autowired
	private FriendsService friendService;
	/**
	 * 点击myfriends页面中的在线用户名 请求获取其个人资料控制类
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publicpersonalInfo/{id}")
	public ModelAndView personalInfoByUsername(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable("id") int id) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		//获取用户名
		User userinfo = new User(); //新建用户信息存放的类
		//根据Id获取用户名
		String searchname = userService.getUsernameById(id);
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		
		//定义一个变量用于前端判断是否为好友
		int relationshipId = 2;
		/**
		 * 查询是否为好友
		 */
		boolean flag = friendService.isExist(username, searchname); //是否存在对应数据
		if(flag){ //存在对应关系数据
			int id2 = friendService.getFriendsIdByBoth(username, searchname);//获取两者对应关系数据的Id
			int isfriend = friendService.getIsFriendById(id2);
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
		
		userinfo =userService.getUserByUsername(searchname); //获取用户信息 
		
		request.setAttribute("relationshipId", relationshipId);
		request.setAttribute("personalInfo", userinfo);
		modelAndView.setViewName("publicpersonalInfo");
		return modelAndView;
	}
	
	/**
	 * 显示用户 个人资料 请求响应
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/personalInfo")
	public ModelAndView showUserInfo(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user = (User) request.getSession().getAttribute("user"); //测试可以获取到
		String username = user.getUsername(); //获取用户名
		
		User userinfo = new User(); //新建用户信息存放的类
		
		userinfo =userService.getUserByUsername(username); //获取用户信息 
		request.setAttribute("personalInfo", userinfo);
		modelAndView.setViewName("personalInfo");
		return modelAndView;
	}
	
	/**
	 * 修改信息请求跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeInfo")
	public ModelAndView changeInfo(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
	
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("changeInfo");
		return modelAndView;
	}
	/**
	 * 修改个人信息成功
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeInfoSuccess")
	public ModelAndView changeInfoSuccess(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
	
		ModelAndView modelAndView = new ModelAndView();
		//获取请求修改参数
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String college = request.getParameter("college");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String weixin = request.getParameter("weixin");
		String qq = request.getParameter("qq");
		int db_age = Integer.parseInt(age);
		int db_gender = Integer.parseInt(gender);

		user.setAge(db_age);
		user.setCollege(college);
		user.setTel(tel);
		user.setEmail(email);
		user.setWeixin(weixin);
		user.setQq(qq);
		user.setGender(db_gender);

		//更新到数据库
		userService.updateUserByUsername(username, user);
		//提示更新成功
		
		//重新将数据输出到目标页面
		User userinfo = new User(); //新建用户信息存放的类
		userinfo = userService.getUserByUsername(username);
		request.setAttribute("personalInfo", userinfo);
		modelAndView.setViewName("personalInfo");
		return modelAndView;
	}

}
