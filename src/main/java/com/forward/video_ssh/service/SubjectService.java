package com.forward.video_ssh.service;

import java.util.List;

import com.forward.video_ssh.model.Subject;

public interface SubjectService {
	
	List<Subject> selectSubjectAll();

	Subject selectSubjectById(String subjectId);

}
