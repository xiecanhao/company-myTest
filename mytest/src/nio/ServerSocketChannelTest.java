package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelTest {
	public static void main(String[] args) throws IOException {
		// blocking();
		// noBlocking();
	}

	/**
	 * 非阻塞写法
	 */
	private static void noBlocking() throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 80));
		ssc.configureBlocking(false);// 设置为非阻塞
		while (true) {
			SocketChannel sc = ssc.accept();
			if (sc != null) {
				// do something...
			}
		}
	}

	/**
	 * 阻塞写法
	 */
	private static void blocking() throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 80));
		while (true) {
			SocketChannel sc = ssc.accept();
			// do something...
			sc.close();
		}
	}
}
