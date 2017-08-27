package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 原文链接: http://ifeve.com/java-nio-channel-to-channel/
 */
public class FromAndToChannel {
	public static void main(String[] args) throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile("src\\nio\\from.txt",
				"rw");
		FileChannel fromChannel = fromFile.getChannel();

		RandomAccessFile toFile = new RandomAccessFile("src\\nio\\to.txt",
				"rw");
		FileChannel toChannel = fromFile.getChannel();
		long position = 0;
		long count = fromChannel.size();
		fromChannel.transferFrom(toChannel, position, count);
		// fromChannel.transferTo(position, count, toChannel);

		ByteBuffer buf = ByteBuffer.allocate(50);
		int index = 0;
		while ((index = fromChannel.read(buf)) != -1) {
			System.out.println("Read:" + index);
			buf.flip();// 光标移到数据的第一个位置
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());// 使用个体Char()，字节不足2个会导致异常
			}
			buf.clear();// 清空buf里的数据，以便不影响再次读入数据
			index = fromChannel.read(buf);
		}
		fromChannel.close();
		toChannel.close();
		fromFile.close();
		toFile.close();
	}
}
