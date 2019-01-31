package room;

import java.util.ArrayList;
import java.util.List;

import server.ServerClient;

public class Room {

	private final String roomTitle;
	private final List<ServerClient> roomClients;
	
	public Room(String roomTitle) {
		this.roomTitle = roomTitle;
		this.roomClients = new ArrayList<>();
	}

	public List<ServerClient> getRoomClients() {
		return roomClients;
	}

	
	public String getRoomTitle() {
		return roomTitle;
	}

	public void enterRoom(ServerClient serverClient) {
		roomClients.add(serverClient);
	}
	
	public void exitRoom(ServerClient serverClient) {
		if (roomClients.size() > 0) {
			roomClients.remove(serverClient);
		}
	}

	public String getList() {
		StringBuilder userList = new StringBuilder();
		userList.append("-------" + roomTitle + " 방 리스트" + "-------").append("\n");
		for(ServerClient client: roomClients) {
			userList.append(client.getUserName()).append("\n");
		}
		return userList.toString();
	}
	
}
