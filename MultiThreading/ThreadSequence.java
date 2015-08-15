/*
 *ThreadSequence.java
 *
 * Version:
 *     $Id: ThreadSequence.java,v 1.7 11/10/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

public class ThreadSequence extends Thread {

	String info;
	static ThreadSequence nextObj;

	static ThreadSequence A;
	static ThreadSequence B;
	static ThreadSequence C;
	static boolean Bstart = false;
	static boolean Cstart = false;

	ThreadSequence(String info) {
		this.info = info;
	}

	public void run() {
		try {
			method();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * method() prints the info of each thread entered in to 
	 * synchronized block 
	 */
	
	public void method() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (this.info.equals("A"))
					nextObj = B;
				if (this.info.equals("B"))
				{
					nextObj = C;
					Bstart = true;
				}
				if (this.info.equals("C"))
				{
					nextObj = A;
					Cstart = true;
				}
				synchronized (nextObj) {
					sleep(1000);
					System.out.println(info);

					if (info.equals("A")&& !Bstart )						
						B.start();
					if (info.equals("B")&& !Cstart)
						C.start();

					if (Bstart)
					{
						nextObj.notify();
					}

					if (Cstart)
					{
						nextObj.notify();
					}

				}
				this.wait();
			}
		}
	}

	public static void main(String[] args) {
		A = new ThreadSequence("A");
		B = new ThreadSequence("B");
		C = new ThreadSequence("C");
		A.start();

	}
}
