package com.example.crud.message;

import jakarta.servlet.http.HttpServletRequest;

public class Message {
	
	public static String showAlert(String msg) {
		
		return "<script>alert('" + msg + "');</script>";
	}
	
	public static String showAlertBackPage(String msg) {
				
		return "<script>alert('" + msg + "'); history.go(-1)</script>";
	}
	
	public static String showAlertMovePage(String msg, String url) {
		
		return "<script>alert('" + msg + "'); location.href='" + url + "';</script>";
	}
	
	public static String movePage(String url) {
		return "<script>location.href='" + url + "';</script>";
	}
	
	public static String jsAlertBackPage(String msg) {
		return "/resource/common/common.js";
	}
	
	
	
}
