package test.str;

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
        	
            JsonParser parser=new JsonParser();  //����JSON������
            JsonObject object=(JsonObject) parser.parse(new FileReader("d:/test.json"));  //����JsonObject����
            System.out.println("cat="+object.get("cat").getAsString()); //��json���תΪΪString�͵����
            System.out.println("pop="+object.get("pop").getAsBoolean()); //��json���תΪΪboolean�͵����
             
            JsonArray array=object.get("language").getAsJsonArray();    //�õ�Ϊjson������
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