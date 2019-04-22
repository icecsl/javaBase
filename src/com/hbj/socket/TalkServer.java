package com.hbj.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TalkServer {
	public static void main(String[] args) {
		ServerSocket ss=null;
		try {
		try {
			ss=new ServerSocket(8888);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Socket s = null;
		try {
			s = ss.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			BufferedReader is =new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter os =new PrintWriter(s.getOutputStream());
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("client "+is.readLine());
			String sysline = sin.readLine();
			while (!sysline.equals("bye")){
				os.print(sysline);
				os.flush();
				System.out.println("server "+sysline);
				System.out.println(is.readLine());
				sysline = sin.readLine();
				
			}
			os.close();
			is.close();
			s.close();
			ss.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
