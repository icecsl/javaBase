package com.hbj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1",65000);
		OutputStream os=s.getOutputStream();
		InputStream is=s.getInputStream();
//		DataOutputStream dos=new DataOutputStream(os);
//		dos.writeUTF("hello server");
		os.write(new String("hello server").getBytes());

		int ch = 0;
		byte[] buff = new byte[1024];
		ch = is.read(buff);

		String content = new String(buff, 0, ch);
		System.out.println(content);

//		os.flush();
		is.close();
		os.close();
		s.close();
	}

}
