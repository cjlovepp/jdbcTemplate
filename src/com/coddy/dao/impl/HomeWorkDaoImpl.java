package com.coddy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.coddy.common.Page;
import com.coddy.common.PaginationHelper;
import com.coddy.dao.HomeWorkDao;
import com.coddy.entity.HomeWork;

public class HomeWorkDaoImpl implements HomeWorkDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;//通过注解方式将jdbcTemplate注入到HomeWorkDao

	@Override
	public List<Map<String, Object>> findALL() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM HOMEWORK";
        return jdbcTemplate.queryForList(sql);  
	}
	
	@Override
	public Page<HomeWork> getHomeWorks(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PaginationHelper<HomeWork> ph = new PaginationHelper<HomeWork>();
        return ph.fetchPage(
                jdbcTemplate,
                "SELECT count(*) FROM HOMEWORK WHERE base_user_id=?",
                "SELECT title FROM HOMEWORK WHERE base_user_id=?",
                new Object[]{"3"},//参数选项
                pageNo,
                pageSize,
                new ParameterizedRowMapper<HomeWork>() {
                    public HomeWork mapRow(ResultSet rs, int i) throws SQLException {
                        return new HomeWork(
//                            rs.getInt(1),
                            rs.getString(1)
                        );
                    }
                }
        );
	}

}
