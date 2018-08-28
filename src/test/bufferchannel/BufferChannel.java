package test.bufferchannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class BufferChannel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferChannel  bc = new BufferChannel();
		bc.test1();
		bc.test2();
	}
	/*
	 * 非直接缓存区代码
	 */
	  public void test1() throws Exception {
		  long start = System.currentTimeMillis();
	        //1.提供相应的输入输出流
	        FileInputStream fis = new FileInputStream("E:\\mysql.pdf");
	        FileOutputStream fos = new FileOutputStream("E:\\mysql1.pdf");

	        //创建相应的Channel  通过我们的流去创建对应的通道，然后通过通道继续读写数据
	        FileChannel inchannel = fis.getChannel();
	        FileChannel outchannel = fos.getChannel();

	        //3.提供缓冲区
	        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
	        while ((inchannel.read(byteBuffer)) != -1) {

	            byteBuffer.flip();//切换为读数据的模式
	            //如果这里不切换的话，缓存区会满

	            outchannel.write(byteBuffer);

	            byteBuffer.clear();//清空，读完当前的缓存区然后再继续
	        }
	        fis.close();
	        fos.close();
	        inchannel.close();
	        outchannel.close();
	        long end = System.currentTimeMillis();
	        System.out.println("非直接缓冲区：" + (end - start));//1573-1575

	    }
	  /*
	   * 直接缓存区代码
	   */
	//使用FileChannel + MappedByteBuffer（直接缓冲区）-->物理内存映射文件
	    @Test
	    public void test2() throws Exception {


	        long start = System.currentTimeMillis();


	        //1.创建Channel
//	      FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
//	      FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
	        FileChannel inChannel = FileChannel.open(Paths.get("E:\\mysql.pdf"), StandardOpenOption.READ);
	        FileChannel outChannel = FileChannel.open(Paths.get("E:\\mysql2.pdf"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

	        //2.创建得到直接缓冲区
	        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
	        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

	        //3.数据的读写
	        byte[] dst = new byte[inMappedBuffer.limit()];
	        inMappedBuffer.get(dst);//将数据写入到dst中
	        outMappedBuffer.put(dst);//从dst中将数据取出

	        //4.关闭资源
	        inChannel.close();
	        outChannel.close();


	        long end = System.currentTimeMillis();
	        System.out.println("直接缓冲区：" + (end - start));//1573-1575
	        }
}
