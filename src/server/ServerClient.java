package server;

import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;

import room.Room;
import room.RoomManager;

public class ServerClient {

	private final Socket socket;
	private final ExecutorService executorService;
	private final List<ServerClient> clients;
	private final RoomManager roomManager;
	private Room room;
	private ServerClientReceiver receiver;
	private ServerClientSender sender;
	private String UserName; 
		
	public ServerClient(Socket socket, ExecutorService executorService, List<ServerClient> clients,
			RoomManager roomManager) {
		this.socket = socket;
		this.executorService = executorService;
		this.clients = clients;
		this.roomManager = roomManager;

	}
	
	public void init() {
		receiver = new ServerClientReceiver(this);
		sender = new ServerClientSender(this);
		room = roomManager.getRooms().get(0);
		room.enterRoom(this);
		executorService.submit(receiver);
	}

	public void send(String data) {
		sender.send(data);
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public List<ServerClient> getClients() {
		return clients;
	}	

	public ServerClientReceiver getReceiver() {
		return receiver;
	}

	public void setReceiver(ServerClientReceiver receiver) {
		this.receiver = receiver;
	}

	public ServerClientSender getSender() {
		return sender;
	}

	public void setSender(ServerClientSender sender) {
		this.sender = sender;
	}

	public Socket getSocket() {
		return socket;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

}
