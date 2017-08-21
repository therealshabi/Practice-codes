import java.util.*;

public class Solution
{
	public static int max(int a, int b)
	{
         if(a>b)
         	return a;
         else
         	return b;
	}
	public static void main(String args[])
	{
	  Scanner in = new Scanner(System.in);
	  int key=in.nextInt();
	  int n = in.nextInt();
	  int a[]=new int[n];
      for(int i=0;i<n;i++)
      a[i]=in.nextInt();
      int count=0,c=0;

      int sol[][]=new int[n][key];

      for(int i=0;i<n;i++)
      {
        for(int j=0;j<key;j++)
        {
          if(i==0 && (j+1)%a[i]==0)
          {
          sol[i][j]=1;
          continue;
          }
          else if((j+1)<a[i])
          {
          	sol[i][j]=0;
          	continue;
          }
          else if(i!=0)
          {
            for(int k=i;k>=0;k--)
            {
              if((j+1)%a[k]==0)
              count++;
             
              if(k!=0)
              {
              int temp=(j+1);
              for(int l=k;l>=(k-1);l--)
               {
               if(temp%a[l]!=0 && !(temp/a[l]<=0))
               {
                temp=temp/a[l];
                c++;
                continue;
               }
               else if(temp/a[l]<=0)
               {
               	continue;
               }

               if(temp%a[l]==0 && c!=0)
               {
                count+=sol[l][j];
                c=0;
               }
              }
             }
             
            }
            sol[i][j]=max(count,sol[i-1][j]);
            count=0;
            c=0;
          }
          else if(i==0 && (j+1)%a[i]!=0)
          	sol[i][j]=0;
        }
      }
        System.out.println(sol[n-1][key-1]);
	}
}
