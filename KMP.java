import java.util.*;

//Knuth-Morris-Pratt(KMP) Pattern Searching Algorithm
//O(n+m) Complexity
//O(m) for calculating Temp array
//O(n) for searching pattern using temp array

public class KMP
{
    static int temp[];
    
    public static void search(String t, String p, int n ,int m)
    {
      temp=new int[m];
      form(m,p);
      int j=0;
      int i=0;
      while(i<n && j<m)
      {
        if(t.charAt(i)==p.charAt(j))
        {
          i++;
          j++;
        }
        else if(t.charAt(i)!=p.charAt(j) && j!=0)
        {
          j=temp[j-1];
        }
        else
         i++;   //If Character does not Match and j=0
      }
      
      if(j==m)
      {
        System.out.println("Pattern Matched Successfully at Index : "+(i-m));
      }
      else
        System.out.println("Pattern Not Found");

    } 

    //Building Temp Array for finding whether Substring contains any suffix which is same as it's prefix so as to minimize our point of matching
    //as it'll help us to not match again pattern which we've already matched   
    public static void form(int m,String p)
    {
      int j=0;
      temp[j]=0;
      for(int i=1;i<m;)
      {
        if(p.charAt(i)==p.charAt(j))
        {
          temp[i]=j+1;
          j++;
          i++;
        }
        else if(p.charAt(i)!=p.charAt(j) && j==0)
        {
          temp[i]=0;
          i++;
        }
        else if(p.charAt(i)!=p.charAt(j) && j!=0)
        {
           j=temp[j-1];
        }
      }
    }

	public static void main(String args[])
	{
	  String text="azzbbccddaa";
	  String patt="cdda";
      int n = text.length();
      int m= patt.length();
      search(text,patt,n,m);
	}
}