import java.util.*;

//Graph Coloring using Backtracking

public class GraphColoring
{

   public boolean isSafe(int graph[][], int color[], int n, int v, int c)
   {
     for(int i=0;i<n;i++)
      if(graph[v][i]==1 && c==color[i])
      return false;
     return true;
   }

   public boolean coloringUtil(int graph[][],int color[],int n, int v)
   {
     if(v==n)
     return true;

     for(int c=1;c<=n;c++)
     {
       if(isSafe(graph,color,n,v,c))
       {
        color[v]=c;

        if(coloringUtil(graph,color,n,v+1)==true)
         return true;

        color[v]=0;
       } 
     }
     return false;
   }

   public void coloring(int graph[][], int n)
   {
     int color[]=new int[n];
     for(int i=0;i<n;i++)
     {
       color[i]=0;
     }
     if(coloringUtil(graph,color,n,0)==false)
      System.out.println("Solution does not Exist\n");
     else
      printSol(color,n);
   }

   public void printSol(int color[], int n)
   {
     for(int i=0;i<n;i++)
     {
       System.out.println("Color For Vertex V"+(i+1)+" is : "+color[i]);
     }
   }
    
   public static void main(String args[])
   {
     GraphColoring obj = new GraphColoring();
     
     int graph[][]={{0,1,1,1,1,1,1,1,1,1},
                    {1,0,1,1,1,1,1,1,1,0},
                    {1,1,0,0,0,1,1,0,0,0},
                    {1,1,0,0,1,0,0,0,0,1},
                    {1,1,1,1,0,1,0,0,0,0},
                    {1,1,1,0,1,0,0,0,0,0},
                    {1,1,1,0,0,0,0,1,0,0},
                    {1,1,0,0,0,0,1,0,0,0},
                    {1,1,0,0,0,0,0,0,0,0},
                    {1,0,0,1,0,0,0,0,0,0}};
     
     obj.coloring(graph,10);
   }	
}