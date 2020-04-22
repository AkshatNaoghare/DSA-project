package carBidding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bidders 
{
	bidder root;
	int count;
	bidder head, t;
	int size_of_queue = 5, c = 0;

	Scanner sc  = new Scanner(System.in);
	
	public bidders()
	{
		root = null;
		count  = 0;
	}
	
	int isfull()
	{
		if(c == size_of_queue)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	int isempty()
	{
		if (head == null)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
	void waiting(bidder d)
	{
		if(isfull() == 0)
		{
			if(head == null)
			{
				head = t = d;
			}
			else
			{
				t.link = d;
				t = d;
			}
		}
		else
		{
			System.out.println("waiting list is full");
		}
		c++;
	}
	
	void display()
	{
		bidder temp = null;
		
		temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.name+" ");
			temp = temp.link;
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
	
	void level_order(bidder r)								//print nodes level-wise
	{
		Queue<bidder> q = new LinkedList<bidder>();
		bidder ptr;
		int i = 1;
		
		if(r == null)
		{
			return;
		}
		else
		{
			q.add(r);
			q.add(null);
			
			while(!(q.isEmpty()))
			{
				ptr = (bidder)q.remove();
				if(ptr == null)
				{
					if(!q.isEmpty())
					{
						q.add(null);
						System.out.println("level "+i++);
					}
				}
				else
				{
					if(ptr.left!=null)
					{
						q.add(ptr.left);
					}
					if(ptr.right!=null)
					{
						q.add(ptr.right);
					}
					waiting(ptr);
				}
			}
		}
		
	}

}
 
