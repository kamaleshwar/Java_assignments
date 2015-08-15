/*
 * palindrome.java
 *
 * Version:
 *     $Id: palindrome.java,v 1.7 09/16/2014 $
 * 
 * Authors: Raj & Kamaleshwar(Id:kp2601)
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program prints the number of palindromes present in the input file.
 */

import java.util.Scanner;
import java.io.File;

public class Palindrome {
    public static void main( String[] args ) {
	try {
		int palindrome_count=0;	
		
		//Read the given input file
		
		Scanner sc  = new Scanner( new File("palindrome.txt"));
		
		while ( sc.hasNext() )	{
			String line = sc.nextLine();
			
			System.out.println(line);// your code goes here
			
			Palindrome palindrome_string=new Palindrome();	
			
			//iterates through each line and counts
			//the number of palindromes present in the line.
			
			for(int counter1=0;counter1<=line.length();counter1++)
			{
				for(int counter2=counter1+1;counter2<=line.length();counter2++)
				{	
					
					String original=line.substring(counter1,counter2);
					
					String reverse=palindrome_string.reverseString(original);					
					
					if(original.equalsIgnoreCase(reverse) && reverse.length()>2)
					{	
						palindrome_count++;
						
					}   
				}
			}			
    }
		System.out.println();
		
		System.out.println("Total number of palindromes: "+palindrome_count);
		sc.close();
	} catch ( Exception e )	{
		System.err.println("Something went wrong!");
	}
    }
    
    /**
	 * reverseString method takes an original string as parameter and 
	 * returns the reverse of it. 
	 *
	 *
	 * @param original
	 *            original string passed for reversing
	 *
	 * @return returns the reversed string of the original string passed
	 * 
	 */
      
public String reverseString(String original)
{	
	String reverse="";
	
	for(int counter=original.length()-1;counter>=0;counter--)
	{
		reverse+=original.charAt(counter);
		
	}
	return reverse;
}
}
