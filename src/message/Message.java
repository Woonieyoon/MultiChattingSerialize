package message;

import java.io.Serializable;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 3502171695509043456L;
	private String userName;
	private String message;
	
	public Message(String userName, String message) {
		this.userName = userName;
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
