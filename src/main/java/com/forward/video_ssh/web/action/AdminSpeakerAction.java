package com.forward.video_ssh.web.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forward.video_ssh.model.KeyVO;
import com.forward.video_ssh.model.Speaker;
import com.forward.video_ssh.service.SpeakerService;
import com.forward.video_ssh.utils.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("AdminSpeakerAction")
@Scope(scopeName="prototype")
public class AdminSpeakerAction extends ActionSupport implements ModelDriven<Speaker>{
	
	@Autowired
	SpeakerService ss;
	
	private Speaker speaker = new Speaker();
	
	private Integer page = 1;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	private KeyVO kvo = new KeyVO();
	public KeyVO getKvo() {
		return kvo;
	}
	public void setKvo(KeyVO kvo) {
		this.kvo = kvo;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/speakerManagementList.action")
	public String speakerManagementList(){
		ActionContext context = ActionContext.getContext();
		int currentPage = page.intValue();
		System.out.println(kvo);
		Page pages = ss.loadPage(kvo,currentPage);
		context.put("speakerList",pages.getRows());
		context.put("pages",pages);
		return "toSpeakerManagementList";
	}
	
	public String toAddSpeaker(){
		return "toAddSpeaker";
	}
	public String doAddSpeaker(){
		ss.addSpeaker(speaker);
		return "toSpeakerManagementListAction";
	}
	
	public String deleteSpeakerById(){
		ss.deleteSpeakerById(speaker);
		return "toSpeakerManagementListAction";
	}
	
	public String toEditorSpeaker(){
		ActionContext context = ActionContext.getContext();
		context.put("speaker",ss.selectSpeakerById(speaker));
		return "toEditorSpeaker";
	}
	public String doEditorSpeaker(){
		ss.updateSpeakerById(speaker);
		return "toSpeakerManagementListAction";
	}

	@Override
	public Speaker getModel() {
		return speaker;
	}
}
