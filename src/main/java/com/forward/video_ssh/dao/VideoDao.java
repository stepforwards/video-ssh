package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Video;
import java.util.List;

public interface VideoDao {
	
	List<Video> selectVideoListByKey(KeyVO kvo);
	
   int countByExample();

    int deleteByExample();

    void deleteByPrimaryKey(Video video);

    void insert(Video record);

    int insertSelective(Video record);

  List<Video> selectByExample();

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	

	int selectVideoListByKeyCount(KeyVO kvo);

	List<Object[]> courseStatisticalAnalysis();

	Video selectVideoByIdAllInfo(Video video);

	List<Video> selectVideoByCourseIds(Integer courseId);
}