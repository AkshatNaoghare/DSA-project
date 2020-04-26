package carBidding;

import java.util.Scanner;

import java.util.regex.Pattern;

public class cars 
{
	car select;
	static int index;
	int max;
	car carStore[];
	Scanner sc=new Scanner(System.in);
	
	public cars() 
	{
		index=0;
		max=15;
		carStore=new car[max];
		select=carStore[index];
	}
	
	void insert()
	{
		String name;
		String num;	
		String brand;
		String model;
		float cost;	
		float bid;	
		int hash_add;
		
		System.out.println("Enter car Owner Name: ");
		name=sc.next();
		
		int flag=0;
		System.out.println("Enter license plate number of the car: (LL-XXX-LLL-XXXX)");
		do
		{
			flag=0;
			num=sc.next();
			
			if(validator(num))
			{
			}
			else
			{
				System.out.println("Invalid format of License plate number! Enter in (LL-XXX-LLL-XXXX) format:");
				flag=1;
			}
			
		}while(flag==1);

		System.out.println("Enter car brand: ");
		brand=sc.next();
		System.out.println("Enter car model name: ");
		model=sc.next();
		System.out.println("Enter original cost of the car: ");
		cost=sc.nextFloat();
		System.out.println("Enter minimum bid expectes by the owner for this car: ");
		bid=sc.nextFloat();
		
		car temp=new car(name,num,brand,model,cost,bid);
		
		int key=Integer.parseInt(num.substring(11));		//converts string to integer data type
		
		hash_add=(key%max);
				
		if(carStore[hash_add]==null)
		{
			carStore[hash_add]=temp;
		}
		else
		{
			car add=carStore[hash_add];
			while(add.next!=null)		
			{
				add=add.next;				
			}
			add.next=temp;
		}
	}
	
	void display(car ptr)
	{
		System.out.println("\n\tCar Brand name: "+ptr.brand);
		System.out.println("\tCar Model Name: "+ptr.modelName);
		System.out.println("\tCar Owner name: "+ptr.name);
		System.out.println("\tCar License Plate Number: "+ptr.licPNo);
		
		if(ptr.soldprice==0)
		{
			System.out.println("\tOriginal cost of the car-->"+ptr.originalCost);
			System.out.println("\tMinimum bid expected by owner-->"+ptr.minBid);
		}
		else
		{
			System.out.println("\tCar sold at a price of-->"+ptr.soldprice);
			System.out.println("\tTo-->"+ptr.buyer);
		}
		
	}
	
	/*void search(String str)		//str is license plate number of the car which is dequeued
	{
		int flag=0;
		
		int key=Integer.parseInt(str.substring(6,10));
		int addr=(int)(key%max);
		
		car ptr=carStore[addr];
		while(ptr!=null)
		{
			if(ptr.licPNo==str)
			{
				display(ptr);
				flag=1;
			}
			ptr=ptr.next;
		}
		
		if(flag==0)
		{
			System.out.println("No such Car available!");
		}
	}
	
	void delete(String str)
	{
		int key=Integer.parseInt(str.substring(6,10));
		int addr=(int)(key%max);
		
		car ptr=carStore[addr].next;
		car prev=carStore[addr];
		
		if(prev.licPNo==str)
		{
			prev.next=null;
			carStore[addr]=ptr;		//deletion successful
		}
		else
		{
			while(ptr.licPNo!=str)
			{
				prev=ptr;
				ptr=ptr.next;
				
				if(ptr.licPNo==str)
				{
					break;
				}
			}
			
			if(ptr.licPNo==str)
			{
				prev.next=ptr.next;
				ptr.next=null;			//deletion successful
			}
		}
	}*/
	
	car select()
	{
//		car current=null;
//
//		while(select==null)			//if the node in the hash table is empty(null)
//		{
//			index++;		//inc head
//			select=carStore[index];		//we move to next head
//		}
//		
//		if(select!=null)
//		{
//			current=select;
//			select=select.next;
//		}
//		return current;
		
		car current = null;
		int flag = 0;
		
		
		
		
		if(index<max)
		{
			do
			{
				flag = 0;
				if(carStore[index] != null)
				{
					current = carStore[index++];
					
					while(current.next != null)	
					{
						if(!current.sold)
						{
							break;
						}
						else
						{
							current = current.next;
						}
					}
				}
				else
				{
					index++;
					flag = 1;
				}
			}while(flag == 1);
		}
		else
		{
			index = 0;
		}
		
		return current;
	}
	
	boolean validator(String lpn)
	{
		int len = lpn.length();
		boolean validLength = len>=10;
		
		if(!validLength)
		{
			return false;
		}
		
		boolean rightAns = Pattern.compile("^[A-Z a-z]{1,2}-[0-9]{1,3}-[A-Z a-z]{1,3}-[0-9]{1,4}$").matcher(lpn).find();
		
		if(!rightAns)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
