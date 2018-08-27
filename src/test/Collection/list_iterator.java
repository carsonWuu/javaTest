package test.Collection;
import java.util.*;
public class list_iterator {
	public static void main(String[] args){
		List<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		for(String temp:list){
			if("1".equals(temp)){
				list.remove(temp);
			}
		}
		System.out.println(list);
	}
}
