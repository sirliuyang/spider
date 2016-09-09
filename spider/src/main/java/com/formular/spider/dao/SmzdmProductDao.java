package com.formular.spider.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.formular.spider.constraints.SmzdmSql;
import com.formular.spider.util.DBConnection;
import com.formular.spider.util.PsqlConnection;

public class SmzdmProductDao<T> extends SmzdmSql implements CommonDao<T> {

	private DBConnection dbconn;

	public SmzdmProductDao() {
		this.dbconn = new PsqlConnection();
	}

	@Override
	public boolean insert(T t) throws SQLException {
		Connection conn = dbconn.getConnnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT_PRODUCT);
		return false;
	}

	@Override
	public boolean select(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectAll(String table) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
