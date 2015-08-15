/*
 *User.java
 *
 * Version:
 *     $Id: User.java,v 1.7 10/13/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


/**
 * This class initializes the user class variables
 */

public class User implements MyComparator<User>{

	String name;
	int  age;
	
	public User(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}	
	public int getAge() {
		return age;
	}
	
	public String toString(){
        return String.valueOf(age);
	}
	@Override
	public int compare(User o1, User o2) {			
		return 0;
	}	
	}
	
	
	

