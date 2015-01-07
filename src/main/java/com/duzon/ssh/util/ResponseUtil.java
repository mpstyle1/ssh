package com.duzon.ssh.util;

import java.util.HashMap;

import net.sf.json.JSONObject;

/**
 * response 처리시 사용되는 util 클래스
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class ResponseUtil {

	public String mapToJson(HashMap param) {
	
		JSONObject obj = JSONObject.fromObject(param);
		
		return obj.toString();
	}
}
