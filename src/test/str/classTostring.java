package test.str;
import java.util.*;
public class classTostring{
		public int a;
		public int b;
		public String c;
		public List list = new ArrayList();
		public classTostring(int a,int b,String c){
			this.a=a;
			this.b= b;
			this.c = c;
			list.add("1");
			list.add(3);
		}
		public String toString(){
			StringBuffer str = new StringBuffer();
			
			str.append("{");
			str.append(" \"a\" : "+this.a+",");
			str.append(" \"b\" : "+this.b+",");
			str.append(" \"c\" : \""+this.c+" \" , ");
			str.append(" \"u_list\" : [");
			for(int i = 0; i< list.size(); i++){
				if(i!=list.size()-1){
					str.append("{ \"d\" : "+list.get(i)+" },");
				}
				else
					str.append("{ \"d\" : "+list.get(i)+" }");
					
			}
				
			str.append(" ] }");
			return str.toString();
		}
}