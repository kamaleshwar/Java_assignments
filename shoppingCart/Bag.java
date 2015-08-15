/*
 *Bag.java
 *
 * Version:
 *     $Id: Bag.java,v 1.7 09/29/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


public class Bag {
	
	//declaring bag variables
	private static int Bag_Quantity=0;	
	private static int  Item_Count1=0;
	private static int  Item_Count2=0;
	private static int Bag_Count=1;
	private static int Item_Count3=0;
	private static int counter=0;
	

	/**
	 * addItem method adds the items to bag
	 * 
	 * @param bag[][]
	 * 		Items to be added to the bag
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
	
	public void addItem(Items bag[][],String name,int id,double quantity)
	{
		Items item=new Items(name,id,quantity);		
			
		Bag_Quantity+=quantity;
		
		if(Bag_Quantity<=20)
		{	
			bag[counter][Item_Count1]=item;
			Item_Count1+=1;
			
		}
		if(Bag_Quantity>20 && Bag_Quantity<=40)
		{
			bag[++counter][Item_Count2]=item;			
			Item_Count2+=1;
			
		}
		
		if(Bag_Quantity>40 && Bag_Quantity<=60){
			bag[++counter][Item_Count3]=item;			
			Item_Count3+=1;
			
		}
		
		if(counter>0){
			
			Bag_Count+=1;
			
		}
		if(Bag_Quantity>60 )
		{
			System.out.println("Max limit for bag exceeded");
			System.out.println("Please add it to the cart");
			
		}
		
		Bag_Count=counter+1;
	}

	public int getBagQuantity()
	{
		return Bag_Quantity;
	}
	
	public int getNumberOfBags()
	{
		return Bag_Count;
	}

	public int checkBagLimit1()
	{
		return Item_Count1;
	}
	
	public int checkBagLimit2()
	{
		return Item_Count2;
	}

	public int checkBagLimit3()
	{
		return Item_Count3;
	}

	}

