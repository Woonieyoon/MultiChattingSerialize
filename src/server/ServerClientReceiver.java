package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

import formatting.MaketimeFormatting;
import message.Message;

public class ServerClientReceiver implements Runnable {

	private Socket socket;
	private List<ServerClient> clients;
	private ServerClient serverClient;

	public ServerClientReceiver(ServerClient client) {
		this.serverClient = client;
		this.socket = client.getSocket();
		this.clients = client.getClients();
	}

	@Override
	public void run() {
		try (ObjectInputStream input = new ObjectInputStream(socket.getInputStream());) {
			while (true) {
				Message message = (Message) input.readObject();
				serverClient.setUserName(message.getUserName());
				System.out.println(message.getUserName() + " 클라이언트에서 데이터 들어옴" + new MaketimeFormatting().toString());

				if (message.getMessage().contains("command")) {
					String msg = message.getMessage().split("/")[1];
					RequestManager requestManager = new RequestManager(serverClient);
					if (requestManager.getMap().containsKey(msg)) {
						requestManager.getMap().get(msg).Process(socket, message.getMessage().split("/")[2]);
					}
				} else {
					new Broadcast(serverClient, message.getMessage()).send();
				}
			}

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
