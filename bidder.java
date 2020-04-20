package carBidding;

public class bidder 
{
	String name;
	float budget;
    bidder left, right;
    
	public bidder(String name, float budget) 
	{
		this.name = name;
		this.budget = budget;
	}
	
	bidder()
	{
		
	}
}
