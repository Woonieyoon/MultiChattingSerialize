package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class UserList implements ConnectionProcessor {

	private ServerClient serverClient;

	public UserList(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String data) {
		serverClient.send(serverClient.getRoom().getList());
	}
}
