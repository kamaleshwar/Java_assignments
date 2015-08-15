/*
 *UdpServer.java
 *
 * Version:
 *     $Id: UdpServer.java,v 1.7 12/08/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*This program contains UdpServer and Game Rules for 2players
 * playing the game TicTacToe. X always starts first. 
 */
import java.io.*;
import java.util.*;
import java.net.*;

public class UdpServer extends Thread {

	static int[] board;
	static int count = 1;
	DatagramSocket udpServerSocket;
	String toMessage;
	String fromMessage;
	byte[] receiveData = new byte[1024];
	byte[] sendData = new byte[1024];
	static HashSet<Integer> ports = new HashSet<Integer>();

	public UdpServer(int port) throws IOException {
		udpServerSocket = new DatagramSocket(port);

	}

	public static void main(String[] args) {
		board = new int[10];
		for (int i = 0; i < 9; i++) {
			board[i] = 9;
		}

		try {
			Thread t1 = new UdpServer(4488);
			t1.start();
			Thread t2 = new UdpServer(4499);
			t2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {

			while (true) {

				receiveData = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				udpServerSocket.receive(receivePacket);
				String fromMessage = new String(receivePacket.getData());

				InetAddress IPAddress = receivePacket.getAddress();

				ports.add(receivePacket.getPort());

				for (Integer port : ports) {
					DatagramPacket sendPacket = new DatagramPacket(sendData,
							sendData.length, IPAddress, port);
					udpServerSocket.send(sendPacket);
				}

				

				if (fromMessage != null) {

					if (fromMessage.contains("Button1X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[0] == 9) {
							sendData = new byte[1024];
							toMessage = "Button1X";
							sendData = toMessage.getBytes();

							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[0] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();

								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}

						}

					}

					if (fromMessage.contains("Button1O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[0] == 9) {
							sendData = new byte[1024];
							toMessage = "Button1O";
							sendData = toMessage.getBytes();

							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[0] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();

								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}

							}

						}
					}

					if (fromMessage.contains("Button2X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[1] == 9) {
							sendData = new byte[1024];
							toMessage = "Button2X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}
							board[1] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button2O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[1] == 9) {
							sendData = new byte[1024];
							toMessage = "Button2O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}
							board[1] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button3X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[2] == 9) {
							sendData = new byte[1024];
							toMessage = "Button3X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[2] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button3O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[2] == 9) {
							sendData = new byte[1024];
							toMessage = "Button3O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[2] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button4X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[3] == 9) {
							sendData = new byte[1024];
							toMessage = "Button4X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[3] = 1;
							count++;
							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button4O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[3] == 9) {
							sendData = new byte[1024];
							toMessage = "Button4O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[3] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button5X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[4] == 9) {
							sendData = new byte[1024];
							toMessage = "Button5X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[4] = 1;
							count++;
							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button5O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[4] == 9) {
							sendData = new byte[1024];
							toMessage = "Button5O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[4] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}
					if (fromMessage.contains("Button6X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[5] == 9) {
							sendData = new byte[1024];
							toMessage = "Button6X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[5] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button6O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[5] == 9) {
							sendData = new byte[1024];
							toMessage = "Button6O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[5] = 0;
							count++;
							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}
					if (fromMessage.contains("Button7X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[6] == 9) {
							sendData = new byte[1024];
							toMessage = "Button7X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[6] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button7O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[6] == 9) {
							sendData = new byte[1024];
							toMessage = "Button7O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[6] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}
					if (fromMessage.contains("Button8X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[7] == 9) {
							sendData = new byte[1024];
							toMessage = "Button8X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[7] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button8O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[7] == 9) {
							sendData = new byte[1024];
							toMessage = "Button8O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[7] = 0;
							count++;
							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}
					if (fromMessage.contains("Button9X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[8] == 9) {
							sendData = new byte[1024];
							toMessage = "Button9X";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[8] = 1;
							count++;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								sendData = new byte[1024];
								toMessage = "Xwin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}

					if (fromMessage.contains("Button9O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[8] == 9) {
							sendData = new byte[1024];
							toMessage = "Button9O";
							sendData = toMessage.getBytes();
							for (Integer port : ports) {
								DatagramPacket sendPacket = new DatagramPacket(
										sendData, sendData.length, IPAddress,
										port);
								udpServerSocket.send(sendPacket);
							}

							board[8] = 0;
							count++;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								sendData = new byte[1024];
								toMessage = "Owin";
								sendData = toMessage.getBytes();
								for (Integer port : ports) {
									DatagramPacket sendPacket = new DatagramPacket(
											sendData, sendData.length,
											IPAddress, port);
									udpServerSocket.send(sendPacket);
								}
							}
						}

					}
					
					int check = 0;
					for (int i = 0; i < 9; i++) {
						if (board[i] != 9) {
							check++;
						}
					}

					if (check == 9) {

						sendData = new byte[1024];
						toMessage = "Draw";
						sendData = toMessage.getBytes();

						for (Integer port : ports) {
							DatagramPacket sendPacket = new DatagramPacket(
									sendData, sendData.length, IPAddress, port);
							udpServerSocket.send(sendPacket);
						}

					}

				}

			}
		}

		catch (Exception e) {
			System.out.println("Exit Game");
		}

	}
}
