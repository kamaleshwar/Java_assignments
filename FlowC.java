class FlowC
{
   int[] numbers = { 3, 5, 6, 1, 0, -1, 22, 14, 5, 9, 0, 1, -1 };

   static boolean trueIfZero(double n) {
	return n == 0.0;
   }
   static boolean greaterZero(double n) {
	return n > 0.0;
   }
   static double aDividedByN(double a, double b)      {
	return a / b;
   }

   static int test_1(int n)	{
	if ( ++n == 1 )
		return 1;
	else if ( n-- == 1 )
		return 2;
	else if ( --n == 0 )
		return 3;
	else
		return 4;
   }
   static int test_2(int n)	{
        n = -1;
	while ( n < 4 )	{
		if ( n-- == -1 )
		    n = 1;
		if ( ( n + 1 ) % 2 == 0 )
			n = 2;
		else if ( n == 3 )
			n = n++;
		n = n + n;
	}
	if ( ( n = 1 ) == 1 )
		n = 3;
	return n;
   }
   static int test_3(int a, int b)	{
	//my code:
	  return (a > b ? a : b);
	  
	  /*if ( a < b )
		return a;
	else
		return b;*/
   }
   static double test_4(double a, double b)	{
	if  (trueIfZero(a) ){
		System.out.println("Return of 1 If :");
		return aDividedByN(b , a );
	}
		
	if  (greaterZero(a) | trueIfZero(a) ){
		
		System.out.println("Return of 2 If :");
		return aDividedByN(b , a );
	}
	
	// The next if Can never be returned.
	// Because if greaterZero(a) is true, previous statement is always true
	// And it will be executed before the next if.
	
	if  (greaterZero(a) || trueIfZero(a) ){ 
		System.out.println("3");
		return aDividedByN(b , a );
	}
	
	//The next if statement is always false as a cannot be both 
	// greater than zero and zero at same time. And TRUE & FALSE is FALSE.
	
	if  (greaterZero(a) & trueIfZero(a) ){
	
		System.out.println("4");
		return aDividedByN(b , a );
	}
	
	// The next if Can never be returned.
	// Because if greaterZero(a) in true, 2nd if statement is always true
	// And it will be executed before the next if.
		
	if  (greaterZero(a) && trueIfZero(a) ){ 
		System.out.println("5");
		return aDividedByN(b , a );
	}
	if  (! greaterZero(a) && ! trueIfZero(a) ){
		System.out.println("Return of 6 If :");
		return aDividedByN(b , a );
	}
	
	// next if can never be returned because both 
	//greaterZero((int)a >>1 ) and trueIfZero(a) should be TRUE at same time
	//If trueIfZero(a) is TRUE then first if statement will be executed instead of next if.
	
	if  ( greaterZero((int)a >>1 ) && trueIfZero(a) ){
		System.out.println("7");
		return aDividedByN(b , a );
		

	// next if can never be returned because both 
	//greaterZero((int)a >>>1 ) and trueIfZero(a) should be TRUE at same time
	//If trueIfZero(a) is TRUE then first if statement will be executed instead of next if.
		
		
	}
	if  ( greaterZero((int)a >>>1 ) && trueIfZero(a) ){
		System.out.println("8");
		return aDividedByN(b , a );
	}
	
	//code added:
	
	else
		return(0);
   }


   public static void main(String args[])
   {  

	// a) create 4 statements so such test_1 returns all possible values
	// is it possible to get all 4 possible values?
	//Answer:  
	   /* Value 2 can never be returned because we can never get a case
	    * where the first if statement is false and the following else if
	    * condition is true because the value of n will be same in the elseif 
	    * condition which was compared to 1 in above if statement.
	    * so basically we are checking for the same value of n in if condition 
	    * and the following else if condition. So if condition is true it will 
	    * execute statements in if condition and skip following else if. 
	    * 
	    * So, 3 possible only not 4
	    */
	   
	 System.out.println("a:	test_1(0):	" + test_1(0) );
	 System.out.println("a:	test_1(1):	" + test_1(0) );
	 System.out.println("a:	test_1(1):	" + test_1(1) );
	 System.out.println("a:	test_1(4):	" + test_1(4) );
	 

	// b) explain the execution of test_2
	System.out.println("b:	test_2(2):	" + test_2(2) );
	//Answer:
	/*First n is passed as equal to 2:  n=2
	 * Value of n is assigned as -1  :  n=-1
	 * Enters while loop as n<4
	 * In First if n-- == -1 is True, n is assigned value n=1 : n=1
	 * In second if condition holds true n is assigned value  : n=2
	 * else if condition is not checked
	 * n=n+n implies n=2+2 : n=4
	 * checks while condition n<4 False Exits while loop
	 * n is assigned value 1 and compared to 1 which is True.
	 * So, n is assigned value 3 and returned. : n=3 returned.
	 * 3 is printed.
	 */
	

	// c) simplify test_3 by using a ?: statement
	//Answer:
	System.out.println("c:	test_3(2, 2):	" + test_3(2, 2) );
	
	
	// d) find the minimum of all numbers in number by using one for loop
	//Answer:	 
	 FlowC Min = new FlowC();
	 int minimum = Min.numbers[0];
	 for(int i=0; i <  Min.numbers.length; i++ ){
		 
		 minimum = minimum < Min.numbers[i] ? minimum : Min.numbers[i] ;
	 }
	 System.out.println("d:	Minimum:	" + minimum);
	 
	
	// e) test_4 will not compile, why? Fix it?
	// create a/b pairs, so such all return statements are executed
	// is it possible to execute all  return statements.
	 
	//Answer;
	 /*test_4 will not compile because it is expecting double value in 
	  * return. But there is no definitive return statement because
	  * return statements executed if and only if any of the if 
	  * statements is true.
	  * To remove the error include a return statement in else which returns
	  * a double value if none of if conditions are true.
	  *
	  * All return values are not possible.
	  * For explanation see near if statements comments
	  * 
	  * Possible returns executed below.
	  */
	 
	 System.out.println("e1:	test_4(0, 1):	" + test_4(0, 1) );
	 System.out.println("e2:	test_4(1, 1):	" + test_4(1, 1) );
	 System.out.println("e6:	test_4(2, 2):	" + test_4(-1, 1) );
	 
	

   }
}
