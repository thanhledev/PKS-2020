package tasks.greeting.simple.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import examples.serialization.Message;
import tasks.greeting.client.GreetingClient;
import tasks.greeting.messages.MeetingMessage;
import tasks.greeting.messages.NameMessage;

public class SimpleGreetingClient implements GreetingClient {

	@Override
	public String greet(String message, String hostname, int port)
			throws IOException {
		Socket server = new Socket();
		SocketAddress socketAddress = new InetSocketAddress(hostname,port);
		server.connect(socketAddress);

		//with this try block: automatic close server
		try (ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream())){
			out.flush();
			try (ObjectInputStream in = new ObjectInputStream(server.getInputStream())){
				NameMessage nameMessage= new NameMessage("John", "Herrmann");
				out.writeObject(nameMessage);
				out.flush();

				//receive greeting from server
				Object object = in.readObject();
				try {
					MeetingMessage greeting = (MeetingMessage) object;
					return greeting.getGreeting();
				} catch (ClassCastException e) {
					return "Could not read the respond message";
				}
			}catch (ClassNotFoundException e){
				System.err.println("Could not read the respond message");
				return "Could not read the respond message";
			}
		}
	}

}
