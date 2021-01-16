package tasks.greeting.client;


import java.io.IOException;

/**
 * The Client Interface for Greeting
 * 
 * @author Simon Harrer, Joerg Lenhard
 * @version 1.0
 */
public interface GreetingClient {

	/**
	 * Request a greeting from the greeting service.
	 * 
	 * @param message
	 *            the name of the person to be greeted
	 * @param hostname
	 *            the hostname of the server
	 * @param port
	 *            the port of the server
	 * @return the computed greeting
	 * @throws IOException
	 *             if an error occurs
	 */
	String greet(String message, String hostname, int port) throws IOException;

}
