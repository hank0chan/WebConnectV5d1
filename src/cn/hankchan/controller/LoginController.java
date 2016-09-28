/**
 * 
 */
package cn.hankchan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.User;
import cn.hankchan.po.UserForm;
import cn.hankchan.service.UserService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:30:16
 * 类说明: 登陆注册模块控制类
 * 登陆注册功能模块（用户安全登录，注册新用户，用户密码修改）
 */
@Controller
public class LoginController {

	public static final int ONLINE_STATE = 1;
	public static final int OFFLINE_STATE = 0;
	
	@Autowired
	private UserService userService;
	
	//请求修改密码跳转页面
	/**
	 * 用户请求修改密码跳转页面
	 * @return
	 */
	@RequestMapping("/changePSW")
	public ModelAndView toChangePSW(){
		ModelAndView modelAndView = new ModelAndView("changepassword");
		return modelAndView;
	}
	
	//用户请求修改密码
	/**
	 * 用户请求修改密码响应方法
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changePassword")
	public ModelAndView changePassword(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		//获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String newPassword2 = request.getParameter("newPassword2");
		/********** 判断该用户是否存在 ***********/
		if(userService.isExists(username)){ 
			/*********** 存在该用户 ***************/
			//获取数据库中的该用户信息
			User user = userService.getUserByUsername(username);
			//比对请求参数密码
			if(password.equals(user.getPassword())){ //密码校验成功
				//判断两次输入新密码是否一致
				if(!newPassword.equals(newPassword2)){
					request.setAttribute("messages", "新密码输入不一致！请重新修改！");
					modelAndView.setViewName("changepassword");
				}else{ 
					/*********** 密码正确，并且两次新密码输入一致，更新该用户的密码及登陆状态 *****************/
					//更新登陆状态
					userService.updateStateByUsername(username, OFFLINE_STATE);
					//更新用户密码
					userService.updatePasswordByUsername(username, newPassword);
					request.setAttribute("repeatMessages", "您的密码修改成功！");
					modelAndView.setViewName("index");
				}
			}else{ //密码校验失败
				request.setAttribute("messages", "您输入的登录密码有误！");
				modelAndView.setViewName("changepassword");
			}
		}else{ //该用户尚未注册
			request.setAttribute("changePasswordFailedMessages", "该用户名不存在！欢迎使用注册！");
			modelAndView.setViewName("changepassword");
		}		
		return modelAndView;
	}
	
	/**
	 * 请求回到主界面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/backToSuccess")
	public ModelAndView backToSuccess() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return modelAndView;
	}
	/**
	 * 请求到登陆页面
	 * @return
	 */
	@RequestMapping("/backToIndex")
	public ModelAndView backToIndex() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	/**
	 * 用户申请注册跳转页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adduser");
		return modelAndView;		
	}
	
	/**
	 * 用户请求注册提交表单响应方法
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addUserForm")
	public ModelAndView addUserForm(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		String username = request.getParameter("username");
		/*********** 判断该用户名是否已经存在 ******************/
		if(userService.isExists(username)){ //该用户已经存在
			request.setAttribute("messages", "对不起，该用户名已存在！");
			modelAndView.setViewName("adduser");
		}else { 
			/************** 该用户名可以注册 ************************/
			
			//判断注册新用户的两次密码是否一致
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			
			if(password.equals(password2)){ 
				/******************** 密码信息一致，准许注册 **************************/
				//将用户信息放在User类中
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setState(OFFLINE_STATE);
				//更新数据库信息完成注册
				userService.addUser(user);
				
				request.setAttribute("addUserMessages", "恭喜您，注册成功！");
				modelAndView.setViewName("index");
			}else{
				//设置密码信息失败，注册失败
				request.setAttribute("messages", "该用户名可用，但您设置的密码输入不一致，请重新输入信息！");
				modelAndView.setViewName("adduser");
			}
		}
		return modelAndView;
	}
	
	/**
	 * 用户正常退出登录的响应方法
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/outLogin")
	public ModelAndView outLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = request.getSession();
		//可以从session中获取当前登陆用户的信息
		User user = (User) session.getAttribute("user"); 
		if(user != null){
			//退出登录时，注销session
			session.invalidate();
			//将数据库中用户状态信息设置为 0 。
			userService.updateStateByUsername(user.getUsername(), OFFLINE_STATE);
		}
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	/**
	 * 用户请求登陆控制方法
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		UserForm userForm = new UserForm();
		//获取登陆页面的请求参数,放到请求表单类UserForm中
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userForm.setUsername(username);
		userForm.setPassword(password);
		
		/************************* 判断是否为已注册用户 ********************************/
		//判断是否存在该用户
		boolean flag = userService.isExists(username);
		if(flag){ //若存在该用户，验证登陆密码
			User user = new User();
			String dbPassword = userService.getUserByUsername(username).getPassword(); //获取到用户密码
			if(dbPassword.equals(password)){  /***********若登陆密码正确******************************/
				
				/****************************** 已登陆成功！！ **************************************/
				//修改用户状态为登陆成功，调用Service方法将用户信息中的 state 设置为在线状态，即  1 。
				userService.updateStateByUsername(username, ONLINE_STATE);
				
				//该用户的信息
				user = userService.getUserByUsername(username);  //获取该登陆用户的信息
				
				/******************************* 登陆成功后绑定Session **************************************/
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				//将用户信息同时放在request域中是否有必要？小弟愚钝。。暂时留着。。。。。。。。。。
				request.setAttribute("user", user);
				request.setAttribute("messages", "登陆成功！");
				modelAndView.setViewName("success"); 
				
			}else{ /************************** 若密码输入错误 *********************************************/
				
				request.setAttribute("userForm", userForm);
				request.setAttribute("messages", "密码不正确！");
				modelAndView.setViewName("index");
			}
			
		}else{ /********************** 用户不存在，提示注册 **************************/
			
			request.setAttribute("userForm", userForm);
			request.setAttribute("messages", "对不起，您尚未注册！");
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
}
