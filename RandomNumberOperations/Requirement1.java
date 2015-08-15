/*
 *Requirement1.java
 *
 * Version:
 *     $Id: Requirement1.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class adds 1000 random numbers ignoring duplicates and then sorts
 * the elements in their natural ordering  
 */

public class Requirement1 {
	
	public static void main(String args[]) 
	{
		int counter=0;
		Random randNum=new Random();
		Set<Integer> unSortedSet=new HashSet<Integer>();
		
		//iterates until set has 1000 elements
		while(counter<1000)
		{	
			//generates random number until 1000
			int nextNum=randNum.nextInt(1000)+1;
			if(nextNum>0)
			{
			unSortedSet.add(nextNum);
			counter=unSortedSet.size();			
			}
			
		}
		//Adding HashSet to TreeSet to sort the elements
		TreeSet SortedSet=new TreeSet(unSortedSet);
		System.out.println("Number of elements stored: \n"+SortedSet.size());
		System.out.println("Random numbers before sorting: \n"+unSortedSet);		
		System.out.println("Random numbers after sorting: \n"+SortedSet);
 	}		
	
}


