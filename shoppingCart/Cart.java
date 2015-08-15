/*
 *Cart.java
 *
 * Version:
 *     $Id: Cart.java,v 1.7 09/29/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


public class Cart {

	//declaring cart variables
	private static int cart_quantity=0;	
	private int counter=0;
	private double total_price;
	private static int total_carts=1;	
	private static int Item_count1=0;
	private static int Item_count2=0;
	
	/**
	 * addItem method adds the items to bag
	 * 
	 * @param cart[][]
	 * 		Items to be added to the cart
	 * 
	 * @param name
	 * 		name of the item to be added
	 * 
	 * @param id
	 * 		Id of the Items to be added 
	 * 
	 * @param quantity
	 * 		quantity of Items to be added
	 *  
	 */
	
	public void addItem(Items cart[][],String name,int id,double quantity)
	{
		
		Items item=new Items(name,id,quantity);		
		
		cart_quantity+=quantity;
		
		if(cart_quantity<=50)
		{	
			cart[counter][Item_count1]=item;
			Item_count1+=1;
			
		}
		else{
		
			cart[++counter][Item_count2]=item;			
			Item_count2+=1;
			
		}
		
		if(counter>0){
			
			total_carts+=1;
			
		}
		
	}
	
	public int getCartQuantity()
	{
		return cart_quantity;
	}
	
	public int getNumberOfCarts()
	{
		return total_carts;
	}

	public int checkCartLimit1()
	{
		return Item_count1;
	}
	
	public int checkCartLimit2()
	{
		return Item_count2;
	}
}
