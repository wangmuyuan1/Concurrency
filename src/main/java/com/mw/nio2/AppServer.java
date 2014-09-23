package com.mw.nio2;

import java.io.IOException;

import com.mw.nio2.server.Nio2ServerService;

public class AppServer {
	
	public static void main(String[] args) throws IOException
	{
		Nio2ServerService server = new Nio2ServerService();
		server.start();
	}
}
