package com.forward.video_ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.UserDao;
import com.forward.video_ssh.model.User;
import com.forward.video_ssh.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao ud;
	
	@Override
	public boolean userRegist(User u) {
		if(ud.selectEmailByExample(u) != null){
			return true;
		}
		return false;
	}

	@Override
	public User userLogin(User u) {
		return ud.selectByExample(u);
	}

	@Override
	public boolean sendEmail(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean captchaEqual(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPwd(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User updataProfile(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updataPwd(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updataAvatar(User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
