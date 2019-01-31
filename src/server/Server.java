package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	private final int port;
	private ServerSocket serverSocket;

	public Server(int port) {
		if (port < 1024)
			throw new IllegalArgumentException();
		this.port = port;
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		ServerManager serverManager = new ServerManager(serverSocket);
		serverManager.init();
		serverManager.execute();
	}

	public void close() throws IOException {
		serverSocket.close();
	}

	public static void main(String[] args) {
		Server server = new Server(10020);
		server.init();
		server.execute();
	}

}
