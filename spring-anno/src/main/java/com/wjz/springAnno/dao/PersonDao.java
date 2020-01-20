package com.wjz.springAnno.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert() {
		String sql = "INSERT INTO MESSAGE (id, sender) VALUES (?, ?)";
		String sender = UUID.randomUUID().toString().substring(0, 5);
		Integer id = ((Double) (Math.random() * 100)).intValue() * -1;
		jdbcTemplate.update(sql, id, sender);
	}
}
