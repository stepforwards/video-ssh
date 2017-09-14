package com.forward.video_ssh.dao.impl;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public void insert(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByExample(User u) {
		u.setPwdNMD5(u.getPassword());
		return (User) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", u.getEmail()))
				.add(Restrictions.eq("password", u.getPassword())).uniqueResult();
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
		u.setPwdNMD5(u.getPassword());
		return (User) getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(User.class).add(Restrictions.eq("email", u.getEmail())).uniqueResult();
	}

	@Override
	public void updateUserCaptcha(User u) {
		getHibernateTemplate().update(u);
	}

	@Override
	public User captchaEqual(User u) {
		return (User) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("email", u.getEmail()))
				.add(Restrictions.eq("captcha", u.getCaptcha())).uniqueResult();
	}

	@Override
	public void ResetPwd(User u) {
		User user = (User) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("email", u.getEmail()))
		.add(Restrictions.eq("captcha", u.getCaptcha())).uniqueResult();
		user.setPwdNMD5(u.getPassword());
		user.setCaptcha(null);
	}

	@Override
	public User updateProfile(User u) {
		User user = getHibernateTemplate().get(User.class, u.getId());
		user.setNickName(u.getNickName());
		user.setSex(u.getSex());
		user.setBirthday(u.getBirthday());
		user.setProvince(u.getProvince());
		user.setCity(u.getCity());
		return user;
	}

	@Override
	public User updatePwd(User u) {
		User user = getHibernateTemplate().get(User.class, u.getId());
		if(user.getPassword().equals(u.getOldPassword())){
			user.setPassword(u.getNewPassword());
			return user;
		}
		return null;
	}

	@Override
	public User updateAvatarInfo(User user) {
		User u = getHibernateTemplate().get(User.class, user.getId());
		u.setHeadUrl(user.getHeadUrl());
		return u;
	}

}
