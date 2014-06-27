package sandbox;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MyIP {
	public static void main(String[] args) throws InterruptedException, IOException
	{
	    Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
	    while (e.hasMoreElements())
	    {
	        NetworkInterface n = e.nextElement();
	        System.out.println(n.getName());
	        Enumeration<InetAddress> ee = n.getInetAddresses();
	        while (ee.hasMoreElements())
	        {
	            InetAddress i = ee.nextElement();
	            System.out.println(i.getHostName());
	        }
	    }
	}
}
