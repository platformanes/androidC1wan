package com.c1wan.ane;

import android.util.Log;
import wxd.util.OperateGame;
/**
 * @param Rect
 *            
 */
public class MyPay implements OperateGame {

	public static int gameUserID = -1;
	public static String gamesession = null;
	public static int platformID = -1;
	public static int serverID = 1;
	private String TAG = "C1wanPay MyPay";
	@Override
	public void payFinish(String user) {
		// TODO Auto-generated method stub
		Log.d(TAG, "---------C1wan Pay 返回函数-------");
	} 

}
