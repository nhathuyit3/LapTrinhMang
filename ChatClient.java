/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@Email: honhathuy12322@gmail.com/hnhuy.17it3@sict.udn.vn
 *@author Ho Nhat Huy Dev
 *@date: Oct 5, 2019
 *@Time: 11:19:03 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 5, 2019|
 */
package Sockets;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ChatClient {
	JFrame fr;
	Container c;
	JTextArea textdis;
	JTextField textgui;
	JButton gui;
	Socket s;
	OutputStream os;
	InputStream is;
	inputstream threadnhap;
	outputstream threadxuat;
	PrintWriter pw;
	
	public ChatClient() {
		GUI();
		Taogiaodien();
	}
	private void GUI(){	  
	    fr = new JFrame("Client");
	    fr.setBounds(10, 10, 500, 500);
	    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    textdis = new JTextArea();
	    textdis.setBounds(10, 10, 480, 300);
	    textdis.setEditable(false);
	    textgui = new JTextField();
	    textgui.setBounds(10, 320, 300, 30);
	    entertextgui keygui = new entertextgui();
	    textgui.addKeyListener(keygui);

	    gui = new JButton("Gui");
	    gui.setBounds(320, 320, 80, 30);
	    guidi gd = new guidi();
	    gui.addActionListener(gd);

	    c= fr.getContentPane();
	    c.setLayout(null);
	    c.add(textdis);
	    c.add(textgui);
	    c.add(gui);

	    fr.setVisible(true);
	}
	private void Taogiaodien(){

	    try {

	        s = new Socket("localhost",8001);

	        os = s.getOutputStream();

	        is = s.getInputStream();

	    } catch (IOException ex) {

	        System.out.println("Loi phan socket: " +ex.getMessage());

	        if("Connection refused".equals(ex.getMessage())){

	            System.out.println("Chua bat server!");

	            textdis.setText("Không có kết nối với SERVER!");

	        }

	        try {

	            Thread.sleep(2000);

	        } catch (InterruptedException ex1) {

	            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex1);

	        }

	        System.exit(0);

	    }

	    

	    threadnhap = new inputstream();

	    threadnhap.start(); // chạy thread

	}





	private void nutgui(){

	    

	    pw =new PrintWriter(os);

	    String gui=textgui.getText();

	    System.out.println("Gui: "+gui);

	    textdis.setText(textdis.getText()+"Me: "+gui+"\n");

	    textgui.setText("");

	    pw.println(gui); pw.flush();

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

	            textdis.setText(textdis.getText()+"Server: "+nhan+"\n");

	            System.out.println("\n---- Nhan: " + nhan);

	        }

	    }

	    

	}



	class outputstream extends Thread{

	    @Override

	    public void run() {

	        pw =new PrintWriter(os);

	        Scanner sc = new Scanner(System.in);

	        String gui="";

	        while(true){

	            System.out.print("Gui: ");

	            gui = sc.nextLine();

	            pw.println(gui); pw.flush();

	        }

	    }

	}



	class guidi implements ActionListener{



	    public void actionPerformed(ActionEvent e) {

	        pw =new PrintWriter(os);

	        String gui=textgui.getText();

	        System.out.println("Gui: "+gui);

	        textdis.setText(textdis.getText()+"Me: "+gui+"\n");

	        textgui.setText("");

	        pw.println(gui); pw.flush();

	    }

	}



	public static void main(String[] args) {

		ChatClient b = new ChatClient();

	}
}
