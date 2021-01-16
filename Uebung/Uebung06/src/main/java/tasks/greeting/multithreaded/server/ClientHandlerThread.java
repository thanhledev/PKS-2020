package tasks.greeting.multithreaded.server;

import tasks.greeting.messages.MeetingMessage;
import tasks.greeting.messages.NameMessage;

import java.io.*;
import java.net.Socket;

public class ClientHandlerThread extends Thread {
	private final Socket client;
	public ClientHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try(ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream())) {
			out.flush();
			try (ObjectInputStream in = new ObjectInputStream(client.getInputStream())){
				//receive massage from client
				Object object = in.readObject();
				if(object instanceof NameMessage) {
					NameMessage nameMessage = (NameMessage) object;

					//send greeting to client
					MeetingMessage greeting = new MeetingMessage("Hello "+nameMessage.getFirstName() + " " + nameMessage.getSurname());

					//Warum wird out nicht geschlossen? weil es auto mit dem socket geschlossen wird.
					out.writeObject(greeting);
					out.flush();
				}
			}


		}catch (IOException e){
			System.err.println("Connection error: "+e.getMessage());
		}
		catch (ClassNotFoundException ex){
			System.err.println("Cannot read incoming message " + ex.getMessage());
		}
	}

}
