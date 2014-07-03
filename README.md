Simple UDP Web Service
===================

This is Project #1 for Intro to Computer Networks.

The purpose of this assignment is to implement a simple Web service over the UDP transport service. Web client and server programs will communicate over the College of Engineering Local Area Network. Furthermore, the assignment explores fragmentation and defragmentation of long messages.

How to Run
----------

Copy the entire project on both the client and server ends. On the client side, run the *UDPClient* class found in the **prod** package. On the server side (tux192 by default), run *UDPServerMain*, again, in the **prod** package.

The server will then transmit the file found in res/constitution.htm across the Auburn network as requested by *UDPClient*.