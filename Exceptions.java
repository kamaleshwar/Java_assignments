/*
 * Exceptions.java
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
 * This program catches some of the checked and unchecked exceptions and handles them.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Exceptions {
	
	/**
     * IllegalArgumentMethod method checks for the legal argument and throws      
     * an IllegalArgumentException otherwise. 
     *
     * @param arg
     *            argument passed to the IllegalArgumentException method    
     *  
     */
	
	 	
	public static void IllegalArgumentMethod(int arg)
	{
		if(arg<1)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			System.out.println(arg);	
		}
	}
	
	//main program
	
	public static void main(String args[])
	{		
		int num=0;
		
		switch(num)
		{
		
		//unchecked Exceptions
		
		//ArithmeticException
		case 0:
			
			try
			{	
				int a=8,b=0;	
				// throws ArithmeticException when number is divided
				//by zero
				int result=(a/b);
				
				System.out.println(result);
			}
		
		
			
		catch(ArithmeticException ae)
		{
			//handles ArithmeticException
			System.out.println(ae);
		}
			
		//ArrayIndexOutOfBoundsException
		case 1:
			
			try
			{
				
				int array[]=new int[3];
			
				for(int i=3;i>0;i++)
				{	//throws ArrayIndexOutOfBoundsException when array index 
					//goes less than zero
					System.out.println(array[i]);
				}
			
			}
			catch(ArrayIndexOutOfBoundsException aiobe)
			{	
				//handles ArrayIndexOutOfBoundsException
				System.out.println(aiobe);
			}
			
		//NullPointerException	
		case 2:
			
			try
			{	
				String test=null;
				
				//throws NullPointerException when null is compared with anything
				System.out.println(test.equals(null));		
					
			}
			
			catch(NullPointerException npe)
			{
				//handles NullPointerException
				System.out.println(npe);
			
			}
			
		//NegativeArraySizeException
		case 3:
			
			try
			{
				//throws NegativeArraySizeException when an array is 
				//Initialized with negative size
				int array[]= new int [-1];
			}
			
			catch(NegativeArraySizeException nase)
			{
				//handles NegativeArraySizeException
				System.out.println(nase);
			}
			
		//StringIndexOutOfBoundsException	
		case 4:
			
			try
			{	
				String test="Hello";
				//throws StringIndexOutOfBoundsException when tried to read
				//a string beyond the length of it
				System.out.println(test.charAt(test.length()+1));
			}
			
			catch(StringIndexOutOfBoundsException siobe)
			{
				//handles StringIndexOutOfBoundsException
				System.out.println(siobe);
			}
			
		//ArrayStoreException	
		case 5:
			
			try
			{	
				//throws ArrayStoreException when incompatible type is tried
				//to be inserted in to array
				Object obj[]=new String[3];
				obj[0]=new int[1];
			}
			
			catch(ArrayStoreException ase)
			{	
				//handles ArrayStoreException
				System.out.println(ase);
			}
			
			
		//ClassCastException
		case 6:
			
			try
			{	
				//throws ClassCastException because Exception class is not
				//a subclass of Object class
				Object obj=(Exception)new Object();
				
			}
			
			catch(ClassCastException cce)
			{
				//handles ClassCastException
				System.out.println(cce);
			}
						
		//IllegalArgumentException			
		case 7:
			
			try
			{	
				//throws and IllegalArgumentException if the argument passed
				//is illegal.
				IllegalArgumentMethod(0);
			}
			
			catch(IllegalArgumentException iae)
			{
				//handles IllegalArgumentException
				System.out.println(iae);
			}
			
		//NumberFormatException	
		case 8:
			
			try
			{	//throws NumberFormatException when a string is tried to be
				//converted to integer
				String Test="hello";
				
				int number=Integer.parseInt(Test);
				
				System.out.println(number);
			}
			
			catch(NumberFormatException nfe)
			{
				//handles NumberFormatException
				System.out.println(nfe);
			}
			
		//IllegalThreadStateException	
		case 9:
			
			try
			{				
				Thread T=new Thread();
				T.start();
				//throws IllegalThreadStateException because a started thread is 
				//being tried to start again				 
				T.start();
			}
			
			catch(IllegalThreadStateException itse)
			{
				//handles IllegalThreadStateException
				System.out.println(itse);
			}
			
		//UnsupportedOperationException
		case 10:
			
			try
			{
				Set<Random> sample=new HashSet<Random>(10);
				Random rnum=new Random();
				for(int i=0;i<sample.size();i++)
				{
					sample.add(rnum);
				}
				
				Set<Random> unmodifiableSet =Collections.unmodifiableSet (sample);
				
				//throws UnsupportedOperationException because sample set
				//is being changed after setting it to unmodifiable
				unmodifiableSet.add(rnum);
						
			}
			catch(UnsupportedOperationException  usoe)
			{
				//handles UnsupportedOperationException
				System.out.println(usoe);
			}
			
			// checked Exceptions
			
		//ClassNotFoundException	
		case 11:
			
			try
			{	
				//throws ClassNotFoundException exception if the provided class
				//doesn't exist
				Class<?> load= Class.forName("java.Util.Collections");
				
			}
			
			catch(ClassNotFoundException cne)
			{
				//handles ClassNotFoundException
				System.out.println(cne);
			}
			
		//FileNotFoundException	
		case 12:
			
			try
			{
				@SuppressWarnings("resource")
				
				//throws FileNotFoundException when the input file provided
				//doesn't exist or cannot be read
				Scanner sc=new Scanner(new File("sample.txt"));
				while(sc.hasNext());
				System.out.println("found file");
				
				
			}
			
			catch(FileNotFoundException fnfe)
			{
				//handles FileNotFoundException
				System.out.println(fnfe);
			}
			
		//InstantiationException	
		case 13:
			
			try
			{
				Class<?> c= Class.forName("InstantiationEx");
				//throws InstantiationException because an abstract class is trying to be
				//Initialized here
				Object o=c.newInstance();
			}
			
			 catch (IllegalAccessException e) {
				
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				
				System.out.println(e);
			} catch (InstantiationException e) {
				//handles InstantiationException
				System.out.println(e);
			}
			
		//ParseException	
		case 14:
			
			DateformatEx df=new DateformatEx();
			df.dateFormatChecker();
		
		}
		
	}
}


//InstantiationEx is an abstract class
abstract class InstantiationEx
{
		/**
	     * InstantiationEx is just an empty method	            
	     */
	 
	 public InstantiationEx(int num)
	 {
		 
	 }
}
 
 //DateformatEx prints the date in the required format by the user
 class DateformatEx{
	 
	 public void dateFormatChecker()
	 {
	 try
	 {
		 SimpleDateFormat format= new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

	 String input="Sep 22, 2014 11:03 AM";//Mon Sep 22 23:53:43 EST 2014
	 	
	 	//throws ParseException because the provided date format doesn't
	 	//match with the format required
		 Date date=format.parse(input);
		 
		 System.out.println(date);
	 }
	 catch(ParseException pe)
	 {
		 //handles ParseException
		 System.out.println(pe);
	 }	 
	}
 }
 
 
 
 

 
