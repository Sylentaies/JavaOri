package com.mercury.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {

	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@Shi-U430:1521:XE";
	private static final String USERNAME="javauser";
	private static final String PASSWORD = "asdf" ;
	
	public static Connection getConnection(){
		Connection conn = null;
	
		try{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			}catch (Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
