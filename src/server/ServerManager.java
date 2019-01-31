package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import room.Room;
import room.RoomManager;

public class ServerManager {

	private ServerSocket serverSocket;
	private List<ServerClient> clients;
	private ExecutorService executorService;
	private RoomManager roomManager;
	
	public ServerManager(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public void init() {
		clients = new ArrayList<>();
		Room room = new Room("All");
		roomManager = new RoomManager();
		roomManager.addRoom(room);
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	public void execute() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("--------Wating to connection--------");
						Socket socket = serverSocket.accept();
						ServerClient client = new ServerClient(socket, executorService, clients, roomManager);
						client.init();
						clients.add(client);
						System.out.println(socket.getRemoteSocketAddress() + "에서 접속!!");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		executorService.submit(runnable);
	}
}
