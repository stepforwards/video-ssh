package com.forward.video_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.SubjectDao;
import com.forward.video_ssh.model.Subject;
import com.forward.video_ssh.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDao sd;
	
	@Override
	public List<Subject> selectSubjectAll() {
		return sd.selectSubjectAll();
	}

	@Override
	public Subject selectSubjectById(String subjectId) {
		return sd.selectByPrimaryKey(Integer.parseInt(subjectId));
	}

}
