package test.template;

import java.util.ArrayList;
import java.util.List;

public class TemplateList<T> {
	private T data;
	private List<T> list;
	private int size=0;
	public TemplateList(){
		list = new ArrayList();
	}
	public void add(T data){
		list.add(data);
		size++;
	}
	public T get(int index){
		return list.get(index);
	}
	public int size(){
		return this.size;
	}
	public static void main(String[] args){
		TemplateList templateList = new TemplateList<>();
		templateList.add("data");
		templateList.add(1);
		templateList.add(2.0);
		for(int i = 0; i<templateList.size();i++){
			System.out.println(templateList.get(i));
		}
	}
}
