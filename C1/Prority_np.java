package algo;

import java.util.Scanner;

class Priority
{
	void cal3()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no of process: ");
		int n = sc.nextInt();
		int pid[] = new int[n];   // process ids
		int ar[] = new int[n];     // arrival times
		int bt[] = new int[n];     // burst or execution times
		int ct[] = new int[n];     // completion times
		int ta[] = new int[n];     // turn around times
		int wt[] = new int[n]; // waiting times 
		int pp[] = new int[n];
		int temp;
		float avgwt=0,avgta=0;
		
		 for(int i=0;i<n;i++)
		    {
		        System.out.println("Enter Process "+(i+1)+" ID: ");
		        pid[i] = sc.nextInt();
		        System.out.println("Enter Process "+(i+1)+" Burst Time: ");
		        bt[i] = sc.nextInt();
		        System.out.println("Enter process "+(i+1)+" Priority : ");
				pp[i] = sc.nextInt();
		    }
		 
		 for(int i=0;i<n-1;i++)
		   {
		     for(int j=i+1;j<n;j++)
		     {
		          if(pp[i]>pp[j])
		           {
				     temp=pp[i];
				     pp[i]=pp[j];
				     pp[j]=temp;
				     temp=bt[i];
				     bt[i]=bt[j];
				     bt[j]=temp;
				     temp=pid[i];
				     pid[i]=pid[j];
				     pid[j]=temp;
		           }
		      }
		   }
		        wt[0] = 0;
			    ta[0]= bt[0]+wt[0];
			    for(int i=1;i<n;i++)
			    {
			        wt[i] = wt[i-1]+bt[i-1];
			        ta[i] = wt[i]+bt[i];
			        avgwt += wt[i];
				    avgta += ta[i]; 
			    }
			    System.out.println("\npid  brust  turn  waiting");
				for(int  i = 0 ; i< n;  i++)
				{
					System.out.println(pid[i] + "  \t " + bt[i] + "\t" + ta[i] + "\t"  + wt[i] ) ;
				}
				
				System.out.println("\naverage waiting time: "+ ((avgwt+wt[0])/n));   
				System.out.println("average turnaround time:"+((avgta+ta[0])/n));    
			
				     
		 
	}
	     
}

public class Prority_np {

	public static void main(String[] args) 
	{
		Priority p=new Priority();
		p.cal3();

	}

}
