/*
 *Hanoi.java
 *
 * Version:
 *     $Id: Hanoi.java,v 1.7 09/23/2014 $
 *     
 * Author: Raj & Kamaleshwar
 * 
 *
 * Revisions:
 *     $Log$
 */

/*This program implements the Tower of Hanoi problem using recursion
 * algorithm. The disks shifting are printed out and the changing 
 * of disks from one pole to another pole is shown.
 */

public class Hanoi {

	// Declaring number of disks and initializing pole arrays

	int disks = 5;
	int[] disk_start = new int[disks + 1];
	int[] disk_aux = new int[disks + 1];
	int[] disk_end = new int[disks + 1];

	/**
	 * move() method implements the tower of Hanoi algorithm recursively
	 *
	 * @param poleStart
	 *            First pole
	 * @param poleOver
	 *            Middle pole
	 * @param endPole
	 *            Last pole
	 *
	 * @return void
	 * 
	 */

	public void move(int n, String poleStart, String poleOver, String poleEnd) {

		// Base case
		if (n == 1) {
			// Moving Disk from poleStart to poleEnd
			System.out.println("Moved disk from pole " + poleStart
					+ " to pole " + poleEnd);
			// Checking for pole positions corresponding to
			// our array positions.
			// Changing position of disk from start to end pole as
			// per recursive call
			// Move the disk
			// Rearrange the array
			//Checking if done for each permutation case of poles
			// 1
			if (poleStart == "0" && poleOver == "1" && poleEnd == "2") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_end[i] != 0) {
						disk_end[i + 1] = disk_end[i];
					}
				}
				disk_end[0] = disk_start[0];

				for (int j = 0; j < disks; j++) {
					if (disk_start[j] != 0) {
						disk_start[j] = disk_start[j + 1];
					}
				}
				// Printing disk arrays of all poles
				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}
				// Printing pole positions.
				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 2

			if (poleStart == "0" && poleOver == "2" && poleEnd == "1") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_aux[i] != 0) {
						disk_aux[i + 1] = disk_aux[i];
					}
				}
				disk_aux[0] = disk_start[0];

				for (int j = 0; j < disks; j++) {
					if (disk_start[j] != 0) {
						disk_start[j] = disk_start[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 3

			if (poleStart == "1" && poleOver == "0" && poleEnd == "2") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_end[i] != 0) {
						disk_end[i + 1] = disk_end[i];
					}
				}
				disk_end[0] = disk_aux[0];

				for (int j = 0; j < disks; j++) {
					if (disk_aux[j] != 0) {
						disk_aux[j] = disk_aux[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 4

			if (poleStart == "1" && poleOver == "2" && poleEnd == "0") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_start[i] != 0) {
						disk_start[i + 1] = disk_start[i];
					}
				}
				disk_start[0] = disk_aux[0];

				for (int j = 0; j < disks; j++) {
					if (disk_aux[j] != 0) {
						disk_aux[j] = disk_aux[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 5

			if (poleStart == "2" && poleOver == "0" && poleEnd == "1") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_aux[i] != 0) {
						disk_aux[i + 1] = disk_aux[i];
					}
				}
				disk_aux[0] = disk_end[0];

				for (int j = 0; j < disks; j++) {
					if (disk_end[j] != 0) {
						disk_end[j] = disk_end[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 6

			if (poleStart == "2" && poleOver == "1" && poleEnd == "0") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_start[i] != 0) {
						disk_start[i + 1] = disk_start[i];
					}
				}
				disk_start[0] = disk_end[0];

				for (int j = 0; j < disks; j++) {
					if (disk_end[j] != 0) {
						disk_end[j] = disk_end[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

		}

		// Other cases shifting.

		else {
			move(n - 1, poleStart, poleEnd, poleOver);
			System.out.println("Moved disk from pole " + poleStart
					+ " to disk " + poleEnd);

			// 1

			if (poleStart == "0" && poleOver == "1" && poleEnd == "2") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_end[i] != 0) {
						disk_end[i + 1] = disk_end[i];
					}
				}
				disk_end[0] = disk_start[0];

				for (int j = 0; j < disks; j++) {
					if (disk_start[j] != 0) {
						disk_start[j] = disk_start[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 2

			if (poleStart == "0" && poleOver == "2" && poleEnd == "1") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_aux[i] != 0) {
						disk_aux[i + 1] = disk_aux[i];
					}
				}
				disk_aux[0] = disk_start[0];

				for (int j = 0; j < disks; j++) {
					if (disk_start[j] != 0) {
						disk_start[j] = disk_start[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 3

			if (poleStart == "1" && poleOver == "0" && poleEnd == "2") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_end[i] != 0) {
						disk_end[i + 1] = disk_end[i];
					}
				}
				disk_end[0] = disk_aux[0];

				for (int j = 0; j < disks; j++) {
					if (disk_aux[j] != 0) {
						disk_aux[j] = disk_aux[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 4

			if (poleStart == "1" && poleOver == "2" && poleEnd == "0") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_start[i] != 0) {
						disk_start[i + 1] = disk_start[i];
					}
				}
				disk_start[0] = disk_aux[0];

				for (int j = 0; j < disks; j++) {
					if (disk_aux[j] != 0) {
						disk_aux[j] = disk_aux[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 5

			if (poleStart == "2" && poleOver == "0" && poleEnd == "1") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_aux[i] != 0) {
						disk_aux[i + 1] = disk_aux[i];
					}
				}
				disk_aux[0] = disk_end[0];

				for (int j = 0; j < disks; j++) {
					if (disk_end[j] != 0) {
						disk_end[j] = disk_end[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}

			// 6

			if (poleStart == "2" && poleOver == "1" && poleEnd == "0") {

				for (int i = disks - 1; i >= 0; i--) {
					if (disk_start[i] != 0) {
						disk_start[i + 1] = disk_start[i];
					}
				}
				disk_start[0] = disk_end[0];

				for (int j = 0; j < disks; j++) {
					if (disk_end[j] != 0) {
						disk_end[j] = disk_end[j + 1];
					}
				}

				for (int k = 0; k < disks; k++) {

					System.out.println(disk_start[k] + " " + disk_aux[k] + " "
							+ disk_end[k]);

				}

				System.out.println("-----");
				System.out.println("0" + ":" + "1" + ":" + "2");
				System.out.println("-----");

			}
			// 3rd  recursion call
			move(n - 1, poleOver, poleStart, poleEnd);
		}
	}

	// Main method:

	public static void main(String[] args) {
		Hanoi t = new Hanoi();
		// Putting disks in start polerray
		for (int i = 0; i < t.disks; i++) {

			t.disk_start[i] = (i + 1);
		}

		// Printing of initial disks position
		System.out.println("Original disks setup:");

		for (int i = 0; i < t.disks; i++) {

			System.out.println(t.disk_start[i] + " " + t.disk_aux[i] + " "
					+ t.disk_end[i]);

		}

		System.out.println("-----");
		System.out.println("0" + ":" + "1" + ":" + "2");
		System.out.println("-----");
		// Calling of move algorithm
		t.move(t.disks, "0", "1", "2");
	}
}
