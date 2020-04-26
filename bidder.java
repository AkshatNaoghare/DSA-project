package carBidding;

public class bidder 
{
	String name;
	float budget;
    bidder left, right;
    float bid;
    
	public bidder(String name, float budget) 
	{
		this.name = name;
		this.budget = budget;
	}
	
	bidder()
	{
		
	}
	
	public void display()
	{
		System.out.println("\nName:"+name);
		System.out.println("Budget remanining:"+budget);
	}
}
