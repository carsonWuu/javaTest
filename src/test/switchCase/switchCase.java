package test.switchCase;

public class switchCase {
	public static void main(String args[]){
		String[] str = {"a1","a2","a3"};
		for(int i=0;i<str.length;i++){
			switch(str[i]){
			case "a1":System.out.println(str[i]); break;
			case "a2":System.out.println(str[i]+"b"); break;
			}
		}
		
	}
}
