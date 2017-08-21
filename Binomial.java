import java.util.*;
import java.math.*;

//Binomial Expansion Algorithm by Dynamic Programming

public class Binomial
{
   int c[][],i,j;
   public void coefficients(int n)
   {
     c=new int[n+1][n+1];
     int count=0;
     for(i=0;i<=n;i++)
     {
     	for(j=0;j<=n;j++)
     	{

     		if(i==0 || j==0)
     		{
     			c[i][j]=1;
     		}
     		else if(i==j)
     		{
     			c[i][j]=1;
     		}
     		else if(j<i)
     		{
     			c[i][j]=c[i-1][j-1]+c[i-1][j];
     		}
     	}
     }
   }

    public void find(int a, int b, int k, int n)
    {
    	long x,y,z;
        x=(long)(Math.pow(a,k));
        y=(long)(Math.pow(b,n-k));
        z=(long)c[n][k];
        System.out.println("Answer is : "+x+" * "+y+" * "+z+" = "+(x*y*z));
    } 
	
	public static void main(String args[])
	{
	  Scanner in = new Scanner(System.in);
	  Binomial t =new Binomial();
	  int n=12;
	  t.coefficients(n); 
     
      //(a+b)^n is the term

	  System.out.print("Enter value of a : ");
	  int a= in.nextInt();
      System.out.print("Enter value of b : ");
	  int b= in.nextInt();
	  System.out.print("Which term do you want to find : ");
	  int k= in.nextInt();
	  t.find(a,b,k-1,n);  // as kth term is C(n,k-1) *  a^(n-k+1) * b^(k-1)
	}
}