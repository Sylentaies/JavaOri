package com.mercury.daos;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mercury.beans.User;

public class HelloDaoBean01 extends HibernateDaoSupport implements HelloDao {

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

	@Override
	public List<User> query() {
		String hql = "from User";
		
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);

	}

}
