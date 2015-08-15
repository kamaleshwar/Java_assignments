
/*
 *Customer.java
 *
 * Version:
 *     $Id: Customer.java,v 1.7 09/29/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/**
 * This program takes input from user and to add items to cart or bag 
 * and then allows user to modify the added items to print the final
 * receipt   
 */


import java.util.Random;
import java.util.Scanner;

public class Customer {

	//declaring variables to read customer details
	private String Cus_name;
	private int Cus_Id;
	
	//declaring carts and bags that are to be filled later.
	private Items my_cart[][];
	private Items my_bag[][];
	
	//variable used to limit the number of objects purchased
	private static int max_items=0;	
	
	//declaring a flag to check shopping is done or not
	private static boolean shopFlag=false; //
	
	//constructor initializing the carts and bags and customer details.
	public Customer(String name,int id)
	{
		my_cart=new Items[2][50];
		my_bag=new Items[3][20];
		Cus_name=name;
		Cus_Id=id;
	}
	
	public Items[][] myCart()
	{
		return my_cart;
	}
	
	public Items[][] mybag()
	{
		return my_bag;
	}
	
	public static void main(String args[])
	{
		
		//initializing objects 
		Cart my_cart=new Cart();
		Bag my_bag=new Bag();
		Scanner sc=new Scanner(System.in);
		Random number=new Random();
		Items val_Items=new Items();		
		
		
		System.out.println("Welcome");
		System.out.println("--------------------");
		System.out.println("Enter your name:");
		String cus_name=sc.next();				
		int cus_id=number.nextInt(10000)+1;
		System.out.println("your Cus_id is:"+cus_id);
		System.out.println("--------------------");
		Customer cus=new Customer(cus_name,cus_id);
		Receipt my_receipt=new Receipt(cus.Cus_Id);
		
		while(true)
		{
			System.out.println("Menu");
			System.out.println("--------------------");
			System.out.println("Select 0 to proceed to shopping");
			System.out.println("Select 1 to modify Items List");
			System.out.println("Select 2 to for billing");
			System.out.println("Select 3 to exit without buying");
			System.out.println("--------------------");
			int choice=sc.nextInt();
			switch(choice)
			{		
			
			
			case 0:
				
				System.out.println("Add Items to your Cart or Bag");
				System.out.println("--------------------");
				val_Items.DisplayItems();
				boolean proceed=true;
				String CartorBag;
				while(proceed)
				{				
					System.out.println("Enter Item Name:");
					String Item_Name=sc.next();					
					if(val_Items.validItems(Item_Name))
					{
					System.out.println("Product Id :");
					int Item_Id=val_Items.autoFillItemId(Item_Name);
					System.out.println(Item_Id);
					System.out.println();
					System.out.println("Enter quantity up to 20 at once:");					
					int Item_Quantity=sc.nextInt();
					
					if(Item_Quantity>0 && Item_Quantity<=20)
					{
						max_items+=Item_Quantity;
						System.out.println("Select B for Bag C for Cart");
						CartorBag=sc.next();
						if(CartorBag.equalsIgnoreCase("C"))
							{
								if(max_items<=100){
								my_cart.addItem(cus.myCart(),
										Item_Name,Item_Id,Item_Quantity);
								}else{
									System.out.println("Too many Items");	
								}
									
							}
						else
						{
							if(max_items<=100){
							my_bag.addItem(cus.mybag(),
									Item_Name,Item_Id,Item_Quantity);
							}else{
								System.out.println("Too many Items");
							}
						}
												
					}
					else
					{											
						while(Item_Quantity<=0)
						{	
							System.out.println("Enter Valid quantity");
							Item_Quantity=sc.nextInt();
						}
						System.out.println("Select B for Bag C for Cart");
						CartorBag=sc.next();
						if(CartorBag.equalsIgnoreCase("C"))
						{
						my_cart.addItem(cus.myCart(),
								Item_Name,Item_Id,Item_Quantity);
						}
						
						else
						{						
							my_bag.addItem(cus.mybag(),
									Item_Name,Item_Id,Item_Quantity);
							
						}
					}
					System.out.println("press 0 to add further");
					System.out.println();
					System.out.println("press 1 to finish");
					int decision=sc.nextInt();
					if(decision==0)
					{	
						proceed=true;
					}
					if(decision==1)
					{
						proceed=false;
					}
					if(decision!=0 && decision!=1)
					{
						System.out.println("invalid Input");
					}
				}
					else{
						System.out.println("Select Valid Item");
						System.out.println();
					}
					
			}
				my_receipt.CumList(cus.myCart(),cus.my_bag);
				shopFlag=true;
				break;	
				
			case 1:
				
					System.out.println("Enter product name");
					String name=sc.next();
					if(val_Items.validItems(name))
					{
					System.out.println("Enter quantity");
					int quantity=sc.nextInt();
					my_receipt.removeFromBill(name,quantity);					
				}else{
					System.out.println("Invalid Item");
				}
					break;
			case 2:
				if(shopFlag)
				{
				System.out.println("Receipt :");					
				double total_price=my_receipt.getMyReceipt();				
				System.out.println("--------------------");
				System.out.println("cost: " +total_price);
				System.exit(0);
				}
				else
				{
					System.out.println("Cannot give Receipt with out shopping");
					System.out.println();
				}
				break;
			case 3:
				System.out.println("Thank you");
				System.exit(0);
				
			default:
				System.out.println("Invalid option");	
			}			
			
		}	
		
	}	

}
