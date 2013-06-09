package com.c1wan.ane;

import game.Game;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 初始化SDK
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class C1wanInit implements FREFunction {

	private String TAG = "C1wanInit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		Boolean isTestMode = false;
		String $gameID = null;
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做初始化的操作 我这里直接传回。。
		try
		{
			isTestMode = arg1[0].getAsBool();
			$gameID = arg1[1].getAsString();
		}
		catch(Exception e)
		{
			String status = "failed";
			_context.dispatchStatusEventAsync(TAG, "初始化回调:"+status);
			return null;
		}
		
		Game.InitGameSDK(_context, isTestMode, $gameID);
		
		callBack();
		//--------------------------------
		
		return result;
	}

	/**
	 * 初始化回调 把初始化结果传给AS端
	 */
	public void callBack(){
		Log.d(TAG, "---------初始化返回-------");
		String status = "success";
		_context.dispatchStatusEventAsync(TAG, "初始化回调:"+status);
	}

}
