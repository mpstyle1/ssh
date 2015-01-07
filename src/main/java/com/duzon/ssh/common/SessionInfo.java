package com.duzon.ssh.common;

import java.io.IOException;

/**
 * bill36524의 사용자 로그인 정보를 담고 있는 Class
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class SessionInfo {
	
	/**
	 * 로그인 시도 시 정보
	 */
	private LoginInfo loginInfo;
	
	/**
	 * 로그인 시도 시 정보
	 */
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	/**
	 * 로그인 시도 시 정보
	 */
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	/**
	 * Bill36524 회원정보
	 */
	private UserInfo userInfo;

	/**
	 * Bill36524의 사용자 정보
	 * 
	 * @return
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * Bill36524의 사용자 정보
	 * 
	 * @return
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
