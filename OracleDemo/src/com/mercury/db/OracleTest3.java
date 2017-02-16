package com.mercury.db;
import java.sql.*;

import oracle.jdbc.OracleTypes;

import com.mercury.util.JdbcUtil;
public class OracleTest3 {
	public static void main(String[] args) {
		try{
			Connection conn = JdbcUtil.getConnection();
			String sp = "{? = call saveUser(?,?)}";
			CallableStatement cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, "Steven");
			cs.setInt(3, 58);
			cs.execute();
			System.out.println("Returned value: "+ cs.getInt(1));
			sp = "{? = call queryUser()}";
			cs = conn.prepareCall(sp);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while (rs.next()){
				System.out.println(rs.getString("name")+"\t"+rs.getInt("age"));
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
