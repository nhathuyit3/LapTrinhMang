/*(C) Copyright 2019 Fresher Academy. All Rights Reseved.
 *
 *@author Ho Nhat Huy Dev
 *@date: Oct 2, 2019
 *@Time: 3:40:22 PM
 *version 4.0
 *	|@Name|----------|@Package|----------|@Date| 
 *|Laptrinhmang|----------|Sockets|----------|Oct 2, 2019|
 */
package Sockets;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingContentDemo{
		   private JFrame mainFrame;
		   private JLabel headerLabel;
		   private JLabel statusLabel;
		   private JPanel controlPanel;
		   private JLabel msglabel;

		   public SwingContentDemo(){
		      prepareGUI();
		   }

		   public static void main(String[] args){
			   SwingContentDemo  swingContainerDemo = new SwingContentDemo();  
		      swingContainerDemo.showJFrameDemo();
		   }

		   private void prepareGUI(){
		      mainFrame = new JFrame("Vi du Java Swing");
		      mainFrame.setSize(400,400);
		      mainFrame.setLayout(new GridLayout(3, 1));
		      mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            System.exit(0);
		         }        
		      });    
		      headerLabel = new JLabel("", JLabel.CENTER);        
		      statusLabel = new JLabel("",JLabel.CENTER);    

		      statusLabel.setSize(350,100);

		      msglabel = new JLabel("Chao mung ban den voi bai huong dan Java Swing.", JLabel.CENTER);

		      controlPanel = new JPanel();
		      controlPanel.setLayout(new FlowLayout());

		      mainFrame.add(headerLabel);
		      mainFrame.add(controlPanel);
		      mainFrame.add(statusLabel);
		      mainFrame.setVisible(true);  
		   }

		   private void showJFrameDemo(){
		      headerLabel.setText("Container in action: JFrame");   

		      final JFrame frame = new JFrame();
		      frame.setSize(300, 300);
		      frame.setLayout(new FlowLayout());       
		      frame.add(msglabel);
		      frame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
		            frame.dispose();
		         }        
		      });    
		      JButton okButton = new JButton("Open a Frame");
		      okButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            statusLabel.setText("Mot Frame duoc hien thi toi nguoi dung.");
		            frame.setVisible(true);
		         }
		      });
		      controlPanel.add(okButton);
		      mainFrame.setVisible(true);  
		   }
		}
