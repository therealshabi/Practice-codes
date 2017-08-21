import java.util.*;

//Rabin Karp Algorithm
//Worst Case Complexity O(nm)

public class RabinKarp
{
	static int n,m,k=0,prime=3;
  int index;
  int substr;

    public void add(int i , int s)
    {
      index=i;
      substr=s;
    }

    public int getIndex()
    {
      return index;
    }
    public int getPattern()
    {
      return substr;
    }

    public static void check(int t,int p, int shift,int x,int string[],RabinKarp temp[])
    {
            int power=(int)Math.pow(10,m-1);

    	if(shift>n-m)
    	{
         if(k==0)   //If No Mod Value Matched
         {
    	    System.out.println("Pattern Not found");
          return;
         }
         else
         {
          for(int i=0;i<k;i++)
          {
            System.out.println("Pattern found at Index "+temp[i].getIndex());
          }
         }
         return;
      }

    	else if((t%prime)==p)  //If my Mod value of Pattern Matches The Mod Value of Substring
    	{
        if(t==x)   //Mod Value Matches and then Pattern Matches too
        {
         temp[k].add(shift,t);  //Adding into Temporary Object Array to store index(here shift) and Pattern
         k=k+1;
        }
    	}
    	if(shift<n-m)
    	{ 
    	  t=10*(t-power*(string[shift]))+string[shift+m];
    	  check(t,p,++shift,x,string,temp);
    	}
    	else
    		check(t,p,(shift+1),x,string,temp);    //if shift==(n-m)

    }

	public static void main(String args[])
	{
	  
	  int i,j;
	  Scanner in = new Scanner(System.in);
	  
	  System.out.print("Enter the String : ");
	  String str=in.nextLine();
	  str=str.toLowerCase();
	  n=str.length();
	  int string[]=new int[n];
      

	  System.out.print("Enter the Pattern : ");
	  String pat=in.nextLine();
	  pat=pat.toLowerCase();
	  m=pat.length();
	  int pattern[]=new int[m];
      
      
      for(i=0;i<n;i++)
      {
        string[i]=((int)str.charAt(i))%96;
      }

      for(i=0;i<m;i++)
      {
        pattern[i]=((int)pat.charAt(i))%96;
      }

      int t=0,p=0;

      for(i=0;i<m;i++)
      {
        t=10*t+string[i];
        p=10*p+pattern[i]; 
      }
      
      
      int x=p;  //Original Pattern 
      p=p%prime;    //Mod Value of Pattern
      RabinKarp temp[] = new RabinKarp[n-m];
      for(i=0;i<(n-m);i++)
        temp[i]=new RabinKarp();
      i=0;
      check(t,p,i,x,string,temp);
       
	}
}