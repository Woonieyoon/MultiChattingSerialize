package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class RoomCreate implements ConnectionProcessor {

	private ServerClient serverClient;

	public RoomCreate(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String roomTitle) {
		synchronized (serverClient) {
			Room room = new Room(roomTitle);
			serverClient.getRoomManager().addRoom(room);
			System.out.println(roomTitle + "방 생성!!");
		}
	}

}
