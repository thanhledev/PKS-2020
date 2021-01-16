package tasks.greeting.simple.client;

import java.io.IOException;

import examples.serialization.Message;
import tasks.greeting.client.GreetingClient;

public class SimpleClientMain {

	public static void main(String[] args) throws IOException {
		GreetingClient client = new SimpleGreetingClient();
		System.out.println(client.greet("test", "localhost", 1337));
	}

}
