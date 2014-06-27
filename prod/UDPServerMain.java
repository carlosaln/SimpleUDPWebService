package prod;

import prod.UDPServer;

public class UDPServerMain {
	
	// this should be consistenly running on server side.
	public static void main(String[] args) throws Exception {
//		DatagramSocket serverSocket = new DatagramSocket(10034);
//
//		byte[] receiveData = new byte[1024];
//		byte[] sendData = new byte[1024];
//
//		while (true) {
//
//			DatagramPacket receivePacket = new DatagramPacket(receiveData,
//					receiveData.length);
//
//			System.out.println("About to receive data Packet.");
//
//			serverSocket.receive(receivePacket);
//
//			String sentence = new String(receivePacket.getData());
//
//			InetAddress IPAddress = receivePacket.getAddress();
//
//			int port = receivePacket.getPort();
//			
//			//start changing here
//			String capitalizedSentence = sentence.toUpperCase();
//
//			sendData = capitalizedSentence.getBytes();
//
//			DatagramPacket sendPacket = new DatagramPacket(sendData,
//					sendData.length, IPAddress, port);
//
//			serverSocket.send(sendPacket);
			
//		}
		
		UDPServer server = new UDPServer();
		
		String rHeader = server.generateResponseHeader(200);
		
		System.out.print(rHeader);
	}
}
