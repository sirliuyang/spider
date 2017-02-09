package com.formula.spider.service.impl;

import java.sql.SQLException;

import com.formula.spider.dao.CommonDao;
import com.formula.spider.dao.SmzdmProductDao;
import com.formula.spider.service.DBService;

public class SmzdmDBService<T> implements DBService<T> {

	private CommonDao<T> dao = new SmzdmProductDao<T>();
	
	public SmzdmDBService(){
		
	}

	@Override
	public boolean create(T t) throws SQLException {
		return false;
	}

	@Override
	public boolean getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean change(T t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAll(String table) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
