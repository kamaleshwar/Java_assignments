/*
 *SortByCriteria.java
 *
 * Version:
 *     $Id: SortByCriteria.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


/**
 * This class sorts the list on the basis of criteria of the user
 */

class SortByCriteria implements MyComparator<User>{
	

	String name;
	int age;

/**
* This class sorts the list on the basis of age of the user
*/
	public static class SortByAge implements MyComparator<User>{		

		
		public int compare(User user1, User user2) {				
			
			return user1.age-user2.age ;
		}

	}

	/**
	 * This class sorts the list on the basis of name of the user
	 */

	public static class SortByName implements MyComparator<User>{

		public int compare(User user1, User user2) {
			
			return (user1.name.compareTo(user2.name));
		}
	}
	
	@Override
	public int compare(User user1, User user2) {
		
		return 0;
	} 
	
}
