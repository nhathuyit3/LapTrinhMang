/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@Email: honhathuy12322@gmail.com/hnhuy.17it3@sict.udn.vn
 *@author Ho Nhat Huy Dev
 *@date: Oct 14, 2019
 *@Time: 3:22:05 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 14, 2019|
 */
package Sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	String text;
	ServerSocket server;
	
	public TCPServer() {
		try {
			server = new ServerSocket(7000);
			System.out.println("Server is starting......");
			Socket socket = server.accept();
			BufferedReader stream_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream stream_out = new DataOutputStream(socket.getOutputStream());
			text = stream_in.readLine();
			System.out.println("Received: "+text);
			text = text.toUpperCase() + '\n';
			stream_out.writeBytes(text);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TCPServer();
	}

}
