/*
 *Items.java
 *
 * Version:
 *     $Id: Items.java,v 1.7 09/29/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */


public class Items {

	private String item_Name;
	private int item_Id;	
	private double item_quantity;
	
	//Declaring item price and item names
	private double items_Price_List[]={.50,.70,.70,.70,.33};	
	private String Item_List[]={"Apple","Flour","Kiwis","Oranges","Milk"};
	
	//empty constructor
	public Items(){}
	
	//initializing item details
	public Items(String name,int id,double quantity)
	{
		item_Name=name;
		item_Id=id;		
		item_quantity=quantity;		
	}
	
	public String getName()
	{	
		return item_Name;
	}
	
	public int getId()
	{
		return item_Id;
	}	
	
	public String getNameById(int id)
	{
		return Item_List[id];
	}
	
	public double getPrice(int id)
	{
		return items_Price_List[id];
	}
	
	public double getQuantity()
	{
		return item_quantity;
	}
	

	/**
	 * validItems method calculates the total amount of items
	 * 
	 * @param item
	 * 		Item to be checked if it is valid
	 * @return is_valid
	 * 		given item is valid or not
	 * 
	 */
	
	public boolean validItems(String item)
	{
		boolean is_valid=false;
		
		for(int i=0;i<Item_List.length;i++)
		{
			if(Item_List[i].equalsIgnoreCase(item))
			{
				is_valid=true;
			}
		}
		return is_valid;
	}
	

	/**
	 * DisplayItems method displays the available in the shop
	 * 
	 */
	
	public void DisplayItems()
	{
				
		for(int i=0;i<Item_List.length;i++)
		{			
			System.out.println(i+"-->"+Item_List[i]);			
		}		
	}
	

	/**
	 * autoFillItemId method returns id of the item by name
	 * 
	 * @param name
	 * 		name of the item of which id is to be found
	 * 
	 * @return
	 * 		returns id of the item
	 * 
	 */
	
	public int autoFillItemId(String name)
	{
		int Id=0;		
		for(int i=0;i<Item_List.length;i++)
		{			
			if(Item_List[i].equalsIgnoreCase(name))
			{
				Id=i;
			}			
		}	
		
		return Id;
	}
}
