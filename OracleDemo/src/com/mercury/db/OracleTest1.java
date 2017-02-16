package com.mercury.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mercury.util.JdbcUtil;

public class OracleTest1 {
	public static void main(String[] args){
		try{
			Connection conn = JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into sample values('Mary',50)";
			Statement st = conn.createStatement();
			st.execute(sql);
			sql = "selectt * from sample";
			ResultSet rs = st.executeQuery(sql);
			conn.commit();
			while (rs.next()){
				System.out.println(rs.getString("name")+"\t"+rs.getInt("age"));
			}
			rs.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
