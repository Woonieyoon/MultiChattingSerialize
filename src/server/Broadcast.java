package server;

public class Broadcast {

	private ServerClient serverClient;
	private final String data;

	public Broadcast(ServerClient serverClient, String data) {
		this.serverClient = serverClient;
		this.data = data;
	}

	public void send() {
		for (ServerClient client : serverClient.getRoom().getRoomClients()) {
			if (client == serverClient) {
				continue;
			}
			client.send(data);
		}
	}

}
