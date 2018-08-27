package test.string;

public class string {
	public int a;
	int b;
	public string(int a,int b){
		this.a=a;
		this.b=b;
	}
	public int getA(){
		return a;
	}
	public static void main(String[] args){
		string str=new string(1,2);
		System.out.println(str.b);
	}
}
