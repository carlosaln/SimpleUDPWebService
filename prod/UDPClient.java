package prod;

import java.io.*;
import java.net.*;


class UDPClient {
	final static int bufferSize = 128;
	
	public static void main(String args[]) throws Exception {

		DatagramSocket clientSocket = new DatagramSocket();

		// For testing purposes, we can set this name to our own PC's name.
		InetAddress IPAddress = InetAddress.getByName("Carlos-PC");

		byte[] sendData = new byte[bufferSize];
		byte[] receiveData = new byte[bufferSize];

		//String sentence = inFromUser.readLine();
		String httpGetRequest = "GET res/constitution.htm HTTP/1.0";

		sendData = httpGetRequest.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData,
				sendData.length, IPAddress, 10034);

		System.out.println("About to send: " + sendPacket.toString());

		clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData,
				receiveData.length);

		// Operation waits until server sends back a response
		clientSocket.receive(receivePacket);
		
		byte[] response = receivePacket.getData();
		
		FileOutputStream out = new FileOutputStream("constitution.htm");
		String responseString;
		while (receivePacket.getLength() > 1 && response[0] != 0)
		{
			responseString = new String(response);
			System.out.println(responseString);
			out.write(response);
			clientSocket.receive(receivePacket);
			response = receivePacket.getData();

		}
		out.close();
		clientSocket.close();
	}
}