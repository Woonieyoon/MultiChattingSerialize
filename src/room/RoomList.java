package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class RoomList implements ConnectionProcessor {

	private ServerClient serverClient;

	public RoomList(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String data) {
		serverClient.send(serverClient.getRoomManager().getList());
	}
}
