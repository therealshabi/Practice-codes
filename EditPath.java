import java.util.*;

/*
*
Edit Path Algorithm
*
*/

public class EditPath
{

	public int min(int a, int b)
	{
		if(a<b)
			return a;
		else
			return b;
	} 

    public int min(int a, int b, int c)
    {
    	return min(min(a,b),c);
    }
   
    public void findMinCost(String a, String b, char x[],char y[], int n, int m)
    {
    	int k[][],i,j;
    	k=new int[n+1][m+1];
    	for(i=0;i<=n;i++)
    	{
    		for(j=0;j<=m;j++)
    		{
    			if(i==0)
    			{
    				k[i][j]=j;
    			}
    			else if(j==0)
    			{
    				k[i][j]=i;
    			}
    			else if(x[i-1]==y[j-1])
    			{
    				k[i][j]=k[i-1][j-1];
    			}
    			else
    				k[i][j]=1+(min(k[i-1][j],k[i-1][j-1],k[i][j-1]));
    		}
    	}
    	System.out.println("Minimum Cost for Converting String "+a+" to String "+b+" is : "+k[n][m]);
    }

	public static void main(String args[])
	{
	  Scanner in = new Scanner(System.in);
	  System.out.print("Enter the String which you want to convert : ");
	  String a= in.nextLine();
	  System.out.print("Enter the String in which you want to convert the first String : ");
	  String b= in.nextLine();
	  char x[]=a.toCharArray();
	  char y[]=b.toCharArray();
	  int n= a.length();
	  int m= b.length();
	  EditPath t = new EditPath();
	  t.findMinCost(a,b,x,y,n,m);

	}
}