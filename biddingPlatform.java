package carBidding;

import java.util.ArrayList;

public class biddingPlatform extends bidding
{
	public biddingPlatform() 
	{

	}
	
	void rounds(car c)
	{
		char ch;
		
		bidder maxBidder = maximumBid();
		
		/*System.out.println("continue rounds? (y/n)");
		
		if(sc.next().charAt(0) == 'y')
		{
			bidPriorityQue(c);
		}
		else
		{
			sellCar(maxBidder,c);
			deleteBidder();
			printHeap(h, list.size()-1);
		}*/
		
		printHeap(h, list.size());
	}
	
	void sellCar(bidder maxBidder, car c)
	{
		/*System.out.println(maxBidder.bid);
		System.out.println(maximumBid().bid);*/
		
		if(maxBidder.bid >= maximumBid().bid)
		{
			System.out.println("Car is sold to: " +maxBidder.name);
			maxBidder.budget=maxBidder.budget-maxBidder.bid;
			System.out.println("Remaining budget: "+maxBidder.budget);
			c.buyer=maxBidder.name;
			c.soldprice=maxBidder.bid;
		}
		else
		{
			System.out.println("Car is sold to: " +maximumBid().name);
			maximumBid().budget=maximumBid().budget-maximumBid().bid;
			System.out.println("Remaining budget: "+maximumBid().budget);

			c.buyer=maximumBid().name;
			c.soldprice=maximumBid().bid;
		}
		round=1;
		h=null;
	}

}
