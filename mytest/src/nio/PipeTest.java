package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeTest {
	public static void main(String[] args) throws IOException {
		Pipe pipe = Pipe.open();
		// 写入数据
		Pipe.SinkChannel sinkChannel = pipe.sink();
		String data = "pipe data for test";
		ByteBuffer buf = ByteBuffer.allocate(50);
		buf.clear();
		buf.put(data.getBytes());
		buf.flip();
		while (buf.hasRemaining()) {
			sinkChannel.write(buf);
		}

		// 读取数据
		Pipe.SourceChannel sourceChannel = pipe.source();
		ByteBuffer buf2 = ByteBuffer.allocate(50);
		int index = sourceChannel.read(buf2);
	}
}
