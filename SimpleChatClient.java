/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 10:54:18 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |Sockets|    |Oct 2, 2019|
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket socket = new Socket("Localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner kb = new Scanner(System.in);
		while(true) {
			System.out.println("Client:");
			String msg = kb.nextLine();
			
			dos.writeUTF("Client: " + msg);
			dos.flush();
			
			String st  =din.readUTF();
			System.out.println(st);
			
			kb = kb.reset();
		}
	}

}
