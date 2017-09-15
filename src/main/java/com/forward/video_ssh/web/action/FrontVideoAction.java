package com.forward.video_ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.forward.video_ssh.model.Video;
import com.forward.video_ssh.service.CourseService;
import com.forward.video_ssh.service.SpeakerService;
import com.forward.video_ssh.service.SubjectService;
import com.forward.video_ssh.service.VideoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("FrontVideoAction")
@Scope(scopeName="prototype")
public class FrontVideoAction extends ActionSupport implements ModelDriven<Video>{
	
	@Autowired
	SubjectService ss;
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService speakerService;
	@Autowired
	CourseService cs;
	
	private Video video = new Video();
	
	private String videoId;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	private String subjectId;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	@Override
	public Video getModel() {
		return video;
	}
	
	
	public String index(){
		ActionContext.getContext().put("subject", ss.selectSubjectById(subjectId));
		return "toVideoIndex";
	}
	
	
	public String state(){
		vs.updateVideoStateById(videoId);
		return null;
	}
	
	public String videoData(){
		ActionContext.getContext().put("video", vs.selectVideoByIdAllInfo(videoId));
		return "toVideoContent";
	}
	
}
