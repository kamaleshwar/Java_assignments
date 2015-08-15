/*
 *YourCollections.java
 *
 * Version:
 *     $Id: YourCollections.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
 
/**
 * This class implements the functionalities of sort and shuffle methods
 */

public class YourCollections<T>{
	

	/**
	 * shuffle method shuffles the elements in the list
	 * 
	 * @param list
	 * 		List to be shuffled
	 *   
	 */
	
	public static <T> void shuffle(List <T> list)
	{
		Random rand=new Random();
		List randNum=new ArrayList();
		List<T> temp=new ArrayList<T>(list);
		int counter=0;
		int limit=list.size()-1;
		
		while(limit>=0)
		{
			int randnum=rand.nextInt(list.size());
			if(randNum.isEmpty())
			{
				randNum.add(randnum);
				limit--;
			}
			
			if(!randNum.contains(randnum))
			{
				randNum.add(randnum);
				limit--;
			}			
			
		}
		
		Iterator it=randNum.iterator();
		
		while(it.hasNext())
		{
			list.set((int) it.next() , temp.get(counter));
			counter++;
		}	
		
	} 
	

	/**
	 * sort(list) method sorts the elements in the list
	 * 			   in the natural ordering
	 *  
	 * @param list
	 * 		List to be sorted
	 *   
	 */
	
	 public static <T extends MyComparator> void sort(List<T> list)
		{
			Object[] array=list.toArray();
			array= bubbleSort(array,null);	
			List temp=Arrays.asList(array);
			list.clear();
			list.addAll(temp);	
		}
	 

	/**
	 * sort(list,c) method sorts the elements in the list
	 * 			   in the user defined ordering
	 *  
	 * @param list
	 * 		List to be sorted
	 * 
	 * @param c
	 * 		user defined ordering
	 *   
	 */
	 
	public static <T extends MyComparator> void sort(List<T> list, MyComparator<? super T> c)
	{
		if(c==null)
		{
			//natural ordering
			sort(list);
		}
		
		else
		{			
			Object[] array=list.toArray();			
			array= bubbleSort(array,c);
			List temp=Arrays.asList(array);
			list.clear();
			list.addAll(temp);
		}
		
	}	
	 

	/**
	 * bubbleSort method sorts the elements in the list	 		   
	 *  
	 * @param array
	 * 		array to be sorted
	 * 
	 * @param c
	 * 		user defined ordering
	 *   
	 */	
	private static Object[] bubbleSort(Object[] array,MyComparator c) {
		
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(c!=null)
				{	
					//sort in descending order
					if(c instanceof MyReverseComparator )
					{					
						if(array[j].toString().compareTo(array[j+1].toString())<0)
						{							
							array=swap(array,j);					
						}					
					}
					else
					{	//user defined ordering
						if(c.compare(array[j], array[j+1])>0)
						{
							array=swap(array,j);
						}	
					}			
					
				}
				else
				{	//natural ordering
					if(array[j].toString().compareTo(array[j+1].toString())>0)
					{
						array=swap(array,j);
					}
				}
			}
		}
		
		return array;
	}
	
	/**
	 * swap method swaps tow elements in the array 			   
	 *  
	 * @param array
	 * 		array whose elements need to be swapped
	 * 
	 * @param j
	 * 		element which needs to be swapped with the next element
	 *   
	 */	
	
	public static Object[] swap(Object[] array,int j)
	{
		Object temp=array[j];
		array[j]=array[j+1];
		array[j+1]=temp;
		
		return array;
	}
	
	/**
	 * reverseOrder method returns the instance of MyReverseComparator			   
	 *    
	 */
	
	public static <T> MyComparator<T> reverseOrder() {
        return MyReverseComparator.REVERSE_ORDER;
    }
	
}	
