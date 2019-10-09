/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@Email: honhathuy12322@gmail.com/hnhuy.17it3@sict.udn.vn
 *@author Ho Nhat Huy Dev
 *@date: Oct 5, 2019
 *@Time: 11:23:31 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 5, 2019|
 */
package Sockets;
import java.awt.Container;

import java.awt.TextArea;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.Scanner;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.JTextArea;

import javax.swing.JTextField;
public class ChatServer {
	JFrame fr;
	Container ct;
	JTextArea textdis;
	JTextField textgui;
	JButton gui;
	Socket s;
	OutputStream os;
	InputStream is;
	inputstream threadnhap;
	PrintWriter pw;
	ServerSocket ss;
	private void GUI(){

		fr = new JFrame("server");
		fr.setBounds(10, 10, 500, 500);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    textdis = new JTextArea();

	    textdis.setBounds(10, 10, 480, 300);

	    textgui = new JTextField();

	    textgui.setBounds(10, 320, 300, 30);

	    entertextgui entergui = new entertextgui();

	    textgui.addKeyListener(entergui);
	    gui = new JButton("Gui");
	    gui.setBounds(320, 320, 80, 30);
	    guidi gd = new guidi();

	    gui.addActionListener(gd);

	    ct= fr.getContentPane();

	    ct.setLayout(null);

	    ct.add(textdis);

	    ct.add(textgui);

	    ct.add(gui);

	    

	    fr.setVisible(true);

	}

	public ChatServer(){

	    GUI(); 

	    KhoiTaogiaodien();

	    

	}

	private void KhoiTaogiaodien(){

	    

	    try {

	        ss = new ServerSocket(8001);

	        System.out.println("Da tao server port 1234");

	        s = ss.accept();

	        

	        System.out.println("Co client ket noi");

	        os = s.getOutputStream();

	        is = s.getInputStream();

	        threadnhap = new inputstream();

	        threadnhap.start();

	    } catch (IOException ex) {

	        System.out.println("Loi phan socket: " +ex.getMessage());

	    }

	}





	private void nutgui(){

	    

	    try{

	        

	        

	        pw =new PrintWriter(os);

	        String gui=textgui.getText();

	        System.out.println("Gui: "+gui);

	        textdis.setText(textdis.getText()+"Server(me): "+gui+"\n");

	        textgui.setText("");

	        pw.println(gui); pw.flush();

	    } catch (NullPointerException e){

	        System.out.println("Loi nhap xuat, do chua co client ket noi");

	        JOptionPane.showMessageDialog(textdis, "Loi");

	        

	        try {

	            Thread.sleep(2000);

	        } catch (InterruptedException ex) {

	            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);

	        }

	        System.exit(0);

	    }

	}







	class entertextgui implements KeyListener{

	    

	    public void keyTyped(KeyEvent e) {

	    }



	  

	    public void keyPressed(KeyEvent e) {

	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

	            nutgui();

	        }

	    }

	   

	    public void keyReleased(KeyEvent e) {

	    }

	}







	class inputstream extends Thread{



	    @Override

	    public void run() {

	        Scanner sc = new Scanner(is);

	        String nhan ="";

	        while(true){

	            nhan = sc.nextLine();

	            textdis.setText(textdis.getText()+"Client: "+nhan+"\n");

	            System.out.println("\n---- Nhan: " + nhan);

	        }

	    }

	    

	}



	class guidi implements ActionListener{



	    

	    public void actionPerformed(ActionEvent e) {

	       nutgui();

	    }

	    

	}

	public static void main(String[] args) {

		ChatServer b = new ChatServer();

	}
}
