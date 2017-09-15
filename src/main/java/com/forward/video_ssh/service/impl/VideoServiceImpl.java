package com.forward.video_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.VideoDao;
import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Video;
import com.forward.video_ssh.service.VideoService;
import com.forward.video_ssh.utils.Page;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoDao vd;
	
	@Override
	public List<Video> selectVideoListByKey(KeyVO kvo) {
		return vd.selectVideoListByKey(kvo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(KeyVO kvo, int currentPage) {
		Page<Video> page = new Page<>();
		kvo.setCurrentStrip((currentPage-1)*5);
		page.setTotal(vd.selectVideoListByKeyCount(kvo));
		page.setRows(vd.selectVideoListByKey(kvo));
		page.setSize(5);
		page.setPage(currentPage);
		return page;
	}

	@Override
	public void saveVideo(Video v) {
		vd.insert(v);
	}

	@Override
	public void deleteVideoById(Video video) {
		vd.deleteByPrimaryKey(video);
		
	}

	@Override
	public Video selectVideoById(Video video) {
		return vd.selectVideoByIdAllInfo(video);
	}

	@Override
	public void updateVideoById(Video v) {
		vd.updateByPrimaryKey(v);
		
	}

	@Override
	public void deleteVideoByQuery(String[] id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Video> selectVideobyCourseIds(Integer[] courseIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateVideoStateById(String videoId) {
		vd.updateVideoStateById(videoId);
	}

	@Override
	public List<Video> selectVideobyCourseId(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video selectVideoByIdAllInfo(String videoId) {
		Video video = new Video();
		video.setId(Integer.parseInt(videoId));
		return vd.selectVideoByIdAllInfo(video);
	}

	@Override
	public List<Video> selectVideobyCourseIds(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}
}
