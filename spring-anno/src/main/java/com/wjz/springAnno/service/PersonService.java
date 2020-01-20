package com.wjz.springAnno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wjz.springAnno.dao.PersonDao;

@Service
public class PersonService {

	@Autowired
	private PersonDao dao;
	
	@Transactional
	public void insert() {
		dao.insert();
		System.out.println("insert");
	}
	
	@Transactional
	public void update() {
		
	}
}
