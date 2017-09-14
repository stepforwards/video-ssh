package com.forward.video_ssh.service;

import java.util.List;

import com.forward.video_ssh.model.Course;
import com.forward.video_ssh.utils.Page;

public interface CourseService {
	
	List<Course> selectCourseAll();

	@SuppressWarnings("rawtypes")
	Page loadPage(int currentPage);

	void addCourse(Course course);

	void deleteCourseById(Course course);

	Course selectCourseById(String id);

	void updateCourseById(Course course);

	List<Course> selectCourseBySubjectId(String subjectId);
}
