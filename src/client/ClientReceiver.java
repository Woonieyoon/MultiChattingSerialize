package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiver {

	private Socket socket;

	public ClientReceiver(Socket socket) {
		this.socket = socket;
	}

	public void receive() {
		Thread thread = new Thread() {
			public void run() {
				try (DataInputStream in = new DataInputStream(socket.getInputStream());) {
					while (true) {
						String message = in.readUTF();
						System.out.println(">>>" + message);
					}
				} catch (IOException e) {
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					e.printStackTrace();
				}
			}
		};
		thread.start();	
	}
}
