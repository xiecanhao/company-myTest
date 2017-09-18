package aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompletionHandler
		implements CompletionHandler<Integer, AsynchronousSocketChannel> {
	private ByteBuffer byteBuffer;
	private String remotename;

	public ReadCompletionHandler(ByteBuffer byteBuffer, String remotename) {
		this.byteBuffer = byteBuffer;
		this.remotename = remotename;
	}

	@Override
	public void completed(Integer result,
			AsynchronousSocketChannel attachment) {
		if (result <= 0)
			return;
		byteBuffer.flip();
		System.out.println(
				"[" + this.remotename + "]" + new String(byteBuffer.array()));
		byteBuffer.clear();
		// 递归监听数据
		attachment.read(byteBuffer, attachment, this);
	}

	@Override
	public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
		byteBuffer.clear();
		// 递归监听数据
		attachment.read(byteBuffer, attachment, this);
	}

}
