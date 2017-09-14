package com.forward.video_ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.SpeakerDao;
import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Speaker;
import com.forward.video_ssh.service.SpeakerService;
import com.forward.video_ssh.utils.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	SpeakerDao sd;
	
	@Override
	public List<Speaker> selectSpeakerAll() {
		
		return sd.selectSpeakerAll();
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		sd.insert(speaker);
	}

	@Override
	public void deleteSpeakerById(Speaker speaker) {
		sd.deleteByPrimaryKey(speaker);

	}

	@Override
	public Speaker selectSpeakerById(Speaker speaker) {
		return sd.selectByPrimaryKey(speaker);
	}

	@Override
	public void updateSpeakerById(Speaker speaker) {
		sd.updateByPrimaryKey(speaker);
	}

	@Override
	public List<Speaker> selectSpeakerByKey(KeyVO kvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Page loadPage(KeyVO kvo, int currentPage) {
		Page<Speaker> page = new Page<>();
		kvo.setCurrentStrip((currentPage-1)*5);
		page.setTotal(sd.countByExample(kvo));
		page.setRows(sd.selectByKeylimit(kvo));
		page.setSize(5);
		page.setPage(currentPage);
		return page;
	}

}
