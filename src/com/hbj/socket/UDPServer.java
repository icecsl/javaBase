package com.hbj.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
     public static void main(String[] args) throws IOException {
		DatagramSocket s=new DatagramSocket(6789);
		byte[] buf =new byte[1024];
		DatagramPacket p =new DatagramPacket(buf, buf.length);

		s.receive(p);

		byte[] data = p.getData();
		String content = new String(data, 0, p.getLength());
		System.out.println(content);

		byte[] sendContent = String.valueOf(content.length()).getBytes();
		DatagramPacket packetToClient =new DatagramPacket(sendContent, sendContent.length, p.getAddress(), p.getPort());
		s.send(packetToClient);
		
		
	}

}
