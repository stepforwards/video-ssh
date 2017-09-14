package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Speaker;
import java.util.List;

public interface SpeakerDao {
    int countByExample(KeyVO kvo);

    int deleteByExample();

    void deleteByPrimaryKey(Speaker speaker);

    void insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample();

    Speaker selectByPrimaryKey(Speaker speaker);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(Speaker record);

    void updateByPrimaryKey(Speaker speaker);

	List<Speaker> selectByKeylimit(KeyVO kvo);

	List<Speaker> selectSpeakerAll();
}