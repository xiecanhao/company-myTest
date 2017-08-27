package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * http://ifeve.com/selectors/
 */
public class SelectorTest {
	public static void main(String[] args) throws IOException {
		SocketChannel sc = SocketChannel.open();
		Selector selector = Selector.open();
		sc.configureBlocking(false);
		sc.register(selector, SelectionKey.OP_READ);
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0)
				continue;
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> it = keys.iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isAcceptable()) {
					System.out.println("acceptable");
				} else if (key.isConnectable()) {
					System.out.println("connectable");
				} else if (key.isReadable()) {
					System.out.println("readable");
				} else if (key.isWritable()) {
					System.out.println("writable");
				}
				it.remove();// 移除，以便通道再次监听。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
			}
		}
	}
}
