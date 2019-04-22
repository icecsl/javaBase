package com.hbj.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//import java.net.SocketException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		DatagramSocket s=new DatagramSocket();
		byte[] buf =(new String("hello server").getBytes());
		DatagramPacket p =new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 6789));

		s.send(p);

		byte[] buff =new byte[1024];
		DatagramPacket receiveP = new DatagramPacket(buff, buff.length);
		s.receive(receiveP);
		String content = new String(receiveP.getData(), 0, receiveP.getLength());
		System.out.println(content);


	}

}
