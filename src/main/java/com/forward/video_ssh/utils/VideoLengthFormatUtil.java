package com.forward.video_ssh.utils;

public class VideoLengthFormatUtil {
	
	public static String formatTimeLength(Integer timeLength){
		int hour = timeLength / 3600;
	 	int minute = (timeLength - hour * 3600) / 60 ;
	 	int second = timeLength - hour * 3600 - minute * 60;
	 	return String.format("%02d:%02d:%02d",hour,minute,second);
	}
}
