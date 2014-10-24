package com.coddy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coddy.common.Page;
import com.coddy.entity.HomeWork;

@Repository
public interface HomeWorkDao {
	
	public List<Map<String, Object>> findALL();
	
	//∑÷“≥≤È—Ø
	public Page<HomeWork> getHomeWorks(final int pageNo, final int pageSize);
	
}
