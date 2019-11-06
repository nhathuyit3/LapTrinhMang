/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@Email: honhathuy12322@gmail.com/hnhuy.17it3@sict.udn.vn
 *@author Ho Nhat Huy Dev
 *@date: Oct 23, 2019
 *@Time: 2:47:57 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 23, 2019|
 */
package Sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTimeClient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DatagramSocket clientSocket = new DatagramSocket(4000);
		while(true)
		{
			DatagramPacket sendPacket = new DatagramPacket("Data".getBytes(), "Data".length(), InetAddress.getByName("localhost"), 10000);
			clientSocket.send(sendPacket);
		}
	}

}

