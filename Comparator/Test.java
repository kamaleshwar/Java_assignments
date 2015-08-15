/*
 *Test.java
 *
 * Version:
 *     $Id: Test.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


import java.util.ArrayList;
import java.util.List;

/**
 * This class tests the functionalities of YourCollections
 */

public class Test {

	public static void main(String args[])
	{		
		List test=new ArrayList();
		test.add("1");
		test.add("ab");
		test.add(50);
		test.add(12);
		test.add("Kamal");
		test.add("15");
		
		System.out.println("Before shuffle: "+test);
		
		YourCollections.shuffle(test);
		
		System.out.println("After shuffle: "+test);
		
		YourCollections.sort(test);
		
		System.out.println("After sort: "+test);
		
		//Test sort using comparator		
		User user1=new User("Wayne",26);		
		User user2=new User("Bruce",30);		
		User user3=new User("Kamal",25);
		
		List<User> mylist=new ArrayList();
		
		mylist.add(user2);
		mylist.add(user3);
		mylist.add(user1);	
		
		YourCollections.sort(mylist, new SortByCriteria.SortByName());
		
		System.out.println("After Sort by Name: ");
		for(User element:mylist)
		{
			System.out.println(element.getName()+"-->"+element.getAge());
		}
		
		YourCollections.sort(mylist, new SortByCriteria.SortByAge());
		
		System.out.println("After Sort by age :");
		for(User element:mylist)
		{
			System.out.println(element.getAge()+"-->"+element.getName());
		}	
		
		YourCollections.sort(mylist,YourCollections.reverseOrder());
		
		System.out.println("After Reverse Sort: ");
		for(User element:mylist)
		{
			System.out.println(element.getAge()+"-->"+element.getName());
		}		
		
	} 
}
