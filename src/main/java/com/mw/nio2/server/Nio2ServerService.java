package com.mw.nio2.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Nio2ServerService implements ServerService {

	private AsynchronousServerSocketChannel serverSock;

	private AsynchronousChannelGroup threadGroup;

	private static final int serverPort = 5555;

	private static final int bufferSize = 1024;

	private ByteBuffer readBuffer;

	public Nio2ServerService() throws IOException {
		threadGroup = AsynchronousChannelGroup.withThreadPool(Executors
				.newFixedThreadPool(10));
		readBuffer = ByteBuffer.allocateDirect(1024);
	}

	public void start() throws IOException {
		serverSock = AsynchronousServerSocketChannel.open(threadGroup);
		InetSocketAddress local = new InetSocketAddress("127.0.0.1", serverPort);
		serverSock.bind(local);
		AsynchronousSocketChannel socket = null;
		Charset charset = Charset.defaultCharset();
		CharsetDecoder decoder = charset.newDecoder();
		while (true) {
			try {
				socket = serverSock.accept().get();
			} catch (InterruptedException | ExecutionException e) {
			}
			
			if (socket != null) {
				Integer read;
				try {
					while (true) {
						read = socket.read(readBuffer).get();
						String msgReceived = Charset.defaultCharset().decode(readBuffer).toString();
						System.out.println("Received: " + msgReceived);
						if (msgReceived.toString().contains("$"))
						{
							break;
						}
					}
					
					ByteBuffer outgoingBuffer = ByteBuffer.wrap("Received".getBytes());
					socket.write(outgoingBuffer).get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				} finally {
					socket.close();
				}
			}
			
			try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Ignore
            }
		}
	}

	public void stop() {
		// TODO Auto-generated method stub
	}
}
