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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.User;
import cn.hankchan.service.FriendsService;
import cn.hankchan.service.UserService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 29 Apr 201615:59:45
 * 类说明: 请求后台数据用于前端显示的处理控制类
 * 用户状态管理模块（在线用户，我的关注好友实时显示）
 */
@Controller
public class InfoController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendsService friendService;
	
	/**
	 * 显示我的好友
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/myfriends")
	public ModelAndView myfriends(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//获取用户名
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		List<String> friends = new ArrayList<>();
		List<User> onlineUsers = new ArrayList<>();
		//获取该用户所有的好友名的列表
		friends = friendService.getFriendsByUsername(username);
		
		//获取所有在线用户
		onlineUsers = userService.getUserListOnLine();
		
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("friends", friends);
		request.setAttribute("onlineUsers", onlineUsers);
		
		modelAndView.setViewName("myfriends");
		return modelAndView;
	}	
	
	/**
	 * 请求在线用户的信息 
	 * 由Ajax调用该请求，返回所有在线用户的信息
	 * @param request
	 * @param response
	 * @throws Exception
	 * 说明：在Ajax 轮询请求URL为"online"的时候，
	 * 在映射的控制器方法中调用Service服务获取数据库中所有状态为在线的用户信息
	 * 并且返回到List<User> 数据类型。在请求Ajax的页面就可以通过以下方法：
	 * $.get(url, function(datas){
	 *      document.getElementById("online2").innerHTML = datas + new Date();
	 *		document.wirte("<p>" + datas + "</p>");
	 * });
	 * 可以将online.jsp 中的得到的List<User>数据输出到id为online2的节点元素文本中。
	 * 
	 */
	@RequestMapping("/online")
	public List<User> showOnline(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		List<User> onlineUserList = new ArrayList<>();
		onlineUserList = userService.getUserListOnLine();
		
		//将得到的在线用户信息放在request域中
		request.setAttribute("onlineUserList", onlineUserList);
		return onlineUserList;
	}
}
