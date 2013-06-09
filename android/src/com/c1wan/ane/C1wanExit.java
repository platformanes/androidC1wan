package com.c1wan.ane;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 退出SDK 清理环境
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class C1wanExit implements FREFunction {

	private String TAG = "C1wanExit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做清理环境的操作 我这里直接传回。。
		callBack();
		//--------------------------------
		
		return result;
	}

	/**
	 * 清理环境回调 把清理环境结果传给AS端
	 */
	public void callBack(){
		Log.d(TAG, "---------清理环境返回-------");
		String status = "success";
		_context.dispatchStatusEventAsync(TAG, "清理环境回调:"+status);
	}

}
