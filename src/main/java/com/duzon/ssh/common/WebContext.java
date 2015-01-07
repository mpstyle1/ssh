package com.duzon.ssh.common;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * WebContext 클래스
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class WebContext {

	private volatile static WebContext uniqueInstance;
	private volatile static ApplicationContext ctx;

	private WebContext(ServletContext servletContext) {
		ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext); 
	}
	
    public static WebContext getInstance(ServletContext servletContext) {   
        if (uniqueInstance == null) {   
            synchronized (WebContext.class) {   
                if (uniqueInstance == null) {   
                    uniqueInstance = new WebContext(servletContext);
                }   
            }   
        }   
        return uniqueInstance;
    }    
    
    public Object getBean(String beanId){
    	return WebContext.ctx.getBean(beanId);
    }    
}
