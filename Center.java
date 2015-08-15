/*
 *Center.java
 *
 * Version:
 *     $Id: Center.java,v 1.7 09/28/2014 $
 *     
 * Author: Raj:rk2277 & Kamaleshwar:kp2601
 * 
 *
 * Revisions:
 *     $Log$
 */

/*This program finds the center object of all given objects
 * with x,y,z coordinates in a 3-d space reading input
 * from a text file. Center object implies the object which has 
 * the least sum of distances from it to every other object.
 */

import java.util.Scanner;
import java.io.File;
import java.math.*;

public class Center {

	public static void main(String[] args) {
		// declare number of objects
		int objects = 4;
		// parts array is used to hold x y z coordinates of each point.
		String parts[] = new String[3];
		// pointX,pointY,pointZ contain x,y,z resp coordinates of all points.
		String pointX[] = new String[objects + 1];
		String pointY[] = new String[objects + 1];
		String pointZ[] = new String[objects + 1];

		double distanceArray[] = new double[objects];

		try {
			// reading file.txt for coordinates
			Scanner sc = new Scanner(new File("file.txt"));

			int i = 0;
			// reading each line of coordinates and putting them in X, Y, Z
			// arrays.
			while (sc.hasNext()) {
				String line = sc.nextLine();
				// splitting string array into x, y, z parts
				parts = line.split(" ");
				// putting each coordinate into respective type array.
				pointX[i] = parts[0];
				pointY[i] = parts[1];
				pointZ[i] = parts[2];

				i++;

			}
			sc.close();
			// Printing the points coordinates
			for (int j = 0; j < objects; j++) {

				System.out.println(pointX[j] + " " + pointY[j] + " "
						+ pointZ[j]);

			}

			// Calculating the sum of distances from each point to
			// every other point and storing them in distanceArray.

			for (int k = 0; k < objects; k++) {

				double distanceSum = 0;

				for (int n = 0; n < objects; n++) {

					distanceSum += Math
							.sqrt((Integer.parseInt(pointX[k]) - Integer
									.parseInt(pointX[n]))
									* (Integer.parseInt(pointX[k]) - Integer
											.parseInt(pointX[n]))
									+ (Integer.parseInt(pointY[k]) - Integer
											.parseInt(pointY[n]))
									* (Integer.parseInt(pointY[k]) - Integer
											.parseInt(pointY[n]))
									+ (Integer.parseInt(pointZ[k]) - Integer
											.parseInt(pointZ[n]))
									* (Integer.parseInt(pointZ[k]) - Integer
											.parseInt(pointZ[n]))

							);

					// System.out.println(distanceSum);

				}
				// Storing each distance sum in distanceArray.
				distanceArray[k] = distanceSum;
				// System.out.println(distanceArray[k]);

			}

			// Finding minimum sum distance
			double minimum = distanceArray[0];
			for (int counter = 0; counter < objects; counter++) {

				minimum = minimum < distanceArray[counter] ? minimum
						: distanceArray[counter];
			}
			System.out.println("Minimum distance Sum:	" + minimum);

			// Finding center point/s coordinates

			for (int counter = 0; counter < objects; counter++) {
				if (distanceArray[counter] == minimum)
					// Printing center point i.e Answer.
					System.out.println("Centre Point is : " + pointX[counter]
							+ " " + pointY[counter] + " " + pointZ[counter]);

			}

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}
