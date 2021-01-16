package tasks.greeting.simple.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Person class to request for apples.
 *
 * @author Shivakumar Ramannavar
 *
 */
public class Person {

    public void sendRequest(String hostName, int portNumber, String request) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // Open a socket.
            Socket requestSocket = new Socket(hostName, portNumber);

            // Open an input stream and output stream to the socket.
            oos = new ObjectOutputStream(requestSocket.getOutputStream());

            // write to socket using ObjectOutputStream
            oos.writeObject(request);

            // read the server response message
            ois = new ObjectInputStream(requestSocket.getInputStream());

            // Read from and write to the stream according to the server's protocol.
            String message = (String) ois.readObject();

            System.out.println("Client : " + request + "\nServer: " + message);

            // Close the streams.
            // Close the socket.
            requestSocket.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();

                if (ois != null)
                    ois.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        person.sendRequest("localhost", 8888, "Give me 2 apples");
        //simulateMulipleClients(person);
    }
}
