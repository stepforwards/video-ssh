package com.forward.video_ssh.web.action;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.forward.video_ssh.service.StatisticalService;
import com.opensymphony.xwork2.ActionContext;

@Controller("AdminStatisticalAction")
@Scope(scopeName="prototype")
public class AdminStatisticalAction {
	
	@Autowired
	StatisticalService ss;
	
	public String statisticalAnalysis(){
		ActionContext context = ActionContext.getContext();
		List<Object[]> list = ss.courseStatisticalAnalysis();
		String courseNames = "";
		String coursePlays = "";
		for(int i = 0;i < list.size();i++){
			if(i == list.size()-1){
				coursePlays += list.get(i)[0];
				courseNames += list.get(i)[1];
				break;
			}
			coursePlays += list.get(i)[0]+"\",\"";
			courseNames += list.get(i)[1]+"\",\"";
		}
		context.put("courseNames",courseNames);
		context.put("coursePlays",coursePlays);
		return "toStatisticalAnalysis";
	}
	
}
