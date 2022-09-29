package rs.ac.ni.pmf.oop3.zad2;

import java.util.concurrent.TimeUnit;

public class WaitUtil
{
	public static void sleep(long timeout)
	{
		try
		{
			TimeUnit.SECONDS.sleep(timeout);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
