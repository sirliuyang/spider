package com.formular.spider.service;

import java.sql.SQLException;

public interface DBService<T> {
	boolean create(T t) throws SQLException;
	boolean getById(int i) throws SQLException;
	boolean getAll(String table) throws SQLException;
	boolean change(T t) throws SQLException;
	boolean remove(T t) throws SQLException;
}
