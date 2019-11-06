/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 9:51:01 AM
 *version 4.0
 *|@Name|                |@Package|           |@Date| 
 *|Laptrinhmang|      |Sockets|    |Oct 2, 2019|
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TimeClient extends Thread{
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		while(true) {
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		String time = din.readUTF();
		System.out.println(time);	
		Thread.sleep(1000);
		}
	}
}

