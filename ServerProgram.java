/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 5:06:09 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 2, 2019|
 */
package Sockets;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import Sockets.ServerCalculator;
public class ServerProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port;
	      System.out.print("Nhap vao cong lang nge: ");
	      Scanner input = new Scanner(System.in);
	      port = input.nextInt();
	      try {
	         ServerSocket ss = new ServerSocket(port);
	         System.out.println("Server da khoi dong...");
	         while(true){
	            Socket s = ss.accept();
	            System.out.println("Co 1 ket noi den: ip "+s.getInetAddress()+" port "+s.getPort());
	            ServerCalculator sv = new ServerCalculator(s);
	            sv.start();            
	         }      
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         System.out.print("Khong the khoi dong duoc server ...");
	      }
	      

	}

}
