
import java.util.Scanner;
public class practice{
int max[][];
int need[][];
int available[][];
int allocation[][];
int np,nr;

public void input(){
Scanner input=new Scanner(System.in);
System.out.println("Enter no. of Process and no. of Resource ");
np=input.nextInt();
nr=input.nextInt();
max=new int[np][nr];
need=new int[np][nr];
available=new int[1][nr];
allocation=new int[np][nr];


System.out.println("Enter Allocation Matrix");

System.out.println();
for(int i=0;i<np;i++){
for(int j=0;j<nr;j++){
allocation[i][j]=input.nextInt();
}

}

System.out.println("Enter Max Matrix");


System.out.println();
for(int i=0;i<np;i++){
for(int j=0;j<nr;j++){
max[i][j]=input.nextInt();
}
}

System.out.println("Enter Available Matrix");

System.out.println();
for(int i=0;i<nr;i++){
available[0][i]=input.nextInt();
}

}

public void cal_need()
{
	System.out.println("need matrix");
	for (int i=0;i<nr;i++)
	{
		char c=(char) ((char) 65+i);
		System.out.println(c+"\t");
	}
	System.out.println();
	for (int i=0;i<np;i++)
	{
		for(int j=0;j<nr;j++)
		{
			need[i][j]=max[i][j]-allocation[i][j];
			System.out.println(need[i][j]+"\t");
		}
		System.out.println();
		
	}
	
}

public boolean check(int p)
{
	for (int j=0;j<nr;i++)
	{
		if(available[0][j]<=need[p][j])
		{
			return false;
		}
	}
	return true;
}

public void algorithm()
{
	cal_need();
	int c=0;
	boolean status[]=new boolean[np];
	while(c<np)
	{
		boolean allocated=false;
		for(int i=0;i<np;i++)
		{
			if(!status[i]&& check(i))
			{
				status[i]=true;
				allocated=true;
				c++;
				
				System.out.println("Allocated process"+i);
				for(int j=0;j<nr;j++){
					available[0][j]=available[0][j]+allocation[i][j];

					}
				
			}
		}
		
		if(!allocated)
		{
			break;
		}
		
		
	}
	if(c==np)
	{
		System.out.println("\nSafely allocated");
	}
	else
	{
		System.out.println("All proceess cant be allocated safely");
	}
	
	
}



}
