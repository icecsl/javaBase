package com.hbj.socket;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//import java.net.SocketException;

public class UDPClient2 {
	public static void main(String[] args) throws IOException {
		
		long l=10000L;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(baos);
		dos.writeLong(l);
		
		
		
		
		byte[] buf =baos.toByteArray();
		DatagramPacket p =new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 5678));
		DatagramSocket s=new DatagramSocket(9999);
		s.send(p);
		s.close();
	}

}
