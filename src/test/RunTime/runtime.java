package test.RunTime;

import java.io.IOException;

public class runtime {
	public static void main(String [] args){
		 Runtime r = Runtime.getRuntime();// Ҫ�����õ�����ʵ��

	        /*
	         * Process������Process p = r.exec("notepad.exe c:/Add.java");//
	         * Process����һ��������������Ľ���p.destroy();
	         */
		 
		
	        try {
				r.exec("calc");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// �򿪼�������û��p.destroy();
	        try {
				r.exec("mspaint");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// �򿪻��壬û��p.destroy();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// ������ִͣ��5��
	}
}
