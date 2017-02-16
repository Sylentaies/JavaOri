package com.mercury.daos;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mercury.beans.User;

public class HelloDaoBean02 implements HelloDao {
	
	private HibernateTemplate template;
	
	public void setDataSource(SessionFactory sessionFactory){
		template = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		template.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		String hql= "from User";
		return template.find(hql);
				
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		template.delete(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		template.update(user);
	}

}
