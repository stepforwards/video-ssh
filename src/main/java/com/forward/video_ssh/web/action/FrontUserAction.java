package com.forward.video_ssh.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.forward.video_ssh.model.Data;
import com.forward.video_ssh.model.Result;
import com.forward.video_ssh.model.User;
import com.forward.video_ssh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@Controller("FrontUserAction")
@Scope(scopeName="prototype")
public class FrontUserAction extends ActionSupport implements ModelDriven<User>{
	
	@Autowired
	UserService us;
	
	private User user = new User();
	private Result result = new Result();
	private Data data = new Data();
	private File image_file;
	private String image_fileFileName;
	private String image_fileContentType;
	
	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public File getImage_file() {
		return image_file;
	}
	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}
	public String getImage_fileFileName() {
		return image_fileFileName;
	}
	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}
	public String getImage_fileContentType() {
		return image_fileContentType;
	}
	public void setImage_fileContentType(String image_fileContentType) {
		this.image_fileContentType = image_fileContentType;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String login(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = us.userLogin(user);
		result.setSuccess(user == null ? false : true);
		result.setMessage("用户名或密码错误！");
		session.put("_front_user", user);
		session.put("user", user);
		return "resultJsonL";
	}
	
	public String regist(){
		result.setSuccess(us.userRegist(user));
		result.setMessage("该邮箱已注册！");
		return "resultJsonR";
	}
	
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("_front_user");
		session.remove("user");
		return "toLogout";
	}
	
	public String forgetpwd(){
		return "toForget_pwd";
	}
	
	public String doForgetpwd(){
		ActionContext context = ActionContext.getContext();
		context.put("email",user.getEmail());
		if(us.captchaEqual(user)){
			context.put("captcha", user.getCaptcha());
			return "toReset_Pwd";
		};
		context.put("msg", "验证码不正确！");
		return "toForget_pwd";
	}
	
	public String sendemail(){
		data.setSuccess(us.sendEmail(user));
		data.setMessage("该邮箱不存在！");
		return "data";
	}
	
	public String resetpwd(){
		us.resetPwd(user);
		return "toIndexR";
	}
	
	public String index(){
		return "toUserIndex";
	}
	
	public String profile(){
		user = (User) ActionContext.getContext().getSession().get("user");
		return "toUserProfile";
	}
	
	public String updateProfile(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = us.updateProfile(user);
		session.put("_front_user", user);
		session.put("user", user);
		return "toUserProfileR";
	}
	
	public String password(){
		return "toUserPwd";
	}
	
	public String updatePassword(){
		ActionContext context = ActionContext.getContext();
		if(us.updatePwd(user)){
			return "toUserProfileR";
		};
		context.put("pwdmsg", "原始密码错误！");
		return "toUserPwd";
	}
	
	public String avatar(){
		return "toUserAvatar";
	}
	
	public String uploadAvatar() throws IOException{
		String filename = UUID.randomUUID().toString().replaceAll("-", "");
		String extension = FilenameUtils.getExtension(image_fileFileName);
		String fileAllName = filename+"."+extension;
		FileUtils.copyFile(new File(image_file.getAbsolutePath()), new File("d:\\upload\\"+fileAllName));
		Map<String, Object> session = ActionContext.getContext().getSession();
		user.setHeadUrl("upload/"+fileAllName);
		user = us.updateAvatarInfo(user);
		session.put("_front_user", user);
		session.put("user", user);
		return "toUserAvatar";
	}
}
