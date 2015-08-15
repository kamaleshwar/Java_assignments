/*
 *TcpPlayer1.java
 *
 * Version:
 *     $Id: TcpPlayer1.java,v 1.7 12/08/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*This program contains controller GUI for player X.
 * Communication is done via Tcp Rules.
 * Sends input to TcpGame server and server sends back
 * what to do.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TcpPlayer1 extends Thread {

	String fromMessage;
	String toMessage;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static int count = 0;
	Socket mySocket;
	PrintStream myPrintStream;
	InputStreamReader inputStream;
	BufferedReader buffReader;

	public static void main(String[] args) {

		new TcpPlayer1();

	}

	public TcpPlayer1() {

		try {

			mySocket = new Socket("localhost", 4497);
			myPrintStream = new PrintStream(mySocket.getOutputStream());
			toMessage = "Hello to Server from Player 1";
			myPrintStream.println(toMessage);

			inputStream = new InputStreamReader(mySocket.getInputStream());
			buffReader = new BufferedReader(inputStream);
			fromMessage = buffReader.readLine();
			System.out.println(fromMessage);

			frame.setTitle("TicTacToe Player X");

			frame.setSize(300, 300);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			frame.setResizable(true);

			panel.setLayout(new GridLayout(3, 3));

		    JButton button1 = new JButton();
			JButton button2 = new JButton();
			JButton button3 = new JButton();
			JButton button4 = new JButton();
			JButton button5 = new JButton();
			JButton button6 = new JButton();
			JButton button7 = new JButton();
			JButton button8 = new JButton();
			JButton button9 = new JButton();

			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			panel.add(button4);
			panel.add(button5);
			panel.add(button6);
			panel.add(button7);
			panel.add(button8);
			panel.add(button9);

			frame.add(panel);

			
				button1.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button1X");												
						}																	
					}
				});
				
				button2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button2X");												
						}																	
					}
				});
				
				button3.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button3X");												
						}																	
					}
				});
				

				button4.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button4X");												
						}																	
					}
				});
				
				button5.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button5X");												
						}																	
					}
				});
				
				button6.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button6X");												
						}																	
					}
				});
				
				button7.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button7X");												
						}																	
					}
				});
				
				button8.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button8X");												
						}																	
					}
				});
				button9.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (count == 0) {						
							
							myPrintStream.println("Button9X");												
						}																	
					}
				});
				
				
				
				
				
				
				
				while(true){
				
					fromMessage = buffReader.readLine();
					System.out.println(fromMessage);
					
					if(fromMessage.equals("Button1X")){
						
						button1.setText("X");
					}
					
					if(fromMessage.equals("Button2X")){
						
						button2.setText("X");
					}
					
					if(fromMessage.equals("Button3X")){
						
						button3.setText("X");
					}
					if(fromMessage.equals("Button4X")){
						
						button4.setText("X");
					}
					
					if(fromMessage.equals("Button5X")){
						
						button5.setText("X");
					}
					
					if(fromMessage.equals("Button6X")){
						
						button6.setText("X");
					}
					if(fromMessage.equals("Button7X")){
						
						button7.setText("X");
					}
					
					if(fromMessage.equals("Button8X")){
						
						button8.setText("X");
					}
					if(fromMessage.equals("Button9X")){
						
						button9.setText("X");
					}

					if(fromMessage.equals("Button1O")){
						
						button1.setText("O");
					}
					
					if(fromMessage.equals("Button2O")){
						
						button2.setText("O");
					}
					
					if(fromMessage.equals("Button3O")){
						
						button3.setText("O");
					}
					
					if (fromMessage.equals("Button4O")) {

						button4.setText("O");
					}

					if (fromMessage.equals("Button5O")) {

						button5.setText("O");
					}

					if (fromMessage.equals("Button6O")) {

						button6.setText("O");
					}
					if (fromMessage.equals("Button7O")) {

						button7.setText("O");
					}

					if (fromMessage.equals("Button8O")) {

						button8.setText("O");
					}
					if (fromMessage.equals("Button9O")) {

						button9.setText("O");
					}
					
					if (fromMessage.equals("Xwin")) {

						JOptionPane.showMessageDialog(frame, "X Wins ");
						System.exit(0);
					
					}
					if (fromMessage.equals("Owin")) {

						JOptionPane.showMessageDialog(frame, "X Loses ");
						System.exit(0);
					
					}
					if (fromMessage.contains("Draw")) {

	   					JOptionPane.showMessageDialog(frame, "Draw");
	   					System.exit(0);
	   				
	   				}
					
				}
			
		}

		catch (Exception e) {
			
			System.out.println("Game Exited");

		}

	}

}
