package test.list;

import java.util.*;

public class list {
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
		
		
		
		List<String> list1 = new LinkedList<String>();
		
		for(int i=0;i<10000;i++){
			list.add(String.valueOf(i));
			list1.add(String.valueOf(i));
		}
		long start1= System.currentTimeMillis();
		
		
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
		
		start1= System.currentTimeMillis();
		List li=list;
		
		li.set(1,"fd");
		c(list);
		end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
		System.out.println(list);
		//System.out.println(list1);
	}
	public static void c(List list){
		List li=list;
		li.set(3,"op");
	}
}
