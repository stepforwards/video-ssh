package com.forward.video_ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.SpeakerDao;
import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Speaker;

@Repository
public class SpeakerDaoImpl extends HibernateDaoSupport implements SpeakerDao {
	
	@Autowired
	public void overSetSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public int countByExample(KeyVO kvo) {
		System.out.println(kvo);
		String hql = "select count(*) from Speaker where speakerName like ? and speakerJob like ?";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return ((Long) session.createQuery(hql)
		.setParameter(0, "%"+kvo.getSpeakerName()+"%")
		.setParameter(1, "%"+kvo.getSpeakerJob()+"%")
		.uniqueResult()).intValue();
	}

	@Override
	public int deleteByExample() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByPrimaryKey(Speaker speaker) {
		getHibernateTemplate().delete(speaker);
	}

	@Override
	public void insert(Speaker speaker) {
		getHibernateTemplate().save(speaker);
	}

	@Override
	public int insertSelective(Speaker record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Speaker> selectByExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Speaker selectByPrimaryKey(Speaker speaker) {
		return getHibernateTemplate().get(Speaker.class, speaker.getId());
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
	public int updateByPrimaryKeySelective(Speaker record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateByPrimaryKey(Speaker speaker) {
		getHibernateTemplate().update(speaker);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> selectByKeylimit(KeyVO kvo) {
		System.out.println(kvo);
		String hql = "from Speaker where speakerName like ? and speakerJob like ?";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return session.createQuery(hql)
		.setParameter(0, "%"+kvo.getSpeakerName()+"%")
		.setParameter(1, "%"+kvo.getSpeakerJob()+"%")
		.setFirstResult(kvo.getCurrentStrip())
		.setMaxResults(5)
		.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> selectSpeakerAll() {
		
		return (List<Speaker>) getHibernateTemplate().find("from Speaker");
	}

}
