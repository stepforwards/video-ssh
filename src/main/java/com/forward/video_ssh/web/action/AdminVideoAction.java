package com.forward.video_ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Video;
import com.forward.video_ssh.service.CourseService;
import com.forward.video_ssh.service.SpeakerService;
import com.forward.video_ssh.service.VideoService;
import com.forward.video_ssh.utils.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("AdminVideoAction")
@Scope(scopeName = "prototype")
public class AdminVideoAction extends ActionSupport implements ModelDriven<Video> {

	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;

	private Integer page = 1;
	private String[] ids;
	private KeyVO kvo = new KeyVO();
	private Video video = new Video();
	
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public KeyVO getKvo() {
		return kvo;
	}

	public void setKvo(KeyVO kvo) {
		this.kvo = kvo;
	}

	

	@SuppressWarnings("rawtypes")
	public String videoManagementList() {
		ActionContext context = ActionContext.getContext();
		int currentPage = page.intValue();
		Page pages = vs.loadPage(kvo, currentPage);
		context.put("courseList", cs.selectCourseAll());
		context.put("speakerList", ss.selectSpeakerAll());
		context.put("videoList", pages.getRows());
		context.put("pages", pages);
		return "toVideo";
	}

	public String toAddVideo() {
		ActionContext context = ActionContext.getContext();
		context.put("courseList", cs.selectCourseAll());
		context.put("speakerList", ss.selectSpeakerAll());
		return "toAddVideo";
	}

	public String doAddVideo() {
		vs.saveVideo(video);
		return "toVideoAction";
	}

	public String deleteVideoById() {
		vs.deleteVideoById(video);
		return "toVideoAction";
	}
	
	public String deleteVideoByQuery() {
		for(int i = 0;i < ids.length;i++){
			video.setId(Integer.parseInt(ids[i]));
			vs.deleteVideoById(video);
		}
		return "toVideoAction";
	}

	public String editorVideoById() {
		ActionContext context = ActionContext.getContext();
		context.put("courseList", cs.selectCourseAll());
		context.put("speakerList", ss.selectSpeakerAll());
		context.put("video", vs.selectVideoById(video));
		return "toEditorVideoInfo";
	}

	public String doEditorVideoById() {
		vs.updateVideoById(video);
		return "toVideoAction";
	}
	

	@Override
	public Video getModel() {
		return video;
	}
}
