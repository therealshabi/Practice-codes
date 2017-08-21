import java.util.*;

/*
*
Longest Common Subsequence
*
*/

public class LCS
{
	public int max(int a, int b)
	{
		if(a>b)
			return a;
		else return b;
	}

  public void find(char a[], char b[], int n, int m)
  {
     int k[][],i,j;
     k=new int[n+1][m+1];
     for(i=0;i<=n;i++)
     {
       for(j=0;j<=m;j++)
       {
          if(i==0 || j==0)
          k[i][j]=0;
          else if(a[i-1]==b[j-1])
          {
             k[i][j]=k[i-1][j-1]+1;
          }
          else
          {
          	k[i][j]=max(k[i-1][j],k[i][j-1]);
          }
       }
     }

     int index=k[n][m];
     System.out.println("Length of Longest Common Subsequence is : "+k[n][m]);
     char subs[]=new char[index+1];
     subs[index]='\0';
     i=n;
     j=m;
     while(i>0 && j>0)
       {
     		if(a[i-1]==b[j-1])
     		{
     			subs[index-1]=a[i-1];
     			index--;
     			i--;
     			j--;
     		}
     		else if(k[i-1][j]>k[i][j-1])
     		{
                i--;
     		}
     		else
     			j--;
     	}
     	System.out.print("Longest Common Subsequence is : ");
     	for(i=0;i<=k[n][m];i++)
     	{
     		System.out.print(subs[i]);
     	}
     	System.out.println();
  } 
  public static void main(String args[])
  {
  	String x="ABCDBA";
  	String y="CBACBAABA"; 
    char a[]= x.toCharArray();
    char b[]= y.toCharArray();
    LCS t = new LCS();
    int n= x.length();
    int m= y.length();
    t.find(a,b,n,m);

  }	
}