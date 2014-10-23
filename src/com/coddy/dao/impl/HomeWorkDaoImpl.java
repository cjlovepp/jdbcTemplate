package com.coddy.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.coddy.dao.HomeWorkDao;

public class HomeWorkDaoImpl implements HomeWorkDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;//通过注解方式将jdbcTemplate注入到HomeWorkDao

	@Override
	public List<Map<String, Object>> findALL() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM HOMEWORK";
        return jdbcTemplate.queryForList(sql);  
	}

}
