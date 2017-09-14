package com.forward.video_ssh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.UserDao;
import com.forward.video_ssh.model.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@Autowired
	public void overSetSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public int countByExample() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User selectByExample(User u) {
		List<User> list = (List<User>) getHibernateTemplate().find("from User where email = ? and password = ?",u.getEmail(),u.getPassword());
		return  list == null ? null : list.get(0);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectEmailByExample(User u) {
		/*getHibernateTemplate().find("", values)*/
		return null;
	}

}
