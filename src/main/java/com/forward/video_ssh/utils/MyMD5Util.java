package com.forward.video_ssh.utils;

import org.springframework.util.DigestUtils;

public class MyMD5Util {
	
	public static String MD5Encrypt(String str){
		return DigestUtils.md5DigestAsHex(str.getBytes());
	} 
}
