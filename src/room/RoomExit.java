package room;

import java.net.Socket;

import server.ServerClient;
import splitprocessor.ConnectionProcessor;

public class RoomExit implements ConnectionProcessor {

	private ServerClient serverClient;

	public RoomExit(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String data) {
		synchronized (serverClient) {
			String beforeRoomTitle = serverClient.getRoom().getRoomTitle();
			serverClient.setRoom(serverClient.getRoomManager().getRooms().get(0));
			serverClient.getRoom().getRoomClients().remove(serverClient);
			serverClient.getRoomManager().getRooms().get(0).enterRoom(serverClient);
			System.out.println(beforeRoomTitle + "방을 나가셨습니다.");
		}
	}
}
