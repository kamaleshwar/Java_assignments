/*
 *Requirement2.java
 *
 * Version:
 *     $Id: Requirement2.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * This class adds 1000 random numbers ignoring duplicates and
 * does some basic operations on set like add,remove,contains  
 */

public class Requirement2
{
	public static void main(String args[]) 
	{
		int counter=1;
		Random randNum=new Random();		
		Set<Integer> unSortedSet=new HashSet<Integer>();		
		
		//adding elements
	
		while(counter<=1000)
		{			
			if(unSortedSet.add(randNum.nextInt(10000)+1))
			{
				counter++;
			}			
			
		}			
				
		System.out.println("Elemets in set after add: "+unSortedSet);		
		
		Object[] array=unSortedSet.toArray();
		
		//check for elements
		
		int lengthOfSet1=array.length-1;
		
		int ElementsInSet=0;
		
		//counts the number of matched elements in set
		
		while(lengthOfSet1>=0) 
		{		
			
			if(unSortedSet.contains(array[lengthOfSet1]))
			{
				ElementsInSet++;	
			}
			lengthOfSet1--;
		}		

		System.out.println("Number of elements in set: "+unSortedSet.size());
		System.out.println("Number of matched elements in set: "+ElementsInSet);		
		
		//remove elements
		
		int lengthOfSet2=array.length-1;
		
		//removes all the elements in the set
		
		while(lengthOfSet2>=0)
		{			
			unSortedSet.remove(array[lengthOfSet2]);
			lengthOfSet2--;			
		}
		System.out.println("Elemets in set after remove: "+unSortedSet);			

 	}

}





