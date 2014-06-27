import java.io.*;
import java.net.*;

class UDPClient {
	public static void main(String args[]) throws Exception {

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		// For testing purposes, we can set this name to our own PC's name.
		InetAddress IPAddress = InetAddress.getByName("tux194");

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 10034);

		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData,
				receiveData.length);

		// Operation waits until server sends back a response
		clientSocket.receive(receivePacket);

		String modifiedSentence = new String(receivePacket.getData());

		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
}