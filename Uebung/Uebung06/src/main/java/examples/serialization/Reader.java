package examples.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Reader {

	public static void main(String[] args) {
		int port = 1337;

		// Warte auf eingehende Verbindungen
		try (ServerSocket serverSocket = new ServerSocket(port);
				Socket socket = serverSocket.accept()) {

			// Erstelle Reader fuer Stream
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());

			// liest komplettes Objekt
			Object object = ois.readObject();
			// explizites Casting noetig
			Message message = (Message) object;
			System.out.println(message.getContent());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
