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
	
	void bidPriorityQue()
	{
		System.out.println("round " +round++ +" -->");
		
		h = list.toArray(new bidder[list.size()]);
		
		for(int i = 0; i<list.size(); i++)
		{
			int flag = 0;
			do
			{
				flag = 0;
				System.out.print(list.get(i).name +" : ");
				list.get(i).bid = sc.nextFloat();
				
				if(list.get(i).bid > list.get(i).budget)
				{
					System.out.println("the bid is greater than your budget\ntry again");
					flag = 1;
				}
			}while(flag == 1);
		}
		
		int startIdx = (list.size() / 2) - 1; // Index of last non-leaf node 
		
		for (int i = startIdx; i >= 0; i--) 
		{ 
			downAdjust(h, list.size(), i); 
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
		
		for (int i = 0; i < n; ++i) 
		{
			System.out.print(arr[i].name + " "); 
		}
		System.out.println(); 
	} 
	
	bidder maximumBid()
	{
		return h[0];
	}
}
