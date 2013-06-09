package com.c1wan.ane;

import wxd.util.CallbackListener;
import wxd.util.Operate;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 执行登录
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class C1wanLogin implements FREFunction {

	private String TAG = "C1wanLogin";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
//		wxd.view.R._context = context;
		FREObject result = null;  
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做登录的操作 我这里直接传回。。
		Log.d(TAG, "---------R.java处理-------");
		ResHandle.setResourctID(_context, TAG);
		Log.d(TAG, "---------Login开始-------");
		MyPay my = new MyPay();
		Log.d(TAG, "---------Login New MyPay OK-------");
		Operate.setOperateGame(my);
		Log.d(TAG, "---------Login SetOG OK-------");
		Operate.startMain(_context.getActivity(), new CallbackListener()
		{
			public void loginReback(String platformID, String session, String userID)
			{
				MyPay.platformID = Integer.parseInt(platformID);
				MyPay.gamesession = session;
				MyPay.gameUserID = Integer.parseInt(userID);
				
				String msg = "返回数据";
				msg += "*"+0; 
				msg += "*"+userID;
				msg += "*"+session;
				msg += "*"+platformID;
				callBack(msg);
			}
		});
		Log.d(TAG, "---------Login startMain OK-------");
		//--------------------------------
		
		return result;
	}
	
	/**
	 * 登录回调 把登录结果传给AS端 一般都会把获得的游戏ID传回去  怎么传自己看着办
	 */
	public void callBack(String str){
		Log.d(TAG, "---------Login返回-------");
		_context.dispatchStatusEventAsync(TAG, str);
	}
}
