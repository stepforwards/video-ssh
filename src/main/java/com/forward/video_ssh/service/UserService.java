package com.forward.video_ssh.service;

import com.forward.video_ssh.model.User;

public interface UserService {
	
	boolean userRegist(User u);

	User userLogin(User u);

	boolean sendEmail(User u);

	boolean captchaEqual(User u);

	void resetPwd(User u);

	User updateProfile(User u);

	boolean updatePwd(User u);

	User updateAvatar(User u);

	User updateAvatarInfo(User user);

}
