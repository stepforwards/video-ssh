package com.forward.video_ssh.web.action;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.forward.video_ssh.service.CourseService;
import com.forward.video_ssh.service.SubjectService;
import com.forward.video_ssh.service.VideoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
@Controller("FrontCourseAction")
@Scope(scopeName="prototype")
public class FrontCourseAction extends ActionSupport {
	
	@Autowired
	SubjectService ss;
	@Autowired
	CourseService cs;
	@Autowired
	VideoService vs;
	
	private String subjectId;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	
	public String index(){
		ActionContext.getContext().put("subject", ss.selectSubjectById(subjectId));
		return "toCourseIndex";
	}
}
