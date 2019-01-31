package splitprocessor;

import java.net.Socket;

public interface ConnectionProcessor {
	public void Process(Socket socket, String data);
}
