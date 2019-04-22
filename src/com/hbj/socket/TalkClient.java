package com.hbj.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkClient {
	public static void main(String[] args) {
		try {
			Socket s= new Socket("127.0.0.1",8888);
			BufferedReader is =new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os=new PrintWriter(s.getOutputStream());
			String systemline=sin.readLine();
			while(!systemline.equals("bye")){
				os.print(systemline);
				os.flush();
				System.out.println("client "+systemline);
				System.out.println("server "+is.readLine());
				systemline=sin.readLine();
				
			}
			os.close();
			is.close();
			s.close();
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
