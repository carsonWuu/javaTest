package test.str;
import java.util.*;
import redis.clients.jedis.Jedis;
public class redisTest {
	public static void main(String[] args){
		Jedis jedis=new Jedis("localhost",6379);
		jedis.auth("123456");
		System.out.println("���ӳɹ�");
		System.out.println("��������������"+jedis.ping());
		System.out.println(jedis.get("name"));
		jedis.lpush("list1","c++");
		jedis.lpush("list1","java");
		List<String> list=jedis.lrange("list1",0,3);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+'\t');
		}
		Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
        }
	}
}
