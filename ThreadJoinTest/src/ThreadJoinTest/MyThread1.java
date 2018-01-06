package ThreadJoinTest;

public class MyThread1 implements Runnable{

	ResultData commonArea;
	public MyThread1(ResultData _cArea)
	{
		commonArea=_cArea;
	}
	public void run()
	{
		commonArea.res=5*3;
		System.out.println("Result from thread 1 :" + commonArea.res);
	}
}
