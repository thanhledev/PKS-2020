package examples.multithreaded.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandlerThread extends Thread {

	private final Socket client;

	public ClientHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		// closing the stream also closes the Socket
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				client.getInputStream()))) {

			String message = in.readLine();
			System.out.println("Received: " + message);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
