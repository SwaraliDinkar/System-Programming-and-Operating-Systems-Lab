import java.util.Scanner;
public class pagereplace 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		char ch;
		int choice;
		do
		{
			System.out.println("\nEnter choice : \n1. Least Recently Used\n2. Optimal Page Replacement\n");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("\nLEAST RECENTLY USED : ");
				LRU l=new LRU();
				l.read();
				l.execute();
				break;
			case 2:
				System.out.println("\nOPTIMAL PAGE REPLACEMENT : ");
				OPR o=new OPR();
				o.read();
				o.execute();
				break;
			
			default:
				System.out.println("\nEnter valid choice.");
			}
			System.out.println("\nPress y to continue...");
			ch=sc.next().charAt(0);
		}while(ch=='y');
		sc.close();
	}
}