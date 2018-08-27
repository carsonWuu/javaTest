package test.callback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThread implements Callable<String>{
	
    public String call() throws Exception
    {
        System.out.println("����CallableThread��call()����, ��ʼ˯��, ˯��ʱ��Ϊ" + System.currentTimeMillis());
        Thread.sleep(1000);
        return "123";
    }

	    
	public static void main(String[] args) throws Exception{
	    ExecutorService es = Executors.newCachedThreadPool();
	    CallableThread ct = new CallableThread();
	    Future<String> f = es.submit(ct);
	    es.shutdown();
	        
	    Thread.sleep(5000);
	    System.out.println("���̵߳ȴ�5��, ��ǰʱ��Ϊ" + System.currentTimeMillis());
	        
	    String str = f.get();
	    System.out.println("Future���õ�����, str = " + str + ", ��ǰʱ��Ϊ" + System.currentTimeMillis());
	}
}