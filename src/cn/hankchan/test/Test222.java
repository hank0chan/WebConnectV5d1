/**
 * 
 */
package cn.hankchan.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 20 May 2016-20:39:14
 * 类说明:
 */
public class Test222 {

	@Test
	public void test2() throws SQLException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}
