package leetcode;
import java.util.*;
/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
这道题给定一个数字n，让生成共有n个括号的所有正确的形式，对于这种列出所有结果的题首先还是考虑用递归Recursion来解，由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，右括号3个，所以我们定义两个变量left和right分别表示剩余左右括号的个数，如果在某次递归时，左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，所以这种情况直接返回，不继续处理。如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，若right大于0，则调用递归函数，同样要更新参数。
 */
public class _22_Generate_Parentheses {
	public static void main(String args[]){
		_22_Generate_Parentheses o = new _22_Generate_Parentheses();
		System.out.println(o.generateParenthesis(3));
	}
	public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList();
        helper(n,n,"",list);
        return list;
    }
    public void helper(int left,int right,String str,List<String> list){
        if(left<0||right<0||left>right)return;
        if(left==0&&right==0){
            list.add(str);
            return;
        }
        helper(left-1,right,str+"(",list);
        helper(left,right-1,str+")",list);
    }
}
