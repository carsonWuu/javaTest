package leetcode;
import java.util.*;
/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class _51_N_Queens {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_51_N_Queens o = new _51_N_Queens();
		int n = 8;
		List<List<String>> ret = o.solveNQueens(n);
		System.out.println(ret.size());
	}
	 private Set<Integer> col = new HashSet<Integer>();
	 private Set<Integer> diag1 = new HashSet<Integer>();
	 private Set<Integer> diag2 = new HashSet<Integer>();
	    
	 public List<List<String>> solveNQueens(int n) {
		 List<List<String>> res = new ArrayList<List<String>>();
	     dfs(res,new ArrayList<String>(), 0, n);
	     return res;
	 }
	 private void dfs(List<List<String>> res, List<String> list, int row, int n){
	     if (row == n){
	         res.add(new ArrayList<String>(list));
	         return;
	     }
	     for (int i = 0; i < n; i++){
	         if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
	            
	         char[] charArray = new char[n];
	         Arrays.fill(charArray, '.');
	         charArray[i] = 'Q';
	         String rowString = new String(charArray);
	            
	         list.add(rowString);
	         col.add(i);
	         diag1.add(row + i);
	         diag2.add(row - i);
	            
	         dfs(res, list, row + 1, n);
	            
	         list.remove(list.size() - 1);
	         col.remove(i);
	         diag1.remove(row + i);
	         diag2.remove(row - i);
	     }
	 }
}
