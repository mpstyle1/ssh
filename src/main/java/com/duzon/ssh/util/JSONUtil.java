package com.duzon.ssh.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

/**
 * JSON를 생성혹은 가공하는 Util Class
 *
 * @author ssh
 * @version 1.0
 * @since 2013.10.01 주석추가
 */
public class JSONUtil {

	/**
	 * JQ_GRID에서 사용하는 Page Node의 이름
	 */
	public static final String JQ_GRID_PAGE_NODE_NAME = "page";

	public static final String JQ_GRID_PAGE_ROW_COUNT_NODE_NAME = "showRowCount";

	/**
	 * JQ_GRID에서 사용하는 총건수 Node의 이름
	 */
	public static final String JQ_GRID_TOTAL_NODE_NAME = "total";
	/**
	 * JQ_GRID에서 사용하는 Records Node의 이름
	 */
	public static final String JQ_GRID_RECORDE_NODE_NAME = "records";
	/**
	 * JQ_GRID에서 사용하는 데이터 Root Node의 이름
	 */
	//public static final String JQ_GRID_ROOT_NODE_NAME = "root";
	public static final String JQ_GRID_ROOT_NODE_NAME = "rows";
	
	/**
	 * 도메인 셋팅시 가져올 값의 이름
	 * 2011.07.08 신승현
	 */
	public static final String DOMAIN_ROOT_NODE_NAME = "OBJ_VALUE";
	public static final String DOMAIN_ROOT_NODE_NAME2 = "OBJ_VALUE2";
	
	private HashMap<String, Method> dzBaseDTOGetMethod;
	private Object dzBaseDTOKeySet[];

	/**
	 * 생성자
	 */
	public JSONUtil() {
		
	}

	/**
	 * JSON를 전달하고자 하는 View의 이름
	 * 
	 * dispatcherJSON-servlet.xml에 설정된 이름과 동일하게 설정
	 * 
	 * <context:component-scan base-package="com.duzon.fin.controller" /> <bean
	 * id="jsonView" class="net.sf.json.spring.web.servlet.view.JsonView" />
	 * <bean id="beanNameResolver"
	 * class="org.springframework.web.servlet.view.BeanNameViewResolver"
	 * p:order="0" />
	 */
	public static final String DEFAULT_RESPONSE_PAGE_URL = "jsonView";

	/**
	 * List 를 가지고 ModelAndView를 생성한다. ModelAndView에는List<DzBaseDTO>를 Json으로 변환하여
	 * 설정한다.
	 * 
	 * @param list - DzBaseDTO의 List
	 * @param response - 결과를 전달 할 HttpServletResponse
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView makeModelAndView(List list, HttpServletRequest request, HttpServletResponse response) {
		return makeModelAndView(list, request.getParameterMap(), response);
	}
	
	/**
	 * List 를 가지고 ModelAndView를 생성한다. ModelAndView에는List<DzBaseDTO>를 Json으로 변환하여
	 * 설정한다.
	 * PAGING 처리
	 * @param list - DzBaseDTO의 List
	 * @param response - 결과를 전달 할 HttpServletResponse
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView makePageModelAndView(List list, HttpServletRequest request, HttpServletResponse response) {
		return makeModelAndView(list, request.getParameterMap(), response);
	}

	/**
	 * List 를 가지고 ModelAndView를 생성한다. ModelAndView에는List<DzBaseDTO>를 Json으로 변환하여
	 * 설정한다.
	 * 
	 * @param list - DzBaseDTO의 List
	 * @param response - 결과를 전달 할 HttpServletResponse
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView makeModelAndView(List list, Map param, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		// jqGrid 필요 값 셋팅
		resultMap.put(JQ_GRID_PAGE_NODE_NAME, 1);
		resultMap.put(JQ_GRID_TOTAL_NODE_NAME, 1);
		resultMap.put(JQ_GRID_RECORDE_NODE_NAME, list.size());
		resultMap.put(JQ_GRID_ROOT_NODE_NAME, list);
		
		modelAndView.addAllObjects(resultMap);
		modelAndView.setViewName(DEFAULT_RESPONSE_PAGE_URL);
		response.setCharacterEncoding("UTF-8");

		return modelAndView;
	}
	
	

	/**
	 * 처리 요청에 대한 결과를 JSON으로 전달하기 위하여 결과 DzBaseResult를 ModelAndView에 설정하여 전달합니다.
	 * 
	 * @param result
	 *            DzBaseResult 처리결과
	 * @param response
	 *            결과를 전달 할 HttpServletResponse
	 * @return ModelAndView
	 */
	public ModelAndView makeModelAndView(Object result, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject(result);
		
		modelAndView.setViewName(DEFAULT_RESPONSE_PAGE_URL);

		response.setCharacterEncoding("UTF-8");

		return modelAndView;
	}
		
	public Map<String, Object> paramToJSONObject(HttpServletRequest req) {
		
		org.json.JSONObject jsonData = null;
		
		try {
			jsonData = new org.json.JSONObject(req.getParameter("json").toString());			
		} catch (org.json.JSONException e) {
			jsonData = null;
		}
		
		//Map<String, Object> jsonMap = jsonData.getMap();
		Map<String, Object> jsonMap = JsonHelper.toMap(jsonData);
		
		return jsonMap;
	}
	
	/**
	 * List 를 가지고 ModelAndView를 생성한다. ModelAndView에는List<DzBaseDTO>를 Json으로 변환하여
	 * 설정한다.
	 * Paging 처리
	 * @param list - DzBaseDTO의 List
	 * @param response - 결과를 전달 할 HttpServletResponse
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView makeModelAndView(List list,int totalCnt, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		int page = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("page"), "1"));
		int rows = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("rows"), "10"));
		
		
		//int records = list.size();
		int totalPage = totalCnt/rows + (totalCnt%rows > 0 ? 1:0);
		
		// jqGrid 필요 값 셋팅
		resultMap.put(JQ_GRID_PAGE_NODE_NAME, page);
		resultMap.put(JQ_GRID_TOTAL_NODE_NAME, totalPage);
		resultMap.put(JQ_GRID_RECORDE_NODE_NAME, totalCnt);
		resultMap.put(JQ_GRID_ROOT_NODE_NAME, list);
		
		modelAndView.addAllObjects(resultMap);
		modelAndView.setViewName(DEFAULT_RESPONSE_PAGE_URL);
		response.setCharacterEncoding("UTF-8");

		return modelAndView;
	}

}
