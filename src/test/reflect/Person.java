package test.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person implements Serializable {

    private String name;
    private int age;
    public Person(String name, int age) {
    	this.name=name;
    	this.age= age;
    }
    public String getName(){
    	return this.name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public int getAge(){
    	return this.age;
    }
    public void setAge(int age){
    	this.age = age;
    }
    
// get/set方法


	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	    Person person = new Person("carson", 23);
	    Class clazz = person.getClass();
	
	    Field[] fields = clazz.getDeclaredFields();
	    for (Field field : fields) {
	        String key = field.getName();
	        PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
	        Method method = descriptor.getReadMethod();
	        Object value = method.invoke(person);
	
	        System.out.println(key + ":" + value);
	
	    }
	}
}