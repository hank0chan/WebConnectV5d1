/**
 * 
 */
package cn.hankchan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.hankchan.po.Message;
import cn.hankchan.po.User;
import cn.hankchan.service.MessageService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:32:33
 * 类说明: 聊天信息操作模块控制类
 * 用户实时群聊功能模块（用户群聊实时对话功能），
 */
@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	/**
	 * 请求用户输入的信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/onlineMessage")
	public ModelAndView showMessage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<Message> messageList = new ArrayList<>();
		messageList = messageService.showMessages();
		request.setAttribute("messageList", messageList);
		modelAndView.setViewName("onlineMessage");
		return modelAndView;
	}
	
	/**用户发送消息控制响应方法
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/sendMessage")
	public ModelAndView sendMessage(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		//获取用户要发送的信息
//		String content = request.getParameter("content");
		String testcontent = request.getParameter("testcontent");
		//获取该用户信息
		User user = (User) request.getSession().getAttribute("user");
		String username = user.getUsername();
		
		//定义Message类
		Message message = new Message();
		message.setUsername(username);
//		message.setContent(content);
		message.setContent(testcontent);
		Date date = new Date();
		int years = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();
		int hours = date.getHours();
		int minutes = date.getMinutes();
		String time = years + "年" + month + "月"+ day + "日-" + hours + ":" + minutes;
		message.setTime(time);
		/** 判断是否为空消息 */
		if(testcontent != null){ 
			//将用户Message保存到数据库中
			messageService.addMessages(message);
		}			

		modelAndView.setViewName("success");
		return modelAndView;
	}
}
