package examples.simple.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SimpleClient {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket();

		// erzeuge Adresse des Servers
		String hostname = "localhost";
		int port = 1337;
		SocketAddress serverAddress = new InetSocketAddress(hostname, port);
		client.connect(serverAddress);

		// Erstelle Writer fuer Stream
		PrintWriter out = new PrintWriter(client.getOutputStream());

		// Datenaustausch
		out.println("Foo");
		out.flush();

		client.close();
	}

}
