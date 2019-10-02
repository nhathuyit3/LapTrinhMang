/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 10:47:36 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |Sockets|    |Oct 2, 2019|
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		Scanner kb = new Scanner(System.in);
		while(true) {
			String st = din.readUTF();
			System.out.println(st);
			System.out.println("Server: ");
			String msg = kb.nextLine();
			dos.writeUTF("Server: " + msg);
			dos.flush();
			kb = kb.reset();
		}
	}

}
