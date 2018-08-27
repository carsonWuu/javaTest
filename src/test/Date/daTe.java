package test.Date;

import java.util.Calendar;
import java.util.Date;

public class daTe {
	
	public static void main(String[] args){
		
		System.out.println(getTime());
	}
	public static String getTime(){
		String GE="";
		StringBuffer ret=new StringBuffer();
		Calendar now = Calendar.getInstance();
		ret.append(now.get(Calendar.YEAR));
		int temp = now.get(Calendar.MONTH)+1;
		GE= temp>9?String.valueOf(temp):String.valueOf("0"+temp);
		ret.append(GE);
		
		temp = now.get(Calendar.DAY_OF_MONTH);
		GE= temp>9?String.valueOf(temp):String.valueOf("0"+temp);
		ret.append(GE);
		
		temp = now.get(Calendar.HOUR_OF_DAY);
		GE= temp>9?String.valueOf(temp):String.valueOf("0"+temp);
		ret.append(GE);
	
		temp = now.get(Calendar.MINUTE);
		GE= temp>9?String.valueOf(temp):String.valueOf("0"+temp);
		ret.append(GE);
		
		temp = now.get(Calendar.SECOND);
		GE= temp>9?String.valueOf(temp):String.valueOf("0"+temp);
		ret.append(GE);
		
		return ret.toString();
	}
}
