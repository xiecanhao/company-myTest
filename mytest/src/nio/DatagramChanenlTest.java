package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramChanenlTest {
	public static void main(String[] args) throws IOException {
		// receiveData();
		// sendData();
	}

	private static void sendData() throws IOException {
		DatagramChannel channel = DatagramChannel.open();
		// channel.socket().bind(new InetSocketAddress(9999));
		String data = "datagramchannel data";
		ByteBuffer buf = ByteBuffer.allocate(100);
		buf.clear();
		buf.put(data.getBytes());
		buf.flip();
		int index = channel.send(buf, new InetSocketAddress("localhost", 9999));
	}

	private static void receiveData() throws IOException, SocketException {
		DatagramChannel channel = DatagramChannel.open();
		channel.socket().bind(new InetSocketAddress(9999));
		ByteBuffer buf = ByteBuffer.allocate(50);
		buf.clear();
		channel.receive(buf);// 从DatagramChannel中接收数据
	}
}
