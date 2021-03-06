package com.json;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
 

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
 
public class ReadJSON {
    public static void main(String args[]){
        try {
        	String root = System.getProperty("user.dir");
        	
        	String abcPath = root + File.separator + File.separator + "test.json";
        	System.out.println(abcPath);
            JsonParser parser=new JsonParser();  //创建JSON解析器
            JsonObject object=(JsonObject) parser.parse(new FileReader("./test.json"));  //创建JsonObject对象
            System.out.println("cat="+object.get("cat").getAsString()); //将json数据转为为String型的数据
            System.out.println("pop="+object.get("pop").getAsBoolean()); //将json数据转为为boolean型的数据
             
            JsonArray array=object.get("language").getAsJsonArray();    //得到为json的数组
            for(int i=0;i<array.size();i++){
                System.out.println("---------------");
                JsonObject subObject=array.get(i).getAsJsonObject();
                System.out.println("id="+subObject.get("id").getAsInt());
                System.out.println("name="+subObject.get("name").getAsString());
                System.out.println("ide="+subObject.get("ide").getAsString());
            }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}