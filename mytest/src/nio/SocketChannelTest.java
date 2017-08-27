package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelTest {
	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		// readMethod(sc);
		// writeMethod(sc);
		sc.close();
	}

	/**
	 * 将数据写入chanenl
	 */
	private static void writeMethod(SocketChannel sc) throws IOException {
		String data = "my test nio socketchannel";
		ByteBuffer buf = ByteBuffer.allocate(50);
		buf.clear();
		buf.put(data.getBytes());
		buf.flip();
		while (buf.hasRemaining()) {
			sc.write(buf);
		}
	}

	/**
	 * 连接服务器读取数据
	 * 
	 * @throws InterruptedException
	 */
	private static void readMethod(SocketChannel sc)
			throws IOException, InterruptedException {
		sc.configureBlocking(false);// 设置为非阻塞
		sc.connect(new InetSocketAddress("localhost", 80));// 连接到服务器
		while (!sc.finishConnect()) {// 非阻塞可能还未建立连接
			Thread.sleep(100);
		}

		ByteBuffer buf = ByteBuffer.allocate(50);
		int postion = sc.read(buf);
		if (postion <= 0)
			return;
		buf.flip();
		while (buf.hasRemaining()) {
			System.out.println((char) buf.get());
		}
	}
}
