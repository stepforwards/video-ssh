package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.User;

public interface UserDao {
    int countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(Integer id);

    void insert(User user);

    int insertSelective(User record);

    User selectByExample(User u);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectEmailByExample(User u);

	void updateUserCaptcha(User u);

	User captchaEqual(User u);

	void ResetPwd(User u);

	User updateProfile(User u);

	User updatePwd(User u);

	User updateAvatarInfo(User user);
}