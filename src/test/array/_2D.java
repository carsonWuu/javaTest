package test.array;

import java.util.Arrays;

public class _2D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] c= new char[10][10];
		for (int i = 0;i<10;i++)Arrays.fill(c[i], (char) (i+48));
		for (int i = 0;i<10;i++){
			String ret= Arrays.toString(c[i]);
			System.out.println(ret);
		}
		
	}

}
