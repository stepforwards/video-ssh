package com.forward.video_ssh.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.AdminDao;
import com.forward.video_ssh.model.Admin;

@Repository
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
	
	@Autowired
	public void overSetSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	
	@Override
	public Admin selectAdminByNameAndPassword(Admin admin) {
		return (Admin) getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Admin.class)
		.add(Restrictions.eq("loginName", admin.getLoginName())).add(Restrictions.eq("loginPwd", admin.getLoginPwd())).uniqueResult();
	}
}
