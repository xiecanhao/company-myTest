package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AioServerTest {
	public static void main(String[] args) throws IOException {
		AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel
				.open().bind(new InetSocketAddress(10000));
		serverSocketChannel.accept(serverSocketChannel,
				new AcceptCompletionHandler());
	}

	private static class AcceptCompletionHandler implements
			CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel> {

		@Override
		public void completed(AsynchronousSocketChannel result,
				AsynchronousServerSocketChannel attachment) {
			ByteBuffer buff = ByteBuffer.allocate(1024);
			// 注册read请求以及回调ReadCompletionHandler
			result.read(buff, result,
					new ReadCompletionHandler(buff, "client"));
			// 递归监听
			attachment.accept(attachment, this);
		}

		@Override
		public void failed(Throwable exc,
				AsynchronousServerSocketChannel attachment) {
			// 递归监听
			attachment.accept(attachment, this);

		}

	}

}
