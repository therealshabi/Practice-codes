import java.util.*;

//Rabin Karp Algorithm

public class Rabin
{
	static int n,m;

    public static void check(int t,int p, int shift, int string[])
    {
            int power=(int)Math.pow(10,m-1);
    	      //System.out.println(t+"   "+p+"  "+power+"  "+shift);

    	if(shift>n-m)
    	{
    	  System.out.println("Pattern Not found");
    	  return;
        }
    	if(t==p)
    	{
    		System.out.println("Pattern found at Index "+shift);
    		return;
    	}
    	else
    	{ 
    	  t=10*(t-power*(string[shift]))+string[shift+m];
    	  check(t,p,++shift,string);
    	}

    }

	public static void main(String args[])
	{
	  
	  int i,j;
	  Scanner in = new Scanner(System.in);
	  
	  System.out.print("Enter the String : ");
	  String str=in.nextLine();
	  n=str.length();
	  int string[]=new int[n];
      

	  System.out.print("Enter the Pattern : ");
	  String pat=in.nextLine();
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
      
      i=0;
      check(t,p,i,string); 
	}
}