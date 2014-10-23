package com.coddy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkDao {
	
	public List<Map<String, Object>> findALL();
	
}
