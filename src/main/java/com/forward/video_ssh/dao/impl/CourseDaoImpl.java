package com.forward.video_ssh.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.CourseDao;
import com.forward.video_ssh.model.Course;

@Repository
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
	
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
	public void deleteByPrimaryKey(Course course) {
		getHibernateTemplate().delete(course);
	}

	@Override
	public void insert(Course course) {
		course.setInsertTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(course);
	}

	@Override
	public int insertSelective(Course record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Course> selectByExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course selectByPrimaryKey(Integer id) {
		return getHibernateTemplate().get(Course.class, id);
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
	public int updateByPrimaryKeySelective(Course record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateByPrimaryKey(Course course) {
		course.setUpdateTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().update(course);
	}

	@Override
	public List<Course> selectCourseAllInfo(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> selectCourseAll() {
		return (List<Course>) getHibernateTemplate().find("from Course");
	}

}
