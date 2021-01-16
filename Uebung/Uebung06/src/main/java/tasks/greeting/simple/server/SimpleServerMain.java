package tasks.greeting.simple.server;

import java.io.IOException;

import tasks.greeting.server.GreetingServer;

public class SimpleServerMain {

	public static void main(String[] args) throws IOException {
		GreetingServer server = new SimpleGreetingServer();
		server.start(1337);
	}

}
