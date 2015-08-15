
/*
 *ProductionFactory.java
 *
 * Version:
 *     $Id: ProductionFactory.java,v 1.7 11/03/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class starts producer and consumer threads
 * 
 */

public class ProductionFactory extends Thread {

	static int[] conveyar;
	boolean consumed = false;
	static Object sharedobj = new Object();
	int screwcounter=0;
	int basecounter=0;
	int standcounter=0;
	int socketcounter=0;
	int bulbcounter=0;
	boolean screwsRemoved=false;
	boolean baseRemoved=false;
	boolean standRemoved=false;
	boolean socketRemoved=false;
	boolean bulbRemoved=false;
	
	
	// starting all the threads

	Thread screwT = new screws(sharedobj);
	Thread baseT = new base(sharedobj);
	Thread standT = new stand(sharedobj);
	Thread socketT = new sockets(sharedobj);
	Thread lightT = new lightbulb(sharedobj);
	Thread consumer2 = new Consumer(sharedobj);
	Thread consumer1 = new Consumer(sharedobj);

	ProductionFactory() {
		conveyar = new int[21];
	}

	public void run() {
		screwT.start();
		baseT.start();
		standT.start();
		socketT.start();
		lightT.start();
		consumer1.start();
		consumer2.start();
		consumer1.setName("consumer 1");
		consumer2.setName("consumer 2");
	}

	/**
	 * getItemCount method counts the number of specified Items
	 * 
	 * @param arr
	 *            [] Array whose elements to be counted
	 * 
	 * @param id
	 *            Item to be counted
	 * 
	 * @return count count of specified items
	 * 
	 */

	public int getItemCount(int[] arr, int Item) {
		synchronized (sharedobj) {
			int count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == Item) {
					count++;
				}
			}

			return count;

		}

	}

	/**
	 * This class produces screws to be consumed
	 * 
	 */

	class screws extends Thread {
		Object sharedobj;

		screws(Object ItemName) {
			this.sharedobj = ItemName;
		}

		public void run() {
			produce();
		}

		/**
		 * produce method produces the screws
		 * 
		 */

		public void produce() {
			while (true) {
				synchronized (sharedobj) {
					try {
						while (getItemCount(conveyar, 1) == 4 && consumed) {
							sharedobj.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					while (getItemCount(conveyar, 1) <4) {
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("producing screws");
						for (int i = 0; i < 4; i++) {
							conveyar[i] = 1;
						}

						sharedobj.notify();
					}

				}
			}
		}
	}

	/**
	 * This class produces bases to be consumed
	 * 
	 */

	class base extends Thread {
		Object sharedobj;

		base(Object sharedobj) {
			this.sharedobj = sharedobj;
		}

		public void run() {
			produce();
		}

		/**
		 * produce method produces the base
		 * 
		 */

		public void produce() {
			while (true) {
				synchronized (sharedobj) {
					try {
						while (getItemCount(conveyar, 2) == 2 && consumed) {
							sharedobj.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					while (getItemCount(conveyar, 2) <2) {
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("producing base");
						for (int i = 4; i < 6; i++) {
							conveyar[i] = 2;
						}
						sharedobj.notify();
					}
				}
			}
		}
	}

	/**
	 * This class produces stand to be consumed
	 * 
	 */

	class stand extends Thread {

		Object sharedobj;

		stand(Object sharedobj) {
			this.sharedobj = sharedobj;
		}

		public void run() {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * produce method produces the stand
		 * 
		 */

		public void produce() throws InterruptedException {
			while (true) {
				synchronized (sharedobj) {
					while (getItemCount(conveyar, 3) == 4 && consumed) {
						sharedobj.wait();
					}
					while (getItemCount(conveyar, 3) <4) {
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("producing stand");
						for (int i = 6; i < 10; i++) {
							conveyar[i] = 3;
						}
						sharedobj.notify();
					}
				}

			}
		}
	}

	/**
	 * This class produces sockets to be consumed
	 * 
	 */

	class sockets extends Thread {

		Object sharedobj;

		sockets(Object sharedobj) {
			this.sharedobj = sharedobj;
		}

		public void run() {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * produce method produces the sockets
		 * 
		 */

		public void produce() throws InterruptedException {
			while (true) {
				synchronized (sharedobj) {
					while (getItemCount(conveyar, 4) == 7 && consumed) {
						sharedobj.wait();
					}
					while (getItemCount(conveyar, 4) <7) {
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("producing sockets");
						for (int i = 10; i < 17; i++) {
							conveyar[i] = 4;
						}
						sharedobj.notify();
					}
				}
			}
		}
	}

	/**
	 * This class produces light bulb to be consumed
	 * 
	 */

	class lightbulb extends Thread {

		Object sharedobj;

		lightbulb(Object sharedobj) {
			this.sharedobj = sharedobj;
		}

		public void run() {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/**
		 * produce method produces the light bulb
		 * 
		 */

		public void produce() throws InterruptedException {
			while (true) {
				synchronized (sharedobj) {
					while (getItemCount(conveyar, 5) == 4 && consumed) {
						sharedobj.wait();
					}
					while (getItemCount(conveyar, 5) <4) {
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("producing bulbs");
						for (int i = 17; i < 21; i++) {
							conveyar[i] = 5;
						}
						sharedobj.notify();
					}
				}
			}
		}
	}

	/**
	 * This class consumes the objects created by the producer classes
	 * 
	 */

	class Consumer extends Thread {

		Object sharedobj;

		Consumer(Object sharedobj) {
			this.sharedobj = sharedobj;
		}

		public void run() {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		/**
		 * consume method consumes the produced items
		 * 
		 */

		public void consume() throws InterruptedException {
			while (true) {
				synchronized (sharedobj) {
					while (getItemCount(conveyar, 1) >= 4
							&& getItemCount(conveyar, 2) >= 1
							&& getItemCount(conveyar, 3) >= 1
							&& getItemCount(conveyar, 4)>= 3
							&& getItemCount(conveyar, 5) >= 3) {
						sleep(500);
						System.out.println(Thread.currentThread().getName()
								+ " is consuming");
						System.out.println();
						for (int i = 0; i < conveyar.length; i++) {
							if(conveyar[i]==1 && !screwsRemoved)
							{
								conveyar[i] = 0;
								 screwcounter++;
								if(screwcounter==4)
								screwsRemoved=true;
								screwcounter=0;
								
							}
							if(conveyar[i]==2 && !baseRemoved)
							{
								conveyar[i] = 0;
								basecounter++;
								if(basecounter==1)
								baseRemoved=false;
								basecounter=0;
								
							}
							if(conveyar[i]==3 && !standRemoved)
							{
								conveyar[i] = 0;
								standcounter++;
								if(standcounter==1)
								standRemoved=true;
								standcounter=0;
								
							}
							
							if(conveyar[i]==4 && !socketRemoved )
							{
								conveyar[i] = 0;
								socketcounter++;
								if(socketcounter==3)
								socketRemoved=true;
								socketcounter=0;
								
							}
							
							if(conveyar[i]==5 && !bulbRemoved)
							{
								conveyar[i] = 0;
								bulbcounter++;
								if(bulbcounter==3)
								bulbRemoved=true;
								bulbcounter=0;
								
							}
							
							consumed = true;
							
						}
						sharedobj.notifyAll();
					}
					consumed = false;
					sharedobj.wait();
				}
			}

		}

	}

	public static void main(String[] args) {

		new ProductionFactory().start();

	}

}
