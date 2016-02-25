package com.ela.thread;

public class ThreadExample implements Runnable{
	
	public static void main(String[] args)
	{
		java.lang.String threadName = "ela_thread";
		new Thread(new ThreadExample(),threadName).start();
	}

	@Override
	public void run() {
		System.out.println("my thread");
		
	}

}
