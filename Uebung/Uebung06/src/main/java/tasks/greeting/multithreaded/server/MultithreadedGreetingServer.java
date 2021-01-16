package tasks.greeting.multithreaded.server;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import tasks.greeting.server.GreetingServer;

public class MultithreadedGreetingServer implements GreetingServer {

	@Override
	public void start(int port) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(port)){
			//terminate if incoming connections>5
			ExecutorService executorService = Executors.newCachedThreadPool();
			serverSocket.setSoTimeout(100*1000);
			while (true){
				try {
					Socket client = serverSocket.accept();
					executorService.submit(new ClientHandlerThread(client));
				}catch (SocketTimeoutException e){
					break;
				}
				finally {
					shutdownExecutorService(executorService);
				}
			}
		}
	}

	private void shutdownExecutorService(ExecutorService executorService) {
		executorService.shutdown();
		try {
			// Wait a while for existing tasks to terminate
			if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				executorService.shutdownNow(); // Cancel currently executing tasks
				// Wait a while for tasks to respond to being cancelled
				if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (InterruptedException ie) {
			// (Re-)Cancel if current thread also interrupted
			executorService.shutdownNow();
			// Preserve interrupt status
			Thread.currentThread().interrupt();
		}
	}

}
