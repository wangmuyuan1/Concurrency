package com.mw.nio2.server;

import java.io.IOException;

public interface ServerService {
	
	void start() throws IOException;
	
	void stop();
}
