package test.Runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test implements Runnable{
	int i;
	public test(int i){
		this.i=i;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(i);
		
	}
	public static void main(String[] args){
		ExecutorService exec= Executors.newFixedThreadPool(10);
		for(int i=0;i<1000;i++){
			exec.execute(new test(i));
		}
	}
	
}
