package client;

import java.io.IOException;
import java.net.Socket;

/**
 * @author : sungwon
 * @Date : 2019. 1. 31.
 *
 *       command가 명령기준!! // makeRoom : 방생성 // enterRoom: 방 입장 //exitRoom : 방 나가기
 *       //userList : 방의 유저 리스트 // roomList : 방의 리스트 // removeRoom : 방 삭제
 * 
 *       예) command/makeRoom/방 이름 ; command/enterRoom/방 이름 ; command/exitRoom/방
 *       이름 ; command/userList/~~(일딴 뭐라도 적어야함) ; command/roomList/~~(일딴 뭐라도
 *       적어야함); command/removeRoom/방 이름
 * 
 * 
 */

public class Client {

	private final int port;
	private Socket socket;
	private String ip;
	private String userName;

	public Client(String ip, int port, String userName) {
		this.ip = ip;
		this.port = port;
		this.userName = userName;
	}

	public void init() {
		try {
			socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		new ClientSender(socket, userName).send();
		new ClientReceiver(socket).receive();
	}

	public void close() throws IOException {
		socket.close();
	}

	public static void main(String[] args) {
		Client client = new Client("localhost", 10020, "1");
//		Client client = new Client("localhost", 10020, "2");
//		Client client = new Client("localhost", 10020, "3");
		client.init();
		client.execute();
	}
}
