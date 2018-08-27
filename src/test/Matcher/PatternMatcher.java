package test.Matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
	public static void main(String args[]){
		String string = "[{ u_id: user1, name:null,nickname:null,type:1,state:0,open:0}, { u_id: user2, name:null,nickname:null,type:0,state:0,open:0}, { u_id: 333, name:null,nickname:null,type:0,state:0,open:0}]";
		String regEx ="(?<=\\{)[^\\}]+";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(string);
		while(matcher.find()){
			System.out.println("matcher.group():" + matcher.group());
			string = matcher.group();
		}
		System.out.println("捕获个数:groupCount()=" + matcher.groupCount());
	}
}
