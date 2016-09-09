package com.formular.spider.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PsqlConnection implements DBConnection{

	private static String host = "localhost";
	private static String user = "leon";
	private static String password = "123456";
	private static int port = 5432;
	private static String database = "smzdm";

	public static Connection connection = null;

	static {
		if (connection == null)
			try {
				connection = buildConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public Connection getConnnection(){
		return connection;
	}

	private static String getUrlFormat() {
		return "jdbc:postgresql://%s:%d/%s";
	}

	private static String buildUrlString() {
		return String.format(getUrlFormat(), host, port, database);
	}

	private static Connection buildConnection() throws SQLException {
		return DriverManager.getConnection(buildUrlString(), user, password);
	}
}
