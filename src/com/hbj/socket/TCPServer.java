package com.hbj.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss  = new ServerSocket(65000);
		while(true){
			Socket s = ss.accept();
			InputStream is =s.getInputStream();
			OutputStream os =s.getOutputStream();
//			DataInputStream dis =new DataInputStream(is);

			byte[] buff = new byte[1024];
			int ch = is.read(buff);
			String content = new String(buff, 0, ch);

			System.out.println(content);
			os.write(String.valueOf(content.length()).getBytes());
//			System.out.println(dis.readUTF());
//			dis.close();

			os.close();
			is.close();
			s.close();
			ss.close();
		}
		
	}

}
