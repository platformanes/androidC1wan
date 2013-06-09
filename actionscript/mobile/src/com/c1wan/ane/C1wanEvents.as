package com.c1wan.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class C1wanEvents 
	{ 
		public function C1wanEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 *init 
		 */		
		public static const C1WAN_SDK_STATUS:String = "C1wanInit";
		/**
		 * 用户登录
		 */
		public static const C1WAN_LOGIN_STATUS : String = "C1wanLogin";
		
		/**
		 * 用户注销
		 */
		public static const C1WAN_LOGOUT_STATUS : String = "C1wanExit";
		
		/**
		 * 充值
		 */
		public static const C1WAN_PAY_STATUS : String = "C1wanPay";
	} 
}