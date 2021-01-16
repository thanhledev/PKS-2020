package examples.multithreaded.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {

	public static void main(String[] args) throws IOException {
		int port = 1337;
		ServerSocket serverSocket = new ServerSocket(port);

		while (true) {
			// Warte auf eingehende Verbindungen
			Socket client = serverSocket.accept();
			new ClientHandlerThread(client).start();
		}
	}

}
