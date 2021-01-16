package tasks.greeting.simple.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


import tasks.greeting.server.GreetingServer;

public class SimpleGreetingServer implements GreetingServer {


	@Override
	public void start(int port) throws IOException {
		ServerSocket serverSocket=new ServerSocket(port);

		try(Socket client = serverSocket.accept()){
			BufferedReader in = new BufferedReader((new InputStreamReader(client.getInputStream())));
			PrintWriter out = new PrintWriter(client.getOutputStream());
			String message = in.readLine();
			String greeting = "Hello " + message;

			//send greeting to client
			out.println(greeting);
			out.flush();
		}
	}
}
