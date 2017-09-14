package com.forward.video_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.VideoDao;
import com.forward.video_ssh.service.StatisticalService;

@Service
public class StatisticalServiceImpl implements StatisticalService {
	
	@Autowired
	VideoDao vd;
	
	@Override
	public List<Object[]> courseStatisticalAnalysis() {
		return vd.courseStatisticalAnalysis();
	}

}
