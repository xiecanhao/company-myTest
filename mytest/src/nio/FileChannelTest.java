package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 参考链接地址:http://ifeve.com/java-nio-scattergather/
 */
public class FileChannelTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("test.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		// method1(inChannel);
		method2(inChannel);
		inChannel.close();
		aFile.close();
	}

	/**
	 * 使用多个buffer，FileChannel
	 */
	private static void method2(FileChannel inChannel) throws IOException {
		ByteBuffer buf1 = ByteBuffer.allocate(10);
		ByteBuffer buf2 = ByteBuffer.allocate(10);
		ByteBuffer bufArr[] = { buf1, buf2 };
		inChannel.read(bufArr);
		buf1.flip();
		buf2.flip();
		int limit = buf1.limit();
		while (buf1.position() < limit) {
			System.out.print((char) buf1.get());
		}
		limit = buf2.limit();
		while (buf2.position() < limit) {
			System.out.print((char) buf2.get());
		}
	}

	/**
	 * 使用单个buffer，FileChannel
	 */
	private static void method1(FileChannel inChannel) throws IOException {
		ByteBuffer buf = ByteBuffer.allocate(48);
		int byteRead = inChannel.read(buf);
		while (byteRead != -1) {
			System.out.println("Read:" + byteRead);
			buf.flip();// 光标移到数据的第一个位置
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());// 使用个体Char()，字节不足2个会导致异常
			}
			buf.clear();// 清空buf里的数据，以便不影响再次读入数据
			byteRead = inChannel.read(buf);
		}
	}
}
