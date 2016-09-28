/**
 * 
 */
package cn.hankchan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hankchan.po.User;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 5 May 201610:08:41
 * 类说明:
 */
@Controller
public class AjaxTestController {
	

	
	@RequestMapping("testajax/hello.xml")
	public @ResponseBody User ajax(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
