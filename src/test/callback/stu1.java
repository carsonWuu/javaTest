package test.callback;

public class stu1 implements Student{
	
	@Override
	public void responce(Callback call) {
		// TODO Auto-generated method stub
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		call.call(3);
	}

}
