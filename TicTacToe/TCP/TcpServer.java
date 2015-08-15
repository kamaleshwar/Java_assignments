/*
 *TcpServer.java
 *
 * Version:
 *     $Id: TcpServer.java,v 1.7 12/08/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*This program contains TcpServer and Game Rules for 2players
 * playing the game TicTacToe. X always starts first. 
 */
import java.io.*;
import java.net.*;
import java.util.HashSet;

class TcpServer extends Thread {

	static int[] board;
	static int count = 1;
	ServerSocket tcpServerSocket;
	static HashSet<PrintStream> pstreams = new HashSet<PrintStream>();

	public TcpServer(int port) throws IOException {
		tcpServerSocket = new ServerSocket(port);

	}

	public static void main(String[] args) {
		board = new int[10];
		for (int i = 0; i < 9; i++) {
			board[i] = 9;
		}

		try {
			Thread t1 = new TcpServer(4496);
			t1.start();
			Thread t2 = new TcpServer(4497);
			t2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		try {

			Socket mySocket1 = tcpServerSocket.accept();

			while (true) {

				InputStreamReader inputStream1 = new InputStreamReader(
						mySocket1.getInputStream());

				BufferedReader buffReader1 = new BufferedReader(inputStream1);

				String fromMessage = buffReader1.readLine();

				if (fromMessage != null) {

					PrintStream myPrintStream1 = new PrintStream(
							mySocket1.getOutputStream());

					pstreams.add(myPrintStream1);
					myPrintStream1
							.println("Message Received by client1: Sent by server");

					if (fromMessage.equals("Button1X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[0] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button1X");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}

						}

					}

					if (fromMessage.equals("Button1O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[0] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button1O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}

						}

					}

					if (fromMessage.equals("Button2X")) {

						System.out.println(fromMessage + "True");

						if (count % 2 != 0 && board[1] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button2X");
								stream.flush();
							}
							count++;
							board[1] = 1;

							if ((board[0] == 1 && board[1] == 1 && board[2] == 1)
									|| (board[3] == 1 && board[4] == 1 && board[5] == 1)
									|| (board[6] == 1 && board[7] == 1 && board[8] == 1)
									|| (board[0] == 1 && board[4] == 1 && board[8] == 1)
									|| (board[6] == 1 && board[4] == 1 && board[2] == 1)
									|| (board[0] == 1 && board[3] == 1 && board[6] == 1)
									|| (board[1] == 1 && board[4] == 1 && board[7] == 1)
									|| (board[2] == 1 && board[5] == 1 && board[8] == 1)) {
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button2O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[1] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button2O");
								stream.flush();
							}
							count++;
							board[1] = 0;

							if ((board[0] == 0 && board[1] == 0 && board[2] == 0)
									|| (board[3] == 0 && board[4] == 0 && board[5] == 0)
									|| (board[6] == 0 && board[7] == 0 && board[8] == 0)
									|| (board[0] == 0 && board[4] == 0 && board[8] == 0)
									|| (board[6] == 0 && board[4] == 0 && board[2] == 0)
									|| (board[0] == 0 && board[3] == 0 && board[6] == 0)
									|| (board[1] == 0 && board[4] == 0 && board[7] == 0)
									|| (board[2] == 0 && board[5] == 0 && board[8] == 0)) {
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button3X")) {

						if (count % 2 != 0 && board[2] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button3X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button3O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[2] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button3O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}

						}

					}

					if (fromMessage.equals("Button4X")) {

						if (count % 2 != 0 && board[3] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button4X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button4O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[3] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button4O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button5X")) {

						if (count % 2 != 0 && board[4] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button5X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button5O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[4] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button5O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button6X")) {

						if (count % 2 != 0 && board[5] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button6X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button6O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[5] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button6O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button7X")) {

						if (count % 2 != 0 && board[6] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button7X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button7O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[6] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button7O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button8X")) {

						if (count % 2 != 0 && board[7] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button8X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button8O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[7] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button8O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
								}
							}
						}

					}

					if (fromMessage.equals("Button9X")) {

						if (count % 2 != 0 && board[8] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button9X");
								stream.flush();

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
								for (PrintStream stream : pstreams) {
									stream.println("Xwin");
									stream.flush();
								}
							}
						}
					}

					if (fromMessage.equals("Button9O")) {

						System.out.println(fromMessage + "True");

						if (count % 2 == 0 && board[8] == 9) {
							for (PrintStream stream : pstreams) {
								stream.println("Button9O");
								stream.flush();
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
								for (PrintStream stream : pstreams) {
									stream.println("Owin");
									stream.flush();
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
						for (PrintStream stream : pstreams) {
							stream.println("Draw");
							stream.flush();

						}

					}

				}
			}
		}

		catch (Exception e) {
			System.out.println("Game Exited");
		}

	}
}
