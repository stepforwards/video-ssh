package com.forward.video_ssh.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
@Controller("FrontIndexAction")
@Scope(scopeName="prototype")
public class FrontIndexAction extends ActionSupport{
	
	
	public String indexFront(){
		return "toIndex";
	}
	
}
