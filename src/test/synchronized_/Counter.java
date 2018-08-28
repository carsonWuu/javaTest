package test.synchronized_;
public class Counter{
     long count = 0;

     public synchronized void add(long value){
       this.count += value;
     }
     public void cout() {
    	 System.out.println(this.count);
     }
  }
  