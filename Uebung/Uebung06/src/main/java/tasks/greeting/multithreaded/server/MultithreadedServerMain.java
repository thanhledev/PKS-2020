package tasks.greeting.multithreaded.server;

import java.io.IOException;

import tasks.greeting.server.GreetingServer;

public class MultithreadedServerMain {

	public static void main(String[] args) throws IOException {
		GreetingServer server = new MultithreadedGreetingServer();
		server.start(1337);
	}

}
