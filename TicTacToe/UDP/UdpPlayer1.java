/*UdpPlayer1.java
 *
 * Version:
 *     $Id: UdpPlayer1.java,v 1.7 12/08/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*This program contains controller GUI for player O.
 * Communication is done via Udp Rules.
 * Sends input to UdpGame server and server sends back
 * what to do.
 */
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class UdpPlayer1 {

	byte[] sendData = new byte[1024];
	byte[] receiveData = new byte[1024];
	String fromMessage;
	String toMessage;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static int count = 0;
	DatagramSocket mySocket;
	InetAddress IPAddress;
	BufferedReader buffReader;
	int port = 4499;

	public static void main(String[] args) {
		new UdpPlayer1();
	}

	public UdpPlayer1() {

		try {
			mySocket = new DatagramSocket();
			IPAddress = InetAddress.getByName("localhost");

			toMessage = "This is Client output";
			sendData = toMessage.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, port);
			mySocket.send(sendPacket);

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

						// myPrintStream.println("Button1O");

						toMessage = "Button1X";
						sendData = new byte[1024];
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						toMessage = "Button2X";
						sendData = new byte[1024];
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button3X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button4.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button4X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});
			button5.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button5X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button6.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button6X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			});

			button7.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {

						sendData = new byte[1024];
						toMessage = "Button7X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button8.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button8X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			button9.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (count == 0) {
						sendData = new byte[1024];
						toMessage = "Button9X";
						sendData = toMessage.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(
								sendData, sendData.length, IPAddress, port);
						try {
							mySocket.send(sendPacket);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});

			while (true) {

				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				mySocket.receive(receivePacket);

				String fromMessage = new String(receivePacket.getData());
				System.out.println(fromMessage);

				System.out.println(fromMessage);

				if (fromMessage.contains("Button1X")) {

					button1.setText("X");
				}

				if (fromMessage.contains("Button2X")) {

					button2.setText("X");
				}

				if (fromMessage.contains("Button3X")) {

					button3.setText("X");
				}
				if (fromMessage.contains("Button4X")) {

					button4.setText("X");
				}

				if (fromMessage.contains("Button5X")) {

					button5.setText("X");
				}

				if (fromMessage.contains("Button6X")) {

					button6.setText("X");
				}
				if (fromMessage.contains("Button7X")) {

					button7.setText("X");
				}

				if (fromMessage.contains("Button8X")) {

					button8.setText("X");
				}

				if (fromMessage.contains("Button9X")) {

					button9.setText("X");
				}

				if (fromMessage.contains("Button1O")) {

					button1.setText("O");
				}

				if (fromMessage.contains("Button2O")) {

					button2.setText("O");
				}

				if (fromMessage.contains("Button3O")) {

					button3.setText("O");
				}
				if (fromMessage.contains("Button4O")) {

					button4.setText("O");
				}

				if (fromMessage.contains("Button5O")) {

					button5.setText("O");
				}

				if (fromMessage.contains("Button6O")) {

					button6.setText("O");
				}
				if (fromMessage.contains("Button7O")) {

					button7.setText("O");
				}

				if (fromMessage.contains("Button8O")) {

					button8.setText("O");
				}
				if (fromMessage.contains("Button9O")) {

					button9.setText("O");
				}

				if (fromMessage.contains("Xwin")) {

					JOptionPane.showMessageDialog(frame, "X Wins ");
					System.exit(0);
				
				}
				if (fromMessage.contains("Owin")) {

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
