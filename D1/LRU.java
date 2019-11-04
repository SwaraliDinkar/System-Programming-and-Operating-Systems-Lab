import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LRU

{
	Scanner sc=new Scanner(System.in);
	int n;
	int frame;
	int page[];
	
	
void read()
{
	System.out.println("Enter the number of pages:\n");
	n=sc.nextInt();
	System.out.println("Enter the size of frame:");
	frame=sc.nextInt();
	System.out.println("Enter the pages");
	
	page=new int[n];   //got error (wrote it as page[])
	for (int i=0;i<n;i++)
	{
		page[i]=sc.nextInt();
	}
	
}

void execute()
{
	HashSet<Integer> s=new HashSet<>(frame);
	HashMap<Integer,Integer> indexes=new HashMap<>();
	int pagefault=0;
	boolean fault=false;
	for (int i=0;i<n;i++)
	{
		if(s.size()<frame)
		{
			if (!s.contains(page[i]))
			{
				s.add(page[i]);
				pagefault++;
				fault=true;
			}
			else
			{
				fault=false;
			}
			indexes.put(page[i], i);
		}
		
		else
		{
			if(!s.contains(page[i]))
			{
				int lru=Integer.MAX_VALUE;
				int val=Integer.MIN_VALUE;
				Iterator<Integer> itr=s.iterator();
				int temp;
				while(itr.hasNext())
				{
					temp=itr.next();          //got error (wrote it outside while)
					if(indexes.get(temp)<lru)
					{
						lru=indexes.get(temp);
						val=temp;
					}
				}
				s.remove(val);
				s.add(page[i]);
				fault=true;
				pagefault++;
				
				
			}
			else
			{
				fault=false;
			}
			indexes.put(page[i], i);
		}
		if(fault==true)
		{
			System.out.println(s+"\tPage fault");
		}
		else
		{
			System.out.println(s+"\t No Page fault");
		}
	}
	System.out.println("\nPages faults: "+pagefault);
	float pfr=(float)pagefault/n;
	System.out.println("\nPages fault Ratio: "+pfr);
	
}


}