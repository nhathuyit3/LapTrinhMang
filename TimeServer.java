/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 9:45:36 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |Sockets|    |Oct 2, 2019|
 */
package Sockets;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
	
	public static void main(String[] args)  throws Exception{
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");
		while(true) {
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			String time = new Date().toString();
			dos.writeUTF("Server tra lai ngay gio= " + time);
			socket.close();
		}
	}
}
