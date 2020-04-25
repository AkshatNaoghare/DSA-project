package carBidding;

import java.util.Scanner;

public class carBidding 
{
	public carBidding() 
	{

	}
	
	public static void main(String[] args) 
	{
//		biddingPlatform b = new biddingPlatform();
//		b.create();
//		b.create();
//		b.create();
//		b.create();
//		b.create();
////		System.out.println(b.search().name);
//		b.waitingList(b.root);
//		b.display();
////		System.out.println("delete");
////		b.delete(b.search());
////		b.display();
//		b.bidPriorityQue();
////		System.out.println(b.h[0].name);
//		b.printHeap(b.h, b.list.size());
//		b.rounds();
//		b.rounds();
		
		cars cs=new cars();		//object for cars class
		biddingPlatform b = new biddingPlatform();
		
		Scanner sc =new Scanner(System.in);
		
		int ch;
		char ch1;
		int nc=0;			//no. of cars registered
		int nb=0;			//no. of bidders registered
		
		System.out.println("\t\t\t!!!!WELCOME TO BID-CAPITAL!!!!");
		
		do
		{
			System.out.println("\na.enter details to participate in the bidding"
					+ "\nb.start bidding\nc.exit");
			ch1 = sc.next().charAt(0);
			
			switch(ch1)
			{
				case 'a':
					do
					{
						System.out.println("\nMake entry for 1.Car seller OR 2. Bidder? ");
						System.out.println("Enter 0 - back.");
					
						ch=sc.nextInt();
						
						switch(ch)
						{
							
							case 1:
								nc++;
								cs.insert();
								System.out.println("THANK-YOU!");
								break;
								
							case 2:
								nb++;
								//Accept details of bidder
								b.create();
								System.out.println("THANK-YOU!");
								break;
								

						}
					}while(ch!=0);
					
					break;
					
				case 'b':
					
					System.out.println("\nLET'S BEGIN WITH THE BID ROUNDS! GET YOUR BIDS IN!");
					
					for(int i=0; i<nc; i++)
					{
						System.out.println("\nCAR No. -->"+(i+1));
						car c=cs.select();
						
						cs.display(c);
						
					}
					
					break;
					
				case 'c':
					
					break;	
			}
		
		}while(ch1 != 'c');
		
		
		
		
		
		cs.index = 0;
		car cc;
		
		System.out.println("results of all cars: ");
		for(int i=0; i<nc; i++)				//print all car details including buyer after all rounds
		{
			System.out.println("\nResults of all cars:");
			cc=cs.select();
			cs.display(cc);
		}
		
		System.out.println("THANKYOU!");
		
	}
}
