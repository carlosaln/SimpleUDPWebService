package prod;

import java.net.*;
import prod.HTTPMethod;

public class UDPServer {
	
	public void handleHTTPMethod(HTTPMethod method, String data) {
		switch (method) {
		case GET:
			System.out.println("Get");
			break;
		default:
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	public HTTPMethod parseHTTPMessage(String message) {
		String tokens[] =  message.split(" ");
		
		if (tokens[0].compareTo("GET") == 0) {
			return HTTPMethod.GET;
		}
		else {
			return HTTPMethod.BAD;
		}
	}
	
	public String generateResponseHeader(int contentLength) {
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
