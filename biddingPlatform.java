package carBidding;

public class biddingPlatform extends bidding
{
	public biddingPlatform() 
	{

	}
	
	void rounds()
	{
		char ch;
		
		bidder maxBidder = maximumBid();
		
		if(round <= 3)
		{
			System.out.println("continue rounds? (y/n)");
			
			if(sc.next().charAt(0) == 'y')
			{
				bidPriorityQue();
			}
			else
			{
				sellCar(maxBidder);
				deleteBidder();
//				printHeap(h, list.size()-1);
			}
		}
		
		
	}
	
	void sellCar(bidder maxBidder)
	{
		System.out.println(maxBidder.bid);
		System.out.println(maximumBid().bid);
		
		if(maxBidder.bid >= maximumBid().bid)
		{
			System.out.println("car is sold to " +maxBidder.name);
		}
		else
		{
			System.out.println("car is sold to " +maximumBid().name);
		}
	}

}
