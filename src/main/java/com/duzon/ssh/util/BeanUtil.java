package com.duzon.ssh.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * dzWeb domain 셋팅 및 변환 클래스
 * <br>
 * @since 1.0
 * <p>
 * History<br>
 * 1.0  2012.03.02  ssh    initial version
 * 
 * @version 1.0
 * 
 * @author <a href="mailto@">ssh</a>
 */

public class BeanUtil {
	
	/**
	 * Map에 들어있는 데이터를 Bean의 Setter를 자동으로 호출해 줍니다.
	 * 
	 * @param clazz clazz 생성하고자 하는 Bean Class
	 * @param map 데이터가 들어있는 Map
	 * @return Bean Class
	 */
	@SuppressWarnings("unchecked")
	public Object toBean(Class clazz, HashMap<String, Object> map) {

		Object instance = null;

		// 이름을 가지고 하나씩 확인한다.
		String strMethodName = null;

		try {
			// 모든 Method를 추출한다.
			instance = clazz.newInstance();

			Method methods[] = clazz.getMethods();
			Object obj_value = null;
			
			for (int i = 0; i < methods.length; i++) {

				// Method 명
				strMethodName = methods[i].getName();

				// seter가 있는 경우만 값을 설정한다.
				if (strMethodName.indexOf("set") != 0)
					continue;

				// Map에서 값을 가져온다.   OBJ_DOMAIN[NM_CUST_OK]=N
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toLowerCase());
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toUpperCase());
				
				// 추후 보내는 데이터에 따라 수정해야됨
				obj_value = map.get("OBJ_VALUE[" + strMethodName.substring(3,strMethodName.length()).toUpperCase() + "]");
				
				// 값이 없으면 seter를 호출하지 않고 다음으로 넘어간다.
				if (obj_value == null || org.json.JSONObject.NULL.equals(obj_value))
					continue;
				
				if ("".equals(obj_value) || "null".equals(obj_value.toString().toLowerCase()))
					continue;

				Class parameterTypes[] = methods[i].getParameterTypes();

				// Parameter가 하나인 메서드만 실행한다.
				if (parameterTypes.length != 1)
					continue;
				
				try {
					if (Long.class.equals(parameterTypes[0]) || long.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getLong(obj_value));
					} else if (BigDecimal.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getBigDecimal(obj_value));
					} else if (Short.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getShort(obj_value));
					} else if (Integer.class.equals(parameterTypes[0]) || int.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getInteger(obj_value));
					} else {
						methods[i].invoke(instance, obj_value.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instance;
	}
	
	/**
	 * Map에 들어있는 데이터를 Bean의 Setter를 자동으로 호출해 줍니다.
	 * 
	 * @param clazz clazz 생성하고자 하는 Bean Class
	 * @param map 데이터가 들어있는 Map
	 * @return Bean Class
	 */
	@SuppressWarnings("unchecked")
	public Object toBeanHashMap(Class clazz, HashMap<String, Object> map) {

		Object instance = null;

		// 이름을 가지고 하나씩 확인한다.
		String strMethodName = null;

		try {
			// 모든 Method를 추출한다.
			instance = clazz.newInstance();

			Method methods[] = clazz.getMethods();
			Object obj_value = null;
			
			for (int i = 0; i < methods.length; i++) {

				// Method 명
				strMethodName = methods[i].getName();

				// seter가 있는 경우만 값을 설정한다.
				if (strMethodName.indexOf("set") != 0)
					continue;

				// Map에서 값을 가져온다.   OBJ_DOMAIN[NM_CUST_OK]=N
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toLowerCase());
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toUpperCase());
				
				// 추후 보내는 데이터에 따라 수정해야됨
				obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toUpperCase());
				
				// 값이 없으면 seter를 호출하지 않고 다음으로 넘어간다.
				if (obj_value == null || org.json.JSONObject.NULL.equals(obj_value))
					continue;
				
				if ("".equals(obj_value) || "null".equals(obj_value.toString().toLowerCase()))
					continue;

				Class parameterTypes[] = methods[i].getParameterTypes();

				// Parameter가 하나인 메서드만 실행한다.
				if (parameterTypes.length != 1)
					continue;
				
				try {
					if (Long.class.equals(parameterTypes[0]) || long.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getLong(obj_value));
					} else if (BigDecimal.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getBigDecimal(obj_value));
					} else if (Short.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getShort(obj_value));
					} else if (Integer.class.equals(parameterTypes[0]) || int.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getInteger(obj_value));
					} else {
						methods[i].invoke(instance, obj_value.toString());
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instance;
	}
	
	/**
	 * Map에 들어있는 데이터를 Bean의 Setter를 자동으로 호출해 줍니다.
	 * 
	 * @param clazz clazz 생성하고자 하는 Bean Class
	 * @param map 데이터가 들어있는 Map
	 * @return Bean Class
	 */
	@SuppressWarnings("unchecked")
	public Object toBeanMap(Class clazz, Map<String, Object> map) {

		Object instance = null;

		// 이름을 가지고 하나씩 확인한다.
		String strMethodName = null;

		try {
			// 모든 Method를 추출한다.
			instance = clazz.newInstance();

			Method methods[] = clazz.getMethods();
			Object obj_value = null;
			
			for (int i = 0; i < methods.length; i++) {

				// Method 명
				strMethodName = methods[i].getName();

				// seter가 있는 경우만 값을 설정한다.
				if (strMethodName.indexOf("set") != 0)
					continue;

				// Map에서 값을 가져온다.   OBJ_DOMAIN[NM_CUST_OK]=N
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toLowerCase());
				//obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toUpperCase());
				
				// 추후 보내는 데이터에 따라 수정해야됨
				obj_value = map.get(strMethodName.substring(3,strMethodName.length()).toUpperCase());
				
				// 값이 없으면 seter를 호출하지 않고 다음으로 넘어간다.
				if (obj_value == null || org.json.JSONObject.NULL.equals(obj_value))
					continue;
				
				if ("".equals(obj_value) || "null".equals(obj_value.toString().toLowerCase()))
					continue;

				Class parameterTypes[] = methods[i].getParameterTypes();

				// Parameter가 하나인 메서드만 실행한다.
				if (parameterTypes.length != 1)
					continue;
				
				try {
					if (Long.class.equals(parameterTypes[0]) || long.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getLong(obj_value));
					} else if (BigDecimal.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getBigDecimal(obj_value));
					} else if (Short.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getShort(obj_value));
					} else if (Integer.class.equals(parameterTypes[0]) || int.class.equals(parameterTypes[0])) {
						methods[i].invoke(instance, getInteger(obj_value));
					} else {
						methods[i].invoke(instance, obj_value.toString());
					}
				} catch (Exception e) {					
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return instance;
	}
	
	/**
	 * Map의 List로 되어 있는 데이터를 Bean List로 구하는 함수 입니다.
	 * 
	 * @param clazz
	 *            생성하고자 하는 Bean Class
	 * @param list
	 *            데이터가 있는 Map List
	 * @return List<Bean Class>
	 */
	@SuppressWarnings("unchecked")
	public List<Object> toBeanList(Class clazz,
		List<HashMap<String, Object>> list) {

		List<Object> result = new ArrayList();

		for (int i = 0; i < list.size(); i++) {
			result.add(toBean(clazz, list.get(i)));
		}

		return result;
	}

	/**
	 * Bean Class의 getter를 자동으로 호출하여 이를 HashMap으로 변환하여 줍니다.
	 * 
	 * @param obj
	 *            Bean Class
	 * @return 변환된 HashMap
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> toHashMap(Object obj) {
		HashMap<String, Object> result = (HashMap<String, Object>) JSONObject
				.toBean(JSONObject.fromObject(obj), HashMap.class);

		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> toHashMap(org.json.JSONObject obj) {
		// 추후에 바꾸자!!
		//Map<String, Object> map = obj.getMap();
		Map<String,Object> map = new HashMap<String,Object>();
		for (String key : org.json.JSONObject.getNames(obj)) {
			if (obj.isNull(key))
				map.put(key, null);
		}
		return map;
	}
	
	public static Short getShort(Object objValue) {
		if (objValue == null)
			return 0;
		else
		{
			return Short.parseShort(objValue.toString().trim());			
		}	
	}
	
	public static BigDecimal getBigDecimal(Object obj) {
		if (obj instanceof Integer)
			return new BigDecimal(((Integer) obj));
		else if (obj instanceof Long)
			return new BigDecimal(((Long) obj));
		else if (obj instanceof BigDecimal)
			return (BigDecimal) obj;
		else if (obj instanceof String)
			return new BigDecimal(((String) obj));
		else
			return BigDecimal.ZERO;
	}
	
	public static Long getLong(Object obj){
		if (obj instanceof Integer) {
			return (long) ((Integer) obj);
		}
		else if (obj instanceof Long) {
			return (Long) obj;
		}
		else if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).longValue();
		}
		else if (obj instanceof String || obj instanceof org.json.JSONObject) {
			return Long.parseLong((obj.toString()));
		} else {
			return 0L;
		}
	}
	
	public static Integer getInteger(Object obj) {
		if (obj instanceof Integer)
			return ((Integer) obj);
		else if (obj instanceof Long)
			return ((Long) obj).intValue();
		else if (obj instanceof BigDecimal)
			return ((BigDecimal) obj).intValue();
		else if (obj instanceof String || obj instanceof org.json.JSONObject)
			return Integer.parseInt((obj.toString()));
		else
			return 0;
	}
	
}
