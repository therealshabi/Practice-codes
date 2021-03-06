// A Dynamic Programming based solution for 0-1 Knapsack problem
import java.util.*;

public class Knapsack
{
// A utility function that returns maximum of two integers
public int max(int a, int b)
 { return (a > b)? a : b; }
 
// Returns the maximum value that can be put in a knapsack of capacity W
public int knapSack(int W, int wt[], int val[], int n)
{
   int i, w;
   int K[][]=new int[n+1][];
   for(i=0;i<n+1;i++)
   K[i]=new int[W+1];
 
   // Build table K[][] in bottom up manner
   for (i = 0; i <= n; i++)
   {
       for (w = 0; w <= W; w++)
       {
           if (i==0 || w==0)
               K[i][w] = 0;
           else if (wt[i-1] <= w)
                 K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
           else
                 K[i][w] = K[i-1][w];
       }
   }
 
   return K[n][W];
}
 
 public static void main(String args[])
{
  Knapsack t =new Knapsack();
    int val[] = {60, 100, 120};
    int wt[] = {10, 20, 30};
    int  W = 50;
    int n = 3;
    int d=t.knapSack(W, wt, val, n);
    System.out.println(d);
}
}