/*
 *Receipt.java
 *
 * Version:
 *     $Id: Receipt.java,v 1.7 09/29/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program takes the cart and bag as inputs and prepares a cumulative list
 * and calculates the total bill amount
 */



public class Receipt {

	
	private int cus_id;
	private double total_price;
	
	//declaring array preparing cumulative list
	private static int cumList[]=new int[5];
	Items Items_details=new Items();
	
	public Receipt(int id)
	{
		cus_id=id;
	}

	/**
	 * CumList method prepares the cumulative list of items
	 *
	 * cart[][] 
	 *            contains list of items added to cart
	 * bag[][] 
	 *            contains list of items added to bag	
	 *
	 * @return void
	 * 
	 */
	public void CumList(Items cart[][],Items bag[][])
	{
		//initializing objects for cart and bag.
		Cart my_cart=new Cart();
		Bag my_bag=new Bag();
		
		if(my_cart.getCartQuantity()>0)
		{
		for(int i=0;i<my_cart.getNumberOfCarts();i++)
		{				
			if(i==0)
			{
				for(int j=0;j<my_cart.checkCartLimit1();j++)
				{
					cumList[cart[i][j].getId()]+=cart[i][j].getQuantity();
								
				}
			}
			
			else
			{
				for(int k=0;k<my_cart.checkCartLimit2();k++)
				{
					cumList[cart[i][k].getId()]+=cart[i][k].getQuantity();
								
				}
			}
		}
		}
		
		if(my_bag.getBagQuantity()>0)
		{
			
		for(int i=0;i<my_bag.getNumberOfBags();i++)
		{				
			if(i==0)
			{	
				for(int j=0;j<my_bag.checkBagLimit1();j++)
				{
					cumList[bag[i][j].getId()]+=+bag[i][j].getQuantity();
					
				}
			}
			if(i==1)
			{
				for(int k=0;k<my_bag.checkBagLimit2();k++)
				{
				
					cumList[bag[i][k].getId()]+=bag[i][k].getQuantity();
				}
			}	
			if(i==2)
			{		
				for(int l=0;l<my_bag.checkBagLimit3();l++)
				{			
					cumList[bag[i][l].getId()]+=bag[i][l].getQuantity();
				
				}
		
			}
		}		
	}
	}

	/**
	 * getMyReceipt method calculates the total amount of items
	 * 
	 * @return total_price
	 * 
	 */
	
	public double getMyReceipt(){
		
	System.out.println("CustomerId:"+cus_id);
			System.out.println("------------------");
			for(int i=0;i<5;i++)
			{	
				if(cumList[i]>0){				
				System.out.println(Items_details.getNameById(i)+" "+cumList[i]+" "+"("+Items_details.getPrice(i)+")");
				total_price=cumList[i]*Items_details.getPrice(i);
			}
		}
		return total_price;
		
		
	}
	

	/**
	 * removeFromBill method subtracts the quantity from the total of each item
	 * 
	 * @param name
	 * 		name of the item to be removed
	 * 
	 * @param quantity
	 *		quantity to be removed  
	 * 
	 * 
	 */
	
	public void removeFromBill(String name,int quantity)
	{	
		if(cumList[Items_details.autoFillItemId(name)]>quantity && quantity>0)
		{
		cumList[Items_details.autoFillItemId(name)]-=quantity;
		System.out.println("Successfully Removed");
		}
		
		else
		{
			System.out.println("Invalid quantity");
		}
	}
}
	
