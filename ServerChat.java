/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 2:46:38 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 2, 2019|
 */
package Sockets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerChat extends JFrame implements ActionListener{
	static JTextArea content;
	static JButton send;
	static JTextField nhap, toName;
	static String chuoi="";
	static String temp="";
	static ServerSocket serA;
	static Socket s, sA;
	static PrintWriter gui;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServerChat();
		try {
			serA = new ServerSocket(7000);
			s = serA.accept();
			while(true) {
				BufferedReader nhan = new BufferedReader(new InputStreamReader(s.getInputStream()));
				while((chuoi = nhan.readLine()) != null)
				{
					temp += chuoi + "\n";
					content.setText(temp);
					content.setVisible(false);
					content.setVisible(true);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public ServerChat() {
		setSize(600,600);
		setTitle("Server");
		Font f = new Font("Arial", Font.BOLD, 20);
		content.setBackground(Color.cyan);
		content.setEditable(false);
		JScrollPane sp = new JScrollPane(content);
		send = new JButton("Gui");
		nhap = new JTextField(30);
		nhap.setFont(f);
		toName = new JTextField("Nhap ten ban:");
		toName.setFont(f);
		toName.setBackground(Color.darkGray);
		
		add(toName, BorderLayout.PAGE_START);
		add(sp, BorderLayout.CENTER);
		add(nhap, BorderLayout.PAGE_END);
		nhap.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(nhap))
		{
			try {
				gui = new PrintWriter(s.getOutputStream(),true);
				temp += toName.getText()+ ":" + nhap.getText()+ "\n";
				gui.println(toName.getText()+": "+nhap.getText());
				content.setText(temp);
				nhap.setText("");
				nhap.requestFocus();
				content.setVisible(false);
				content.setVisible(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
