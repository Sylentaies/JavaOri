package com.mercury.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mercury.beans.User;
import com.mercury.util.JdbcUtil;

public class HelloDao {
	private Connection conn;
	
	public void connect() throws SQLException {
		conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
	}
	
	public void disconnect() throws SQLException {
		if (conn!=null) {
			conn.close();
			conn = null;
		}
	}
	
	public void save(User user) {
		String sql = "insert into Sample values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getNames() {
		List<String> list = new ArrayList<String>();
		String sql = "select name from Sample";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("name"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
