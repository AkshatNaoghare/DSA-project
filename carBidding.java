package carBidding;

public class carBidding 
{
	public carBidding() 
	{

	}

	public static void main(String[] args) 
	{
		bidding b = new bidding();
		b.create();
		b.create();
		b.create();
		b.create();
		b.create();
//		System.out.println(b.search().name);
		b.waitingList(b.root);
		b.display();
//		System.out.println("delete");
//		b.delete(b.search());
//		b.display();
		b.bidPriorityQue();
//		System.out.println(b.h[0].name);
		b.printHeap(b.h, b.list.size());
	}

}
