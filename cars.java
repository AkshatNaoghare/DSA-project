package carBidding;

import java.util.Scanner;

public class cars 
{
	int max;
	car carStore[];
	Scanner sc=new Scanner(System.in);
	
	public cars() 
	{
		max=15;
		carStore=new car[max];
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
		System.out.println("Enter license plate number of the car: (LLXXLLXXXX)");
		num=sc.next();
		System.out.println("Enter car brand: ");
		brand=sc.next();
		System.out.println("Enter car model name: ");
		model=sc.next();
		System.out.println("Enter original cost of the car: ");
		cost=sc.nextFloat();
		System.out.println("Enter minimum bid expectes by the owner for this car: ");
		bid=sc.nextFloat();
		
		car temp=new car(name,num,brand,model,cost,bid);
		
		int key=Integer.parseInt(num.substring(6,10));		//converts string to integer data type
		
		hash_add=(int)(key%max);
				
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
		System.out.println("Car Owner name: "+ptr.name);
		System.out.println("Car License Plate Number: "+ptr.licPNo);
		System.out.println("Car Brand name: "+ptr.brand);
		System.out.println("Car Model Name: "+ptr.modelName);
		System.out.println("Orinial cost of the car: "+ptr.originalCost);
		System.out.println("Minimum bid expected by owner: "+ptr.minBid);
	}
	
	void search(String str)		//str is license plate number of the car which is dequeued
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
			carStore[addr]=ptr;		//deletion successfull
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
	}
}
