package tasks.greeting.simple.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class to accept single request.
 *
 * @author Shivakumar Ramannavar
 */
public class ShopKeeper {

    private ServerSocket shopSocket;

    /**
     * Start a server running at the given port.
     *
     * @param port Port at which server starts.
     */
    public void start(int port) {

        ObjectOutputStream oos = null;

        ObjectInputStream ois = null;

        try {
            shopSocket = new ServerSocket(port);
            System.out.println("Server single-request version listening at port: " + port);
            Socket clientSocket = shopSocket.accept();

            // Open an input stream to the socket.
            oos = new ObjectOutputStream(clientSocket.getOutputStream());

            // Open an input stream to the socket.
            ois = new ObjectInputStream(clientSocket.getInputStream());

            String request = (String) ois.readObject();

            System.out.println("Client says, " + request);

            if ("Give me 2 apples".equals(request)) {
                oos.writeObject("Take 2 apples");
            } else {
                oos.writeObject("Sorry I dont know what you are saying");
            }
            clientSocket.close();
        } catch (Exception ex) {
            System.err.println("Error starting the server." + ex.toString());
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();

                if (ois != null)
                    ois.close();

                System.out.println("Shutting down...");
                shopSocket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ShopKeeper shopKeeper = new ShopKeeper();
        shopKeeper.start(8888);

    }
}