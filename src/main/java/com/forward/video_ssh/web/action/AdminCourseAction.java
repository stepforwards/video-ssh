package com.forward.video_ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.forward.video_ssh.model.Course;
import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.service.CourseService;
import com.forward.video_ssh.service.SubjectService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("AdminCourseAction")
@Scope(scopeName="prototype")
public class AdminCourseAction extends ActionSupport implements ModelDriven<Course> {
	
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	
	private Course course = new Course();
	
	private KeyVO kvo;
	public KeyVO getKvo() {
		return kvo;
	}
	public void setKvo(KeyVO kvo) {
		this.kvo = kvo;
	}
	
	@Override
	public Course getModel() {
		return course;
	}
	
	/*课程列表*/
	public String courseManagementList(){
		ActionContext context = ActionContext.getContext();
		context.put("courseList",cs.selectCourseAll());
		return "toCourseManagementList";
	}
	
	public String toAddCourse(){
		ActionContext context = ActionContext.getContext();
		context.put("subjectList",ss.selectSubjectAll());
		return "toAddCourse";
	}
	
	public String doAddCourse(){
		cs.addCourse(course);
		return "toCourseManagementListAction";
	}
	
	public String toEditorCourse(){
		ActionContext context = ActionContext.getContext();
		context.put("subjectList",ss.selectSubjectAll());
		context.put("course",cs.selectCourseById(course.getId()+""));
		return "toEditorCourse";
	}
	public String doEditorCourse(){
		cs.updateCourseById(course);
		return "toCourseManagementListAction";
	}
	
	public String deleteCourseById(){
		cs.deleteCourseById(course);
		return "toCourseManagementListAction";
	}
	
}
