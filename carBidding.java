package carBidding;

import java.util.Scanner;

public class carBidding 
{
	public carBidding() 
	{

	}
	
	public static void main(String[] args) 
	{
		/*biddingPlatform b = new biddingPlatform();
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
		b.rounds();
		b.rounds();*/
		
		cars cs=new cars();		//object for cars class
		bidders bs=new bidders();
		
		Scanner sc =new Scanner(System.in);
		
		int ch;
		int nc=0;			//no. of cars registered
		int nb=0;			//no. of bidders registered
		
		System.out.println("\t\t\t!!!!WELCOME TO BID-CAPITAL!!!!");
		
		do
		{
			System.out.println("\nMake entry for 1.Car seller OR 2. Bidder? ");
			System.out.println("Enter 0 if you are done with all entries.");
		
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 0:
				//All entries accepted, move to the bids
				break;
				
			case 1:
				nc++;
				cs.insert();
				System.out.println("THANK-YOU!");
				break;
				
			case 2:
				nb++;
				//Accept details of bidder
				bs.create();
				System.out.println("THANK-YOU!");
				break;
				
				default:
					System.out.println("ENTER VALID OPTION!");
			}
		}while(ch!=0);
		
		System.out.println("\nLET'S BEGIN WITH THE BID ROUNDS! GET YOUR BIDS IN!");
		
		for(int i=0; i<nc; i++)
		{
			System.out.println("\nCAR No. -->"+(i+1));
			car c=cs.select();
			
			cs.display(c);
			//bidpriority queue //rounds(c)
			
			
			//bid rounds
		}
		
		car cc;
		for(int i=0; i<nc; i++)				//print all car details including buyer after all rounds
		{
			System.out.println("\nResults of all cars:");
			cc=cs.select();
			cs.display(cc);
		}
		
		System.out.println("THANKYOU!");
		
	}
}
