package cn.hankchan.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.Root;
import cn.hankchan.po.User;
import cn.hankchan.service.MessageService;
import cn.hankchan.service.RootService;
import cn.hankchan.service.UserService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:31:53
 * 类说明: 管理员操作模块控制类
 * 管理员后台管理模块（删除违规用户群聊消息，注销违规用户账号）
 */
@Controller
public class RootController {

	@Autowired
	private RootService rootService;
	@Autowired
	private UserService userService;
	@Autowired
	private MessageService messageService;
	
	/**
	 * 进入root管理页面前先加载所有用户的信息
	 * 并且放在模型对象中。。。
	 * 由 ModelAttribute 注解的方法会在每一个Mapping方法被调用前调用，并且返回数据模型
	 * @return
	 */
	@ModelAttribute
	public List<User> getUserList(HttpServletRequest request, 
			HttpServletResponse response, Model model) throws Exception{
		/** 判断是否为用户在登陆后进行的调用Controller */
		Root root = (Root) request.getSession().getAttribute("root");
		if(root != null){ //不为空说明是登陆后的Root操作
			String rootname = root.getUsername();
			request.setAttribute("rootname", rootname);
		}else{
			//用户在请求登陆前的调用，不作操作！
		}
		//将所有用户信息输出到管理员页面列表
		List<User> userlist = userService.getAllUsers();
		request.setAttribute("userlist", userlist);
		return userlist;
	}
	
	/**
	 * 注销用户账号
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancelUser/{id}")
	public ModelAndView cancelUser(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable int id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("cancelUser:" + id);
		
		//查询是否存在该id,存在该用户Id才后面继续
		boolean isExistsId = userService.isExistsId(id);
		if(isExistsId){
			/**根据用户Id删除该用户的信息*/
			String username = userService.getUsernameById(id);
			//根据用户名删除消息
			messageService.deleteMessageByUsername(username);
			//根据用户名删除用户
			userService.deleteUserByUsername(username);
		}else {
			
		}
		modelAndView.setViewName("rootsuccess");
		return modelAndView;
	}
	
	/**
	 * 清空用户的所有聊天信息
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancelMessage/{id}")
	public ModelAndView cancelMessage(HttpServletRequest request, 
			HttpServletResponse response, @PathVariable int id) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("cancelMessage:" + id);
		//根据id获取用户名
		String username = userService.getUsernameById(id);
		//根据用户名删除消息
		messageService.deleteMessageByUsername(username);
		modelAndView.setViewName("rootsuccess");
		return modelAndView;
	}
	
	/**
	 * 管理员退出登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rootlogout")
	public ModelAndView rootLogout(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		//注销用户的session
		HttpSession session = request.getSession();
		session.invalidate();

		modelAndView.setViewName("index");
		return modelAndView;
	}
	/**
	 * 管理员请求验证登陆ROOT
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rootlogin")
	public ModelAndView rootLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		//获取请求参数
		String rootname = request.getParameter("rootname");
		String password = request.getParameter("password");
		//校验请求参数
		Root root = rootService.getRootByUsername(rootname);
		if(root != null){ //存在该用户
			if(password.equals(root.getPassword())){ //校验通过
				
				HttpSession session = request.getSession();
				session.setAttribute("root", root);
				
				//将所有用户信息输出到管理员页面列表
				/*
				List<User> userlist = userService.getAllUsers();
				request.setAttribute("userlist", userlist);
				*/
				request.setAttribute("rootname", rootname);
				modelAndView.setViewName("rootsuccess");
			}else { //校验失败
				request.setAttribute("messages", "对不起，用户名或密码错误！");
				modelAndView.setViewName("rootlogin");
			}
		}else{
			request.setAttribute("messages", "对不起，用户名或密码错误！");
			modelAndView.setViewName("rootlogin");
		}
		
		return modelAndView;
	}
	
	/**
	 * 请求到管理员登录界面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rootIndex")
	public ModelAndView rootIndex(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("rootlogin");
		return modelAndView;
	}
}
