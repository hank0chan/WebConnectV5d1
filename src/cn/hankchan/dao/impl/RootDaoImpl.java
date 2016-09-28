/**
 * 
 */
package cn.hankchan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.hankchan.dao.RootDao;
import cn.hankchan.po.Root;

/**
 * @author Hank_  Email:hankchans@163.com
 * @version 创建时间: 4 May 201616:12:54
 * 类说明:
 */
@Repository("rootDao")
public class RootDaoImpl implements RootDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean addRoot(Root root) throws Exception {
		String sql = "INSERT INTO root (username, password, level, tips) VALUES(?, ?, ?, ?)";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, root.getUsername(), root.getPassword(), root.getLevel(), root.getTips());
		if(result == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteRootByUsername(String username) throws Exception {
		String sql = "DELETE FROM root WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updatePasswordByUsername(String username, String password) throws Exception {
		String sql = "UPDATE root SET password = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, password, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateLevelByUsername(String username, String level) throws Exception {
		String sql = "UPDATE root SET level = ? WHERE username = ?";
		boolean flag = false;
		int result = jdbcTemplate.update(sql, level, username);
		if(result == 1){
			flag = true;
		}
		return flag;
	}

	@Override
	public Root getRootByUsername(String username) throws Exception {
		String sql = "SELECT * FROM root WHERE username = ?";
		RowMapper<Root> rowMapper = new BeanPropertyRowMapper<>(Root.class);
		Root root = jdbcTemplate.queryForObject(sql, rowMapper, username);
		return root;
	}

	@Override
	public List<Root> getRootList() throws Exception {
		List<Root> rootList = new ArrayList<>();
		String sql = "SELECT * FROM root";
		RowMapper<Root> rowMapper = new BeanPropertyRowMapper<>(Root.class);
		rootList = jdbcTemplate.query(sql, rowMapper);
		return rootList;
	}
}
