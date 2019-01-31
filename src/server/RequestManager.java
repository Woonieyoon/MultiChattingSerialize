package server;

import java.util.HashMap;
import java.util.Map;

import room.RoomCreate;
import room.RoomEnter;
import room.RoomExit;
import room.RoomList;
import room.RoomRemove;
import room.UserList;
import splitprocessor.ConnectionProcessor;

public class RequestManager {

	private ServerClient serverClient;
	private Map<String, ConnectionProcessor> map = new HashMap<>();

	public RequestManager(ServerClient serverClient) {
		this.serverClient = serverClient;
		map.put("makeRoom", new RoomCreate(this.serverClient));
		map.put("enterRoom", new RoomEnter(this.serverClient));
		map.put("exitRoom", new RoomExit(this.serverClient));
		map.put("userList", new UserList(this.serverClient));
		map.put("roomList", new RoomList(this.serverClient));
		map.put("removeRoom", new RoomRemove(this.serverClient));
	}

	public Map<String, ConnectionProcessor> getMap() {
		return map;
	}
}