package com.duzon.ssh.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.duzon.ssh.common.Constants;
import com.duzon.ssh.common.SessionInfo;
import com.duzon.ssh.common.WebContext;


import java.io.File;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.duzon.ssh.common.SessionInfo;

import javax.servlet.ServletException;

import java.io.FileOutputStream;

/**
 * 페이지 관련 controller
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
@Controller
public class PageController extends BaseController {
	
	private WebContext webContext;
	
	@RequestMapping(value = { "/**/*.do" })
	public ModelAndView goPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		SessionInfo sess = (SessionInfo) request.getSession().getAttribute(Constants.BILL_SESSION);
			
		// 동적 파라미터 처리
		if (request.getParameterMap().size() > 0){
			HashMap<String, Object> returnVal = new HashMap<String, Object>();

			@SuppressWarnings("unchecked")
			Enumeration<String> enums = request.getParameterNames();
			String paramName = "";
			
			while (enums.hasMoreElements()) {
				paramName = (String) enums.nextElement();
				modelAndView.addObject(paramName, request.getParameter(paramName));
			}
		}
		
		//String viewName = request.getRequestURI().replaceFirst("/Bill36524Admin", "").replaceFirst("/", "").replace(".do", "").replace(".", "/");
		String viewName = request.getRequestURI().replaceFirst("/ssh", "").replaceFirst("/", "").replace(".do", "");
		
		modelAndView.setViewName(viewName);
		modelAndView.addObject("session", sess);
			
		log.info("Page Load >>>>>>>>>>>>>>>>>>>>>>>>>>>> " + viewName + ".jsp");
		
		return modelAndView;
	}
	
		
	/**
	 * Session의 존재 여부를 확인하고 존재하지 않을 경우 "/" 로 이동 시킵니다.
	 * 
	 * @param request
	 * @param response
	 * @return Session 존재 여부
	 */
	protected boolean isSession(HttpServletRequest request, HttpServletResponse response) {
		
		boolean result = false;
		
		SessionInfo sess = (SessionInfo) request.getSession().getAttribute(Constants.BILL_SESSION);
		
		if (sess != null){
			result = true;	
		}
		
		return result; 
	}
	
}
