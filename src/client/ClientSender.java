package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import message.Message;

public class ClientSender {

	private Socket socket;
	private String userName;

	public ClientSender(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}

	public void send() {
		Thread thread = new Thread() {
			public void run() {
				try(Scanner sc = new Scanner(System.in);
						ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {
					while (true) {
						String message = sc.nextLine();
						if(message.equalsIgnoreCase("quit")) {
							socket.close();
						}
						out.writeObject(new Message(userName, message));
						out.flush();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};
		thread.start();
	}
}
