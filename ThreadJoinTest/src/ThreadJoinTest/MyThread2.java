package ThreadJoinTest;

public class MyThread2 implements Runnable{

	private ResultData prevThreadRes;
	
	public MyThread2(ResultData _prevThreadRes)
	{
		prevThreadRes=_prevThreadRes;
	}
	public void run()
	{
		prevThreadRes.res*=3;
		System.out.println("Result from Thread 2: "+prevThreadRes.res);
	}
}
