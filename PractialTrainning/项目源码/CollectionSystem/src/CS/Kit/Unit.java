package CS.Kit;

import CS.Frame.Main;
import CS.Mysql.LogMySql;
import CS.Object.Log;
import CS.Object.User;

public final class Unit 
{
	public static boolean Debug = true;
	public static User nowUser = new User();
	public static LogMySql logmysql = new LogMySql();
	public static float vip = 0.8f;
	
	public static Log log =  new Log();
	
	public static void putDebug(Object string)
	{
		if(Debug)
		{
			System.out.println(string);
		}
	}
}
