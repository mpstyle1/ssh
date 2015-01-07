package com.duzon.ssh.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;

import com.duzon.ssh.util.RequestUtil;
import com.duzon.ssh.util.ResponseUtil;
import com.duzon.ssh.util.JSONUtil;

/**
 * 공통 controller - 각각의 controller에서 상속함
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
@Controller
public class BaseController {
	protected Log log = LogFactory.getLog(this.getClass());
	protected RequestUtil requestUtil = new RequestUtil();
	protected ResponseUtil responseUtil = new ResponseUtil();
	protected JSONUtil jSONUtil = new JSONUtil();
	protected PrintWriter out;

	/**
	 * ajax 호출 에 따른 리턴 메세지를 처리
	 * 
	 * @param message
	 * @param response
	 * @throws Exception
	 */
	public void printOut(String message, HttpServletResponse response)
			throws Exception {
		out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
	}
}
