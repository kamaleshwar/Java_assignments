/* 
 * Integral.java 
 * 
 * Version: 
 *     vxb9513 
 * 	   rt4469
 * Revisions: 
 *     $Log$ 
 */
import java.text.*;


class Integral 
{
	static double gPosIntegral;
	static double gNegIntegral;
	static double yPosIntegral;
	static double yNegIntegral;
	double x;
	double y;		
	double z;
	double m;
	double n;
	double o;
	double gridSize=0.1;
	double volume=0.0;
	static double gIntegral;
	static double yIntegral;
	static double calcZFor(double x, double y){
		return ((x*x)+2*y);
	}
	static double calcVol(double length, double breadth, double height){
		return length*breadth*height;
	}
	
	/*boolean compare(double d1,double d2){
		int retval = Double.compare(d1, d2);
		if()
	}*/
	static Integral in= new Integral();
	
	/** 
	 * the integrate method adds volumes of small cuboids from both end limits of the graph
	 * 
	 * @tag    Comment for the tag
	 */
	public void integrate(){
		in.gridSize=in.gridSize/10;
		
		int count= 0;
		for(in.y=-2,in.m=2;in.y<2||in.m>-2;in.y=in.y+in.gridSize,in.m=in.m-in.gridSize)
			for(in.x=-1,in.n=1;in.x<1||in.n>-1;in.x=in.x+in.gridSize,in.n=in.n-in.gridSize){
				
				count+=1;
				RunIt t;
				t= new RunIt(x,y);
				t.start();
				try{
					t.join();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(count);
			}
		in.gIntegral=gPosIntegral+gNegIntegral;
		in.yIntegral=yPosIntegral+yNegIntegral;
		System.out.println("\n"+in.gIntegral);
		System.out.println("\n"+in.yIntegral);
	}
	/** 
	 * Runit class has the run class for the threads to implement 
	 *
	 * @tag    Comment for the tag
	 */
	class RunIt extends Thread{
    	double x;
    	double y;
    		public RunIt(double x,double y){
    		this.x=x;
    		this.y=y;
    	}
    		/** 
    		 * the run method calculates the individual volumes of the green area and the yellow areas individually  
    		 *
    		 * @tag    Comment for the tag
    		 */
    		public void run(){
    			in.z=calcZFor(in.x,in.y);
    			in.volume=calcVol(in.gridSize,in.gridSize,in.z);
    			if(in.z<0) yNegIntegral=yNegIntegral+in.volume;
    			else gPosIntegral=gPosIntegral+in.volume;
    			in.o=calcZFor(in.n,in.m);
    			in.volume=calcVol(in.gridSize,in.gridSize,in.o);
    			if(in.o<0) gNegIntegral=gNegIntegral+in.volume;
    			else yPosIntegral=yPosIntegral+in.volume;
    			DecimalFormat df = new DecimalFormat("#.##");
    			//System.out.print(df.format(d));
    			System.out.print("("+df.format(in.x)+","+df.format(in.y)+","+df.format(in.z)+")");
    		}
	}
	
	public static void main(String [] args){
		in.integrate();
	}
	}
	
