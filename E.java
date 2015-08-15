/*
 * E.java
 *
 * Version:
 *     $Id: Exceptions.java,v 1.7 09/23/2014 $
 * 
 * Authors: Raj & Kamaleshwar
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program calculates the euler's number e in three different ways.
 */

public class E {
	
	//get the original e value
	double e_original=Math.exp(1);
	
	//delta is the maximum difference value between the calculated e value
	//and the original e value
	double delta=0.001;
	
	/*
     * calculateEversion1 method calculates e value by using the (1+(1/n)
     * raised to the power of n      
     */
	
	public void calculateEversion1()
	{			
		double e_value=1;
		
		//increments the n value
		for(double i=1;compare(e_value);i++)
		{	
			//reset e value everytime when number is changed
			e_value=1;
			
			//multiply the expression n times
			for(double j=1;j<=i;j++)
			{
				
			e_value=e_value*(1+(1/i));
			
			}
			
		}		
		
		System.out.println("method 1: "+e_value);
		
	}
	
	/*
     * calculateEversion2 method calculates e value by using the sigma(1/n!)           
     */
	
	public void calculateEversion2()
	{
		double e_value=1;
		
		//increments n value 
		for(int i=1;compare(e_value);i++)
		{			
			double factorial=calcFactorial(i);
			
			//Calculates sum of the total expression
			e_value+=(1/(factorial));			
		}
		
		System.out.println("method 2: "+e_value);
	}
	
	/*
     * calculateEversion3 method calculates e value by using brother's formula
     * i.e. ((2n+2)/(2n+1)!)           
     */
	
	public void calculateEversion3()
	{
		double e_value=0;
		
		for(int i=0;compare(e_value);i++)
		{	
			int numerator=((2*i)+2);
			int denominator=((2*i)+1);	
			
			double factorial=calcFactorial(denominator);
			//Calculates sum of the total expression
			e_value+=(numerator/factorial);			
		}
		
		System.out.println("method 3: "+e_value);
	}
	
	/**
     * calcFactorial method calculated the factorial of the number passed
     * and returns it 
     *
     * @param num
     *            number whose factorial has to be calculated    
     *  
     */
	
	public int calcFactorial(int num)
	{
		if(num==0||num==1)
		{
			return 1;
		}
		
		else
		{			
			num=num*calcFactorial(num-1);
		}
		
		return num;
	}
	
	/**
     * compare method checks if the difference of calculated e value and 
     * original e value is less than delta value i.e. 0.001
     *
     * @param e_calc
     *            calculated e value    
     *  
     */
	
	public boolean compare(double e_calc)	
	{
		return (Math.abs(e_calc-e_original)>delta);	
	}
	
	//main method
	public static void main(String args[])
	{
		E e1=new E();
		e1.calculateEversion1();
		e1.calculateEversion2();
		e1.calculateEversion3();
		
	}
	
}
