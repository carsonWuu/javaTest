package test.map;

import java.util.*;
import java.util.Map.Entry;
public class map {
	public static void main(String[] args){
		Map<String,String> map = new TreeMap<String,String>();
		
		
		
		Map<String,String> map1 = new HashMap<String,String>();
		
		for(int i=0;i<1000000;i++){
			map.put(String.valueOf(Math.random()*i),String.valueOf(Math.random()*i));
			map1.put(String.valueOf(Math.random()*i),String.valueOf(Math.random()*i));
		}
		long start1= System.currentTimeMillis();
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry e=(Entry) it.next();
//			System.out.println(e.getKey() + " : " +e.getValue());
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
		
		start1= System.currentTimeMillis();
		Iterator it1 = map1.entrySet().iterator();
		while(it1.hasNext()){
			Entry e=(Entry) it1.next();
			//System.out.println(e.getKey() + " : " +e.getValue());
		}
		end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
//		System.out.println(map);
//		System.out.println(map1);
	}
}
