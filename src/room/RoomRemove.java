package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class RoomRemove implements ConnectionProcessor {

	ServerClient serverClient;

	public RoomRemove(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String roomTitle) {
		synchronized (serverClient) {
			for (Room room : serverClient.getRoomManager().getRooms()) {
				if (room.getRoomTitle().equals(roomTitle)) {
					serverClient.getRoomManager().getRooms().remove(room);
					System.out.println(roomTitle + "방 삭제");
				}
			}
		}
	}

}
