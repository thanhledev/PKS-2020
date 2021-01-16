package examples.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Writer {

	public static void main(String[] args) {
		Message message = new Message("Inhalt der Nachricht");
		String host = "localhost";
		int port = 1337;

		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress(host, port));
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			// Objekt in den Stream schreiben
			oos.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
