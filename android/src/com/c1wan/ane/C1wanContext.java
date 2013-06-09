package com.c1wan.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

/**
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class C1wanContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String C1WAN_FUNCTION_INIT = "c1wan_function_init";
	/**
	 * 登录Key
	 */
	public static final String C1WAN_FUNCTION_LOGIN = "c1wan_function_login";
	/**
	 * 付费Key
	 */
	public static final String C1WAN_FUNCTION_PAY = "c1wan_function_pay";
	/**
	 * 退出Key
	 */
	public static final String C1WAN_FUNCTION_EXIT = "c1wan_function_exit";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(C1WAN_FUNCTION_INIT, new C1wanInit());
	       map.put(C1WAN_FUNCTION_LOGIN, new C1wanLogin());
	       map.put(C1WAN_FUNCTION_PAY, new C1wanPay());
	       map.put(C1WAN_FUNCTION_EXIT, new C1wanExit());
	       return map;
	}

}
