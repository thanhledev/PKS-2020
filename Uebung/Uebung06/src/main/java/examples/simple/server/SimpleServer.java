package examples.simple.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws IOException {
		int port = 1337;
		ServerSocket serverSocket = new ServerSocket(port);

		// Warte auf eingehende Verbindungen
		Socket client = serverSocket.accept();

		// Erstelle Reader fuer Stream
		BufferedReader in = new BufferedReader(new InputStreamReader(
				client.getInputStream()));

		// Datenaustausch
		String message = in.readLine();
		System.out.println("Received: " + message);

		client.close();

		serverSocket.close();

	}

}
