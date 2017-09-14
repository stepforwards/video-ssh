package com.forward.video_ssh.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;

import com.forward.video_ssh.model.Admin;
import com.forward.video_ssh.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("AdminAction")
@Scope(scopeName="prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	
	@Autowired
	AdminService as;
	
	private Admin admin = new Admin();
	
	@Override
	public Admin getModel() {
		return admin;
	}
	
	public String indexBackstage(){
		return "toLogin";
	}
	
	public String login(){
		admin.setLoginPwd(DigestUtils.md5DigestAsHex(admin.getLoginPwd().getBytes()));
		admin = as.login(admin);
		if(admin != null){
			ActionContext.getContext().getSession().put("admin", admin);
			return "toVideoAction";
		}
		return "toLogin";
	}
	
	public String exit(){
		ActionContext.getContext().getSession().remove("admin");
		return "exit";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	admin登录
	@RequestMapping(value="/login.action",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		Admin admin = as.login(username, password);
		if(admin != null){
			session.setAttribute("admin", admin);
			return "forward:/video/videoManagementList.action";
		}
		return "redirect:/index.jsp";
	}
	
	admin退出
	@RequestMapping(value="/logout.action",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "/admin/indexBackstage";
	}
	
*/
}
