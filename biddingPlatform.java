package carBidding;

public class biddingPlatform extends bidding
{
	public biddingPlatform() 
	{

	}
	
	void rounds(car c)
	{
		char ch;
		
		bidder maxBidder = maximumBid();
		
		System.out.println("continue rounds? (y/n)");
		
		if(sc.next().charAt(0) == 'y')
		{
			bidPriorityQue();
		}
		else
		{
			sellCar(maxBidder,c);
			deleteBidder();
			printHeap(h, list.size()-1);
		}
	}
	
	void sellCar(bidder maxBidder, car c)
	{
		System.out.println(maxBidder.bid);
		System.out.println(maximumBid().bid);
		
		if(maxBidder.bid >= maximumBid().bid)
		{
			System.out.println("car is sold to " +maxBidder.name);
			c.buyer=maxBidder.name;
			c.soldprice=maxBidder.bid;
		}
		else
		{
			System.out.println("car is sold to " +maximumBid().name);
			c.buyer=maximumBid().name;
			c.soldprice=maximumBid().bid;
		}
	}

}
