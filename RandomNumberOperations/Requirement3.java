/*
 * Requirement3.java
 *
 * Version:
 *     $Id: Requirement3.java,v 1.7 10/13/2014 $
 * 
 * Authors: Raj & Kamaleshwar
 *
 * Revisions:
 *     $Log$
 */

/**
 *Store 1000 random generated numbers.
 *Requirement 2: Duplicate numbers are not ignored;
 *constant time performance for the basic operation;
 *Using classes from collection framework.
 */

import java.util.HashMap;
import java.util.Random;

class Requirement3 {
    
	/**Method randomHashMap()
	 * Generates 1000 random integers and
	 * stores them as sorted Hash Map collection.
	 * @param  Null
	 * @return void  
	 */
	public static void randomHashMap() {
		//Creating a HashMap for storing Integers.
		//key--integer,value--integer.
		HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
		Random random = new Random();
		int mykey = 0;

		while (myHashMap.size() < 1000) {
			//mapping keys to corresponding to random values.
			myHashMap.put(mykey, random.nextInt());
			mykey++;
		}
		//output
		System.out.print(myHashMap.values());
		//checking the HashMap size.
		System.out.println(myHashMap.size());

	}

	public static void main(String[] args) {

		randomHashMap();

	}

}
