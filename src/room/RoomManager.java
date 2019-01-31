package room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
	
	private final List<Room> rooms;

	public void makeRoom(String roomTitle) {
		Room room = new Room(roomTitle);
		addRoom(room);
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}
	
	public void exitRoom(Room room) {
		rooms.remove(room);
	}

	public RoomManager() {
		this.rooms = new ArrayList<Room>();
	}

	public String getList() {
		StringBuilder roomList = new StringBuilder();
		roomList.append("-------" + " 방 리스트" + "-------").append("\n");
		for (Room room : rooms) {
			roomList.append(room.getRoomTitle()).append("\n");
		}
		return roomList.toString();
	}

}
