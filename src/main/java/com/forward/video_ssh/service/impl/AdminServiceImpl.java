package com.forward.video_ssh.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forward.video_ssh.dao.AdminDao;
import com.forward.video_ssh.model.Admin;
import com.forward.video_ssh.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao ad;
	
	@Override
	public Admin login(Admin admin) {
		return ad.selectAdminByNameAndPassword(admin);
	}

}
