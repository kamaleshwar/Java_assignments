/*
 *MyReverseComparator.java
 *
 * Version:
 *     $Id: MyReverseComparator.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

import java.util.Comparator;

/**
 * This class creates an instance of MyReverseComparator which will 
 * be useful while validating reverseOrder method
 */

public class MyReverseComparator<T> implements MyComparator<T>{

	public static final MyReverseComparator REVERSE_ORDER = new MyReverseComparator();

	@Override
	public int compare(T o1, T o2) {		
		return 0;
	}

}
