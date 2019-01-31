package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import formatting.MaketimeFormatting;

public class ServerClientSender {

	private Socket socket;
	private List<ServerClient> clients;
	private ServerClient client;

	public ServerClientSender(ServerClient client) {
		this.socket = client.getSocket();
		this.clients = client.getClients();
		this.client = client;
	}

	public void send(String data) {
		try {
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(data);
			output.flush();
			System.out.println(client.getUserName()+" 클라이언트에게 데이터 전달" + new MaketimeFormatting());
		} catch (IOException e) {
			e.printStackTrace();
			clients.remove(client);
		}
	}

}
