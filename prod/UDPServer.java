package prod;

import java.net.*;
import java.io.FileInputStream;
import java.io.File;

import prod.HTTPMethod;

public class UDPServer {

	public void handlePackets(DatagramSocket socket, byte[] sendBuffer,
			byte[] receiveBuffer) throws Exception {

		DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,
				receiveBuffer.length);
		socket.receive(receivePacket);

		String receiveMessage = new String(receivePacket.getData());
		InetAddress clientIPAddress = receivePacket.getAddress();
		int clientPort = receivePacket.getPort();

		switch (getHTTPMethod(receiveMessage)) {
		case GET:
			/* Send initial header including file size */
			File requestedFile = getAssociatedFile(receiveMessage);

			// Potential for sending error header if file does not exist
			String header = generateResponseHeader(requestedFile.length());
			sendBuffer = header.getBytes();

			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
					sendBuffer.length, clientIPAddress, clientPort);

			socket.send(sendPacket);

			/* Send all bytes until end of file */
			FileInputStream fin = new FileInputStream(requestedFile);

			while (fin.read(sendBuffer) != -1) {
				sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
						clientIPAddress, clientPort);

				socket.send(sendPacket);
			}

			/* Send null character */
			byte[] nullEnd = new byte[1];
			nullEnd[0] = 0;

			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
					clientIPAddress, clientPort);

			socket.send(sendPacket);
			break;
		default:
			//potential sending error if method is invalid
			throw new java.lang.IllegalArgumentException();
		}
	}

	public HTTPMethod getHTTPMethod(String message) {
		String tokens[] = message.split("\\s+");

		if (tokens[0].compareTo("GET") == 0) {
			return HTTPMethod.GET;

		} else {
			return HTTPMethod.BAD;
		}
	}

	public File getAssociatedFile(String message)
			throws IllegalArgumentException {
		String tokens[] = message.split("\\s+");

		if (tokens[0].compareTo("GET") == 0) {
			String fileName = tokens[1];
			File retFile = new File(fileName);
			return retFile;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public String generateResponseHeader(long contentLength) {
		String result = new String();

		result += "HTTP 1.0 ";
		result += "200 ";
		result += "Document Follows\r\n";

		result += "Content-Type: ";
		result += ("text/plain\r\n");
		result += ("Content-Length: " + contentLength + "\r\n");
		result += ("\r\n");

		return result;
	}

}
