package com.c1wan.ane;

import wxd.util.Operate;
import android.util.Log;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * 执行付费
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class C1wanPay implements FREFunction {

	private String TAG = "C1wanPay";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 我这里直接传回。。
		Log.d(TAG, "---------C1wan Pay Begin-------");
		MyPay my = new MyPay();
		Operate.setOperateGame(my);
		try
		{
			FREArray __array = (FREArray) arg1[0];
			int __len = (int)__array.getLength();
			if(__len < 1)
			{
				callBack("传入参数有误. "); 
				return null;
			}
			String str  = __array.getObjectAt(0).getAsString();
			MyPay.serverID = Integer.parseInt(str);
			Log.d(TAG, "---------C1wan Pay serverID-------"+MyPay.serverID);
		}
		catch(Exception e)
		{
			Log.d(TAG, "---------C1wan Pay error-------"+e.getMessage());
			callBack("传入参数有误");
			return result;
		}
		
		if(MyPay.gameUserID != -1)
		{
			Operate.payMoney(_context.getActivity(), MyPay.serverID);
		}
		else 
		{
			callBack("尚未登录");
			return result;
		}
		
		//--------------------------------
		
		return result;
	}

	/**
	 * 付费回调 把付费结果传给AS端
	 */
	public void callBack(String status){
		Log.d(TAG, "---------付费返回-------");
		_context.dispatchStatusEventAsync(TAG,status);
	}
}
