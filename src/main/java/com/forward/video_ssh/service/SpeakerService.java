package com.forward.video_ssh.service;

import java.util.List;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Speaker;
import com.forward.video_ssh.utils.Page;

public interface SpeakerService {
	List<Speaker> selectSpeakerAll();

	void addSpeaker(Speaker speaker);

	void deleteSpeakerById(Speaker speaker);

	Speaker selectSpeakerById(Speaker speaker);

	void updateSpeakerById(Speaker speaker);

	List<Speaker> selectSpeakerByKey(KeyVO kvo);

	@SuppressWarnings("rawtypes")
	Page loadPage(KeyVO kvo, int page);
}
