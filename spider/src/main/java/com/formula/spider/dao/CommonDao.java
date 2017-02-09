package com.formula.spider.dao;

import java.sql.SQLException;

public interface CommonDao<T> {
	boolean insert(T t) throws SQLException;
	boolean select(int id) throws SQLException;
	boolean selectAll(String table) throws SQLException;
	boolean update(T t) throws SQLException;
	boolean delete(T t) throws SQLException;
}
