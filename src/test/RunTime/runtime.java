package test.RunTime;

import java.io.IOException;

public class runtime {
	public static void main(String [] args){
		 Runtime r = Runtime.getRuntime();// 要这样得到本类实例

	        /*
	         * Process的栗子Process p = r.exec("notepad.exe c:/Add.java");//
	         * Process代表一个被虚拟机启动的进程p.destroy();
	         */
		 
		
	        try {
				r.exec("calc");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 打开计算器，没有p.destroy();
	        try {
				r.exec("mspaint");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 打开画板，没有p.destroy();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 程序暂停执行5秒
	}
}
