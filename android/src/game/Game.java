package game;

import com.adobe.fre.FREContext;

public class Game {
	// 测试填写 'test': 正式上线填写 'dev'
	public static String test = "dev";
	// 游戏开发商注册后获取的id值
	public static String gid = "1004";
	// 项目工程的包名
	public static String packageName = "what";
	// 项目工程中主启动Activity的全路径名,格式：包名.类名
	public static String mainActivityName = "what";
	// 项目工程中用户登录后SDK回调的Activity中的action名 ,必须使用'game.sdk.+包名'
	public static String intentStr = "game.sdk." + "what";
	// 项目工程中自定义的广播权限,必须使用'mile.sdk.permission.broadcast.+包名'
	public static String customBroadcastPermisssion = "game.sdk.permission.broadcast."
			+ "what";  

	private static String TAG = "Game";
	public static void InitGameSDK(FREContext _context,Boolean isTestMode,String $gameID)
	{
		if(isTestMode)
			test = "test";
		else
			test = "dev";
		
		gid = $gameID;
		packageName = _context.getActivity().getPackageName();
		mainActivityName = packageName + "." + _context.getActivity().getLocalClassName();
		intentStr = "game.sdk." + packageName;
		customBroadcastPermisssion = "game.sdk.permission.broadcast." + packageName;
		
		String msg = "返回数据:";
		msg += "\ntestMode:"+test;
		msg += "\ngid:"+gid;
		msg += "\npackageName:"+packageName;
		msg += "\nmainActivityName:"+mainActivityName;
		msg += "\nintentStr:"+intentStr;
		msg += "\ncustomBroadcastPermisssion:"+customBroadcastPermisssion;
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
