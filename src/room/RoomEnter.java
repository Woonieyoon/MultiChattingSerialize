package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class RoomEnter implements ConnectionProcessor {

	ServerClient serverClient;

	public RoomEnter(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String roomTitle) {
		synchronized (serverClient) {
			serverClient.getRoom().getRoomClients().remove(serverClient);

			for (Room room : serverClient.getRoomManager().getRooms()) {
				if (room.getRoomTitle().equals(roomTitle)) {
					room.enterRoom(serverClient);
					serverClient.setRoom(room);
				}
			}
			serverClient.send(roomTitle + " 에 입장하셨습니다.");
		}
	}

}
