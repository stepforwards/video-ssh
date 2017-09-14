package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.Subject;
import java.util.List;

public interface SubjectDao {
    int countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample();

    Subject selectByPrimaryKey(Integer id);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

	List<Subject> selectSubjectAll();
}