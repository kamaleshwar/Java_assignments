/*
 *Integrator.java
 *
 * Version:
 *     $Id: Integrator.java,v 1.7 10/27/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

import java.text.*;

/**
 * This class calculates the volume of x*x+2y graph by using multi-threading
 * 
 */

public class Integrator {
	static double greenUpArea;
	static double greenDownArea;
	static double yellowUpArea;
	static double yellowDownArea;
	double z;
	double unit = 0.01;
	double x;
	double y;
	double greenArea;
	double yellowArea;
	calcVolumeF t1;
	calcVolumeB t2;

	/**
	 * This class extends Thread class and creates a new thread every time when
	 * its instance is created
	 */

	class calcVolumeF extends Thread {

		private double x;
		private double y;
		private double z;
		private double unit;

		public calcVolumeF(double x, double y, double z, double unit) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.unit = unit;
		}

		public void run() {
			if (z < 0) {
				yellowDownArea += unit * unit * z;
			} else {
				greenUpArea += unit * unit * z;
			}
		}

	}

	/**
	 * This class extends Thread class and creates a new thread every time when
	 * its instance is created
	 */

	class calcVolumeB extends Thread {

		private double x;
		private double y;
		private double z;
		private double unit;

		public calcVolumeB(double x, double y, double z, double unit) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.unit = unit;
		}

		public void run() {
			if (z < 0) {
				greenDownArea += unit * unit * z;
			} else {
				yellowUpArea += unit * unit * z;
			}

		}
	}

	/**
	 * doAction method created threads for every unit area
	 */

	public void doAction() {
		do {
			for (y = -2; y <= 2; y = y + unit) {
				for (x = -1; x <= 1; x = x + unit) {
					z = ((x * x) + 2 * y);
					t1 = new calcVolumeF(x, y, z, unit);
					t1.start();
					try {
						t1.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			for (y = 2; y >= -2; y = y - unit) {
				for (x = 1; x >= -1; x = x - unit) {
					z = ((x * x) + 2 * y);
					t2 = new calcVolumeB(x, y, z, unit);
					t2.start();
					try {
						t2.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			greenArea = greenUpArea + greenDownArea;

			yellowArea = yellowUpArea + yellowDownArea;

			System.out.println("yellowArea area: " + yellowArea);
			System.out.println("greenArea area: " + greenArea);
			System.out.println("(yellowArea - greenArea): "
					+ Math.abs(yellowArea - greenArea));
		} while (Math.abs(yellowArea - greenArea) <= 0.01);
	}

	public static void main(String[] args) {

		Integrator obj = new Integrator();
		obj.doAction();
	}
}
