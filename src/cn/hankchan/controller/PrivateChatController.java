/**
 * 
 */
package cn.hankchan.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.PrivateChat;
import cn.hankchan.po.User;
import cn.hankchan.service.PrivateChatService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 6 May 201614:55:43
 * 类说明: 私聊控制类
 * 用户实时私聊功能模块（用户私聊实时对话功能）
 */
@Controller
public class PrivateChatController {
	
	@Autowired
	private PrivateChatService privateChatService;
	
	//请求两个用户的数据
	/**
	 * 获取两个用户的聊天信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/privatemessages")
	public ModelAndView privateMessages(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("privatemessages");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user != null){
			String username = user.getUsername();
			String searchusername = (String) session.getAttribute("searchusername");
//			System.out.println(username + ";" + searchusername);
			//获取两个用户的所有聊天信息，放在request域中
	        List<PrivateChat> privateChatList = privateChatService.getAllContentByUsernameOfBoth(username, searchusername);
	        request.setAttribute("privateChatList", privateChatList);
//	        System.out.println(privateChatList);
		}
		
		return modelAndView;
	}
	/**
	 * 发送私聊消息
	 * @return
	 */
	@RequestMapping("/sendPrivate")
	public ModelAndView sendPrivate(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		/**
		 * 获取消息，存储到数据库中
		 */
		String content = request.getParameter("content");
		
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		String searchusername = (String) request.getSession().getAttribute("searchusername");
		if(content != null && content != ""){
			Date date = new Date();
			int years = date.getYear() + 1900;
			int month = date.getMonth() + 1;
			int day = date.getDate();
			int hours = date.getHours();
			int minutes = date.getMinutes();
			String time = years + "年" + month + "月"+ day + "日-" + hours + ":" + minutes;
			//将信息存到数据库
			boolean flag = privateChatService.addPrivateChatByUserOfBoth(username, searchusername, content, time);
			System.out.println(flag);
		}
		modelAndView.setViewName("privatechat");
		return modelAndView;
	}
	
	/**
	 * 私聊页面跳转控制类
	 * @param request
	 * @param response
	 * @param username
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/privateChat/{searchusername}")
	public ModelAndView privateChat(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("searchusername") String searchusername) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("privatechat");
		
			/********** 获取私聊的两个用户 ************/
			byte bb[];
	        bb = searchusername.getBytes("ISO-8859-1"); //以"ISO-8859-1"方式解析name字符串
	        System.out.println(searchusername);
	        /** 得到被选择的私聊好友的用户名 */
	        searchusername = new String(bb, "UTF-8"); //再用"utf-8"格式表示name
	        System.out.println("****" + searchusername);
	        HttpSession session = request.getSession();
	        //将私聊对象放在session中！！
			session.setAttribute("searchusername", searchusername);
		return modelAndView;
	}
	
	
}
