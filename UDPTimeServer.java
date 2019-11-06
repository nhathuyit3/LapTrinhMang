/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@Email: honhathuy12322@gmail.com/hnhuy.17it3@sict.udn.vn
 *@author Ho Nhat Huy Dev
 *@date: Oct 23, 2019
 *@Time: 2:38:39 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 23, 2019|
 */
package Sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class UDPTimeServer {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		DatagramSocket serverSocket = new DatagramSocket(10000);
		System.out.println("Server is started");
		while(true)
		{
			byte[] receiveData = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			System.out.println(new String(receivePacket.getData()));
			InetAddress IPAddress = InetAddress.getByName("localhost");
			byte[] sendData = new byte[1024];
			
			sendData = "CBA".getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 4000);
			serverSocket.send(sendPacket);
			String time = new Date().toString();
			
		}
	}

}
