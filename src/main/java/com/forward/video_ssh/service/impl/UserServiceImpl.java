package com.forward.video_ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.utils.MyCaptcha;
import com.forward.video_ssh.dao.UserDao;
import com.forward.video_ssh.model.User;
import com.forward.video_ssh.service.UserService;
import com.forward.video_ssh.utils.MailUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao ud;
	
	@Override
	public boolean userRegist(User u) {
		if(ud.selectEmailByExample(u) != null){
			return false;
		}
		ud.insert(u);
		return true;
	}

	@Override
	public User userLogin(User u) {
		return ud.selectByExample(u);
	}

	@Override
	public boolean sendEmail(User u) {
		User user = ud.selectEmailByExample(u);
		if( user != null){
			String captcha = MyCaptcha.createCaptcha();
			user.setCaptcha(captcha);
			ud.updateUserCaptcha(user);
			try {
				MailUtil.send(user.getEmail(), "Video找回密码", "验证码："+captcha+"\r\n如果不是本人请忽略此邮件!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean captchaEqual(User u) {
		if(ud.captchaEqual(u) != null){
			return true;
		};
		return false;
	}

	@Override
	public void resetPwd(User u) {
		ud.ResetPwd(u);

	}

	@Override
	public User updateProfile(User u) {
		return ud.updateProfile(u);
	}

	@Override
	public boolean updatePwd(User u) {
		if(ud.updatePwd(u) != null){
			return true;
		}
		return false;
	}

	@Override
	public User updateAvatar(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateAvatarInfo(User user) {
		return ud.updateAvatarInfo(user);
	}

}
