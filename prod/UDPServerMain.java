package prod;

import java.net.*;
import prod.UDPServer;

public class UDPServerMain {
	
	final static int bufferSize = 128;

	// this should be consistently running on server side.
	public static void main(String[] args) throws Exception {

		UDPServer server = new UDPServer();
		DatagramSocket serverSocket = new DatagramSocket(10034);
		byte[] sendBuffer = new byte[bufferSize];
		byte[] receiveBuffer = new byte[bufferSize];
		
		while (true) {
			server.handlePackets(serverSocket, sendBuffer, receiveBuffer);
		}
	}
}