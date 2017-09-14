package com.forward.video_ssh.service;

import java.util.List;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Video;
import com.forward.video_ssh.utils.Page;

public interface VideoService {
	
	List<Video> selectVideoListByKey(KeyVO kvo);
	
	@SuppressWarnings("rawtypes")
	Page loadPage(KeyVO kvo, int currentPage);

	void saveVideo(Video v);

	void deleteVideoById(Video video);

	Video selectVideoById(Video video);

	void updateVideoById(Video v);

	void deleteVideoByQuery(String[] id);

	

	List<Video> selectVideobyCourseIds(Integer[] courseIds);

	void updateVideoStateById(String videoId);

	List<Video> selectVideobyCourseId(Integer integer);

	Video selectVideoByIdAllInfo(String videoId);

	List<Video> selectVideobyCourseIds(Integer courseId);
}
