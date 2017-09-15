package com.forward.video_ssh.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.forward.video_ssh.dao.VideoDao;
import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Video;

@Repository
public class VideoDaoImpl extends HibernateDaoSupport implements VideoDao {
	
	@Autowired
	public void overSetSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Video> selectVideoListByKey(KeyVO kvo) {
		DetachedCriteria dc = DetachedCriteria.forClass(Video.class)
				.add(Restrictions.like("videoTitle", kvo.getVideoTitle(),MatchMode.ANYWHERE));
		if(kvo.getCourse() != null && kvo.getSpeaker() != null){
			dc.add(Restrictions.eq("speakerId", kvo.getSpeaker())).add(Restrictions.eq("courseId", kvo.getCourse()));
		}else if(kvo.getSpeaker() != null){
			dc.add(Restrictions.eq("speakerId", kvo.getSpeaker()));
		}else if(kvo.getCourse() != null){
			dc.add(Restrictions.eq("courseId", kvo.getCourse()));
		}
		Criteria criteria = dc.getExecutableCriteria(getHibernateTemplate().getSessionFactory().getCurrentSession());
		return criteria.setFirstResult(kvo.getCurrentStrip()).setMaxResults(5).list();
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
	public void deleteByPrimaryKey(Video video) {
		getHibernateTemplate().delete(video);
	}

	@Override
	public void insert(Video video) {
		//video.setInsertTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().save(video);
	}

	@Override
	public int insertSelective(Video record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Video> selectByExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video selectByPrimaryKey(Integer id) {
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
	public int updateByPrimaryKeySelective(Video record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Video video) {
		video.setUpdateTime(new Date(System.currentTimeMillis()));
		getHibernateTemplate().update(video);
		return 0;
	}

	@Override
	public int selectVideoListByKeyCount(KeyVO kvo) {
		String hql = "select count(*) from Video where videoTitle like ?";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = null;
		if(kvo.getCourse() != null && kvo.getSpeaker() != null){
			hql += "and courseId = ? and speakerId = ?";
			query = session.createQuery(hql).setParameter(0, "%"+kvo.getVideoTitle()+"%").setParameter(1, kvo.getCourse()).setParameter(2, kvo.getSpeaker());
		}else if(kvo.getSpeaker() != null){
			hql += "and speakerId = ?";
			query = session.createQuery(hql).setParameter(0, "%"+kvo.getVideoTitle()+"%").setParameter(1, kvo.getSpeaker());
		}else if(kvo.getCourse() != null){
			hql += "and courseId = ?";
			query = session.createQuery(hql).setParameter(0, "%"+kvo.getVideoTitle()+"%").setParameter(1, kvo.getCourse());
		}else{
			query = session.createQuery(hql).setParameter(0, "%"+kvo.getVideoTitle()+"%");
		}
		Long count = (Long) query.uniqueResult();
	 	return count.intValue();
		
		
	 	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> courseStatisticalAnalysis() {
		String sql = "SELECT avg(videoPlayTimes) avg,courseName FROM video RIGHT JOIN course ON courseId = course.id GROUP BY courseId";
		return getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
	}

	@Override
	public Video selectVideoByIdAllInfo(Video video) {
		return getHibernateTemplate().get(Video.class, video.getId());
	}

	@Override
	public List<Video> selectVideoByCourseIds(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVideoStateById(String videoId) {
		Video video = getHibernateTemplate().get(Video.class, Integer.parseInt(videoId));
		video.setVideoPlayTimes(video.getVideoPlayTimes()+1);
	}

}
