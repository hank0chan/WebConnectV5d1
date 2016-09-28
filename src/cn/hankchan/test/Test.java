/**
 * 
 */
package cn.hankchan.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import cn.hankchan.controller.UserController;
import cn.hankchan.dao.MessageDao;
import cn.hankchan.dao.PrivateChatDao;
import cn.hankchan.dao.impl.FriendsDaoImpl;
import cn.hankchan.dao.impl.MessageDaoImpl;
import cn.hankchan.dao.UserDao;
import cn.hankchan.dao.impl.UserDaoImpl;
import cn.hankchan.po.Message;
import cn.hankchan.po.User;
import cn.hankchan.service.MessageService;
import cn.hankchan.service.UserService;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 2016年4月24日下午11:01:17
 * 类说明:
 */
public class Test {
	@Autowired
	private cn.hankchan.dao.impl.UserDaoImpl userDao;
	@Autowired
	private cn.hankchan.dao.impl.MessageDaoImpl messageDao;
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

	@org.junit.Test
	public void test2() throws Exception{
		PrivateChatDao privateChatDao = (PrivateChatDao) ctx.getBean("privateChatDao");
		boolean f = privateChatDao.addPrivateChatByUserOfBoth("aaa", "bbb", "测试消息", "20011111");
		System.out.println(f);
	}
	@org.junit.Test
	public void test() throws Exception{
		FriendsDaoImpl friendsDao = (FriendsDaoImpl) ctx.getBean("friendsDao");
		int result = friendsDao.getFriendsIdByBoth("黄志龙", "root");
		boolean result2 = friendsDao.isExist("root", "黄志龙");
		boolean result3 = friendsDao.addFriends("zhangting", "root");
		int result4= friendsDao.getIsFriendById(9);
		System.out.println(result4);
	}
	
	@org.junit.Test
	public void testConnect() throws SQLException{
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}
	
}
