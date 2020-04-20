package carBidding;

public class car 
{
	String name;	//stores owner's name
	String licPNo;	//stores license plate number of the car
	float originalCost;	//stores original cost of the car
	float minBid;	//minimum bid expected by the owner
//	String brand;
//	String modelName;	//stores model name of the car
	car next;
	
	public car(String n, String ln, float cp, float minb) 
	{
		name = n;
		licPNo = ln;
		originalCost = cp;
		minBid = minb;
	}
	
	car()
	{
		next = null;
	}

}
