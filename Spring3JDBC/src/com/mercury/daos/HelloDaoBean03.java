package com.mercury.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mercury.beans.User;

public class HelloDaoBean03 implements HelloDao {
	private NamedParameterJdbcTemplate template;
	
	public void setDataSource (DataSource dataSource){
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into Sample values(:Name,:Age)";
		Map <String ,Object> params = new HashMap<String,Object>();
		params.put("Name",user.getName());
		params.put("Age",user.getAge());
		template.update(sql, params);

	}

	@Override
	public List<User> query() {
		String sql = "select * from Sample where Name in(:names)";
		String[] names = {"Bob","David"};
		List<String> list = Arrays.asList(names);
		Map<String,List<String>> params = new HashMap<String,List<String>>();
		params.put("names", list);
		return template.query(sql,params,new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setName(rs.getString("Name"));
				user.setAge(rs.getInt("Age"));
				return user;
			}
		});
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		String sql = "delete Sample where Name= :name and Age = :age";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", user.getName());
		params.put("age",user.getAge());
		template.update(sql, params);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql = "update Sample set Age = :age where Name=:name";
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name",user.getName());
		params.put("age",user.getAge());
		template.update(sql,params);
	}

}
