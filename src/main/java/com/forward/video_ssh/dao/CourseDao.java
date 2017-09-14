package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.Course;
import java.util.List;

public interface CourseDao {
    int countByExample();

    int deleteByExample();

    void deleteByPrimaryKey(Course course);

    void insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample();

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(Course record);

    void updateByPrimaryKey(Course course);

	List<Course> selectCourseAllInfo(int currentPage);

	List<Course> selectCourseAll();
}