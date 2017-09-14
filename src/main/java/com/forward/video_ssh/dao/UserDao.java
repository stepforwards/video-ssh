package com.forward.video_ssh.dao;

import com.forward.video_ssh.model.User;

public interface UserDao {
    int countByExample();

    int deleteByExample();

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByExample(User u);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective();

    int updateByExample();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User selectEmailByExample(User u);
}