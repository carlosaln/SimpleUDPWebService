package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

import prod.UDPServer;
import prod.HTTPMethod;

public class UDPServerTest extends TestCase {
	
	protected UDPServer testServer;
	
	public void setUp() {
		testServer = new UDPServer();
	}
	
	@Test
	public void testParseHTTPMessage() {
		String testMessage = "GET TestFile.html HTTP/1.0";
		HTTPMethod result = testServer.parseHTTPMessage(testMessage);
		
		assertEquals(HTTPMethod.GET, result);
	}

}
