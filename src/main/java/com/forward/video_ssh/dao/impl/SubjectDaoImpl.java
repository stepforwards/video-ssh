package com.forward.video_ssh.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.SubjectDao;
import com.forward.video_ssh.model.Subject;

@Repository
public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {
	
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
	public int insert(Subject record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Subject record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Subject> selectByExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject selectByPrimaryKey(Integer id) {
		return getHibernateTemplate().get(Subject.class, id);
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
	public int updateByPrimaryKeySelective(Subject record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Subject record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Subject> selectSubjectAll() {
		return (List<Subject>) getHibernateTemplate().find("from Subject");
	}

}
