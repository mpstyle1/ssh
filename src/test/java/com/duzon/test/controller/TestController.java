package com.duzon.test.controller;

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
import com.duzon.ssh.controller.BaseController;

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
public class TestController extends BaseController {
	
	private WebContext webContext;
	
	@RequestMapping("/hello.do")
	public ModelAndView goPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		SessionInfo sess = (SessionInfo) request.getSession().getAttribute(Constants.BILL_SESSION);
		org.springframework.ui.ModelMap mod = new org.springframework.ui.ModelMap();
		//mod.add
		
	
		
		return modelAndView;
	}
	
}
