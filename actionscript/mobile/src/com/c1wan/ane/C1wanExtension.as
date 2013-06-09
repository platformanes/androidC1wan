package com.c1wan.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class C1wanExtension extends EventDispatcher 
	{ 
		public static const C1WAN_FUNCTION_INIT:String = "c1wan_function_init";//与java端中Map里的key一致
		public static const C1WAN_FUNCTION_LOGIN:String = "c1wan_function_login";//与java端中Map里的key一致
		public static const C1WAN_FUNCTION_PAY:String = "c1wan_function_pay";//与java端中Map里的key一致
		public static const C1WAN_FUNCTION_EXIT:String = "c1wan_function_exit";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.c1wan.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:C1wanExtension; 
		public function C1wanExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():C1wanExtension
		{
			if(_instance == null) 
				_instance = new C1wanExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		/**
		 * 
		 * @param isTestMode 是否是测试模式
		 * @param $gameID  GAME_ID
		 * @return 
		 * 
		 */			
		public function C1wanInit(isTestMode:Boolean,$gameID:String):String{
			if(extContext ){
				return extContext.call(C1WAN_FUNCTION_INIT,isTestMode,$gameID) as String;
			}
			return "call login failed";
		} 
		
		/**
		 *登录发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function C1wanLogIn(key:int):String{
			if(extContext ){
				return extContext.call(C1WAN_FUNCTION_LOGIN,key) as String;
			}
			return "call login failed";
		} 
		/**
		 *付费发送函数 
		 * @param data 
		 * @return 
		 * 
		 */		 
		public function C1wanPay(data:Vector.<String>,len:int = 5):String{
			if(extContext && data.length == len){ 
				return extContext.call(C1WAN_FUNCTION_PAY,data)as String;
			}
			return "call pay failed";
		}
		
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function ExitSDKHandle(key:int):String{
			if(extContext){ 
				return extContext.call(C1WAN_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
	} 
}