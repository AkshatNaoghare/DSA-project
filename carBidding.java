//C H E C K

package carBidding;

public class carBidding 
{
	public carBidding() 
	{

	}

	public static void main(String[] args) 
	{
		bidders b = new bidders();
		b.create();
		b.create();
		b.create();
		b.create();
		b.create();
		System.out.println(b.search().name);
		b.waitingList(b.search());
		b.display();
		System.out.println("delete");
		b.delete(b.search());
		b.display();
	}

}
