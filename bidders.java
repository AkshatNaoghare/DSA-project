package carBidding;

import java.util.Scanner;

public class bidders 
{
	bidder root;
	int count;

	Scanner sc  = new Scanner(System.in);
	
	public bidders()
	{
		root = null;
		count  = 0;
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

}
 