package carBidding;


public class bidding extends bidders
{
	static int round;
	bidder h[];
//	bidder maxBidder;
	
	public bidding() 
	{
		round = 1;
	}
	
	void bidPriorityQue(car c)
	{
		System.out.println("\nRound " +round++ +" -->\n");
		
		h = list.toArray(new bidder[list.size()]);
		
		for(int i = 0; i<list.size(); i++)
		{
			int flag = 0;
			do
			{
				flag = 0;
				System.out.print("\tBid by "+list.get(i).name +" : ");
				list.get(i).bid = sc.nextFloat();
				
				if((list.get(i).bid)==0)
				{
				}
				else
				{
					if(list.get(i).bid > list.get(i).budget)
					{
						System.out.println("The bid is greater than your budget\ntry again");
						flag = 1;
					}
					
					else if(list.get(i).bid<c.minBid)
					{
						System.out.println("The bid is lesser than minimum bid expected by car owner\ntry again");
						flag = 1;
					}
					
					else
					{
						for(int j=0; j<i; j++)
						{
							if(list.get(i).bid==list.get(j).bid)
							{
								System.out.println("Some one has already placed a bid of this amount!");
								System.out.println("Either enter a higher bid or enter bid value as 0");
								flag=1;
								break;
							}
						}
					}
				}
			}while(flag == 1);
		}
		
		int startIdx = (list.size() / 2) - 1; // Index of last non-leaf node 
		
		for (int i1 = startIdx; i1 >= 0; i1--) 
		{ 
			downAdjust(h, list.size(), i1); 
		} 
	}
	
	void downAdjust(bidder array[], int size, int i) 
	{ 
		int largest = i;    // Initialize current node as largest 
		int left = 2 * i + 1;   // position of left child in array = 2*i + 1 
		int right = 2 * i + 2;   // position of right child in array = 2*i + 2 

		if (left < size && array[left].bid > array[largest].bid)  // If left child is larger than root 
			largest = left; 

		if (right < size && array[right].bid > array[largest].bid) // If right child is larger than largest so far 
			largest = right; 

		if (largest != i) 
		{         // If largest is not root swap it 
			bidder swap = array[i]; 
			array[i] = array[largest]; 
			array[largest] = swap; 

			downAdjust(array, size, largest); // Recursively heapify the sub-tree 
		} 
	} 
	
	void deleteBidder()
	{
		int n = list.size();
		// Get the last element 
	    bidder k = h[n - 1]; 
	  
	    // Replace root with first element 
	    h[0] = k; 
	  
	    // Decrease size of heap by 1 
	    n = n - 1; 
	    
		downAdjust(h, n, 0);
		
	}
	
	void printHeap(bidder arr[], int n) 
	{ 
		System.out.println("\nBids for this round were: ");
		for (int i = 0; i < n; ++i) 
		{
			System.out.println("\t"+arr[i].name + ": "+arr[i].bid); 
		}
		System.out.println(); 
	} 
	
	bidder maximumBid()
	{
		return h[0];
	}
}
