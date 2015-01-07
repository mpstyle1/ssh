package com.duzon.ssh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionCheckInterceptor extends BaseInterceptor {
	
	private boolean isNonSessionPage(String page) {
		//세션이 필요 없는 페이지
		if ( page.equals("login") || page.equals("exception") ){
			return true;
		} else {
			return false;
		}
	}

	private boolean isNonSessionService(String service_id) {
		return true;
	}

	/**
	 * 모든 Controller가 실행되기 전에 미리 실행한다.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws java.lang.Exception {
		boolean result = true;
		return result;
	}
	
}
