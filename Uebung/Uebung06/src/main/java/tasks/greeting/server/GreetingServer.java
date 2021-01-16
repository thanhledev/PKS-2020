package tasks.greeting.server;

import java.io.IOException;

/**
 * The Server Interface for a Greeting Server
 * 
 * @author Simon Harrer, Joerg Lenhard
 * @version 1.0
 */
public interface GreetingServer {

	/**
	 * Start the server at a given port.
	 * 
	 * @param port
	 *            the port to start the server at
	 * @throws IOException
	 *             if an error occurs, e.g., port is already bound
	 */
	void start(int port) throws IOException;

}
