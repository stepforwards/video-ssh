package com.forward.video_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.CourseDao;
import com.forward.video_ssh.model.Course;
import com.forward.video_ssh.service.CourseService;
import com.forward.video_ssh.utils.Page;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseDao cd;
	
	@Override
	public List<Course> selectCourseAll() {
		return cd.selectCourseAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCourse(Course course) {
		cd.insert(course);

	}

	@Override
	public void deleteCourseById(Course course) {
		cd.deleteByPrimaryKey(course);
	}

	@Override
	public Course selectCourseById(String id) {
		return cd.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void updateCourseById(Course course) {
		cd.updateByPrimaryKey(course);
	}

	@Override
	public List<Course> selectCourseBySubjectId(String subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

}
