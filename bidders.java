package carBidding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bidders 
{
	bidder root;
	int count, max_level;
	bidder head, t;
	int size_of_queue = 5, c = 0;

	Scanner sc  = new Scanner(System.in);
	
	LinkedList<bidder> que = new LinkedList<bidder>();
	
	public bidders()
	{
		root = null;
		count  = 0;
	}
	
	void waiting(bidder d)
	{
		que.add(d);
	}
	
	void delete(bidder d)
	{
		que.remove(d);
	}
	
	void display()
	{
		for(int i = 0 ; i<que.size() ; i++)
		{
			que.get(i).display();
		}
	}
	
	public void create()
	{							//creates a BST
		int flag = 0;
		bidder ptr = null;
		String name = null;
		float bdgt = 0.0f;
		
		System.out.println("enter name: ");
		name = sc.next();
		
		System.out.println("enter budget: ");
		bdgt = sc.nextFloat();
		
		bidder temp = new bidder(name, bdgt);
		
		if(root == null)
		{						//creating the first node i.e. the root
			root = temp;
		}
		else
		{
			ptr = root;			//ptr is a pointer to traverse the tree
			
			while(flag == 0)
			{
				if(temp.budget < ptr.budget)			//if the data input is less than the root is added on the left side of the tree
				{
					if(ptr.left == null)
					{
						ptr.left = temp;
						flag = 1;
					}
					else
					{
						ptr = ptr.left;
					}
				}
				else if(temp.budget > ptr.budget)		//if the data input is greater than the root is added on the right side of the tree
				{
					if(ptr.right == null)
					{
						ptr.right = temp;
						flag = 1;
					}
					else
					{
						ptr = ptr.right;
					}
				}
				else
				{
					System.out.println("duplicate data not allowed");
					flag = 1;
				}
			}
		}
	}
	
	public bidder search()							//returns address of the value input
	{
		bidder ptr = null;
		bidder addr = null;
		float bdgt = 0.0f;
		
		System.out.println("enter budget: ");
		bdgt = sc.nextFloat();
		
		ptr = root;
		
		while(ptr != null)
		{
			if(bdgt == ptr.budget)
			{
				return ptr;
			}
			else if(bdgt < ptr.budget)
			{
				ptr = ptr.left;
			}
			else
			{
				ptr = ptr.right;
			}
		}
		addr = ptr;
		
		return addr;
	}
	
	void waitingList(bidder r)							
	{
        waiting(r);
        waitingListt(r.left);
   	}
	
	void waitingListt(bidder r)
	{
		if(r == null)
		{
			return;
		}
		else
		{
			waitingListt(r.left);
			waiting(r);
			waitingListt(r.right);
		}
	}
}
 
