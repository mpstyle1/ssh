package com.duzon.ssh.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.http.HttpServletRequest;

import com.duzon.ssh.util.BeanUtil;

/**
 * request 처리시 사용되는 util 클래스
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class RequestUtil {
	
	protected BeanUtil beanUtil = new BeanUtil();
	
	/**
	 * HttpServletRequest에 있는 Parameter를 HashMap으로 변환하여 리턴합니다.
	 * 
	 * @param request
	 * @return HashMap으로 변환된 Parameter
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> paramToHashMap(HttpServletRequest request) {

		HashMap<String, Object> returnVal = new HashMap<String, Object>();
		
		Enumeration<String> enums = request.getParameterNames();
		String paramName = "";

		while (enums.hasMoreElements()) {
			paramName = (String) enums.nextElement();
			
			returnVal.put(paramName, request.getParameter(paramName));
		}
		
		return returnVal;
	}
	
	/**
	 * HttpServletRequest에 있는 Parameter의 JsonObject를 HashMap으로 변환하여 리턴합니다.
	 * 
	 * @param request
	 * @return HashMap으로 변환된 Parameter
	 */
	public Map<String, Object> paramToJSONObject(HttpServletRequest req) {
		
		org.json.JSONObject jsonData = null;
		Map<String, Object> jsonMap = null;
		
		try {
			if ( req.getParameter("json") != null){
				jsonData = new org.json.JSONObject(req.getParameter("json").toString());
				////jsonMap = jsonData.getMap();
				jsonMap = JsonHelper.toMap(jsonData);
			} else {
				jsonMap = paramToHashMap(req);
			}
			
		} catch (org.json.JSONException e) {
			jsonData = null;
		}
		
		return jsonMap;
	}
	
	/**
	 * map 형식을 Hashtable 형태로 리턴합니다.
	 * 
	 * @param request
	 * @return HashMap으로 변환된 Parameter
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> mapToHashMap(Map<String, Object> map) {
				
		HashMap<String, Object> returnVal = new HashMap<String, Object>();
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			Map.Entry entry =  (Map.Entry)it.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			if(key==null)
				key = "" + null;
	          
			if(val==null)
				val = "" + null;
	          
			returnVal.put((String) key, val);
		}
		return returnVal;
		
	}
	
	/**
	 * domain 객체에 값을 셋팅해서 반환합니다.
	 * 
	 * @param String, Object
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object setDomain(String className, Object jsonMap) {
		
		Object returnObj = new Object();
		
		Class clazz = null;
		
		// domain class 형태
		if ( jsonMap.getClass().toString().equals("class org.json.JSONObject") )
		{
			org.json.JSONObject jsonVal = (org.json.JSONObject) jsonMap;
			//Map<String, Object> jsonObj = jsonVal.getMap();
			Map<String, Object> jsonObj = JsonHelper.toMap(jsonVal);
			
			try {
				clazz = Class.forName(className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object domain = beanUtil.toBeanMap((Class) clazz, jsonObj);
			
			returnObj = domain;
		}
		// list 형태
        else if ( jsonMap.getClass().toString().equals("class org.json.JSONArray") )
        {
        	org.json.JSONArray jsonArray = null;
			try {
				jsonArray = new org.json.JSONArray(jsonMap.toString());
			} catch (org.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HashMap<String, Object> rowHashMap = null;
			List list = new ArrayList();
			
			for (int i = 0; i < jsonArray.length(); i++) {

				try {
					//rowHashMap = (HashMap<String, Object>) jsonArray.getJSONObject(i).getMap();
					Map<String, Object> tempMap = JsonHelper.toMap(jsonArray.getJSONObject(i));
					////rowHashMap = mapToHashMap(tempMap);
				} catch (org.json.JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					clazz = Class.forName(className);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object domainlist = beanUtil.toBeanHashMap((Class) clazz, rowHashMap);
				
				list.add(domainlist);
				
				if ( i == jsonArray.length()-1 )
					returnObj = list;
			}
        }
        else if (jsonMap.getClass().toString().equals("class java.util.HashMap")){
        	
        	try {
				clazz = Class.forName(className);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Object domain = beanUtil.toBeanHashMap((Class) clazz, (HashMap) jsonMap);
			
			returnObj = domain;
        }
        else
        {
        	//resultMap.put(objName, jsonMap);
        	returnObj = jsonMap;
        }
		return returnObj;
	}
	
}
