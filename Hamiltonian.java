import java.util.*;

public class Hamiltonian
{
	public boolean isSafe(int graph[][],int path[],int n, int pos, int j)
	{
      if(graph[path[pos-1]][j]==0)
      	return false;
      
      for(int i=0;i<n;i++)
      	if(path[i]==j)
      		return false;
      return true;
	}


   public void printSol(int path[],int n)
   {
   	 System.out.println("Cycle Exists");

   	 for(int i=0;i<n;i++)
   	 {
   	 	System.out.print(path[i]+" ");
   	 }
   }


    public boolean cycleUtil(int graph[][],int path[],int n,int pos)
    {

    	if(pos==n)
    	{
    		if(graph[path[pos-1]][path[0]]==1)
    			return true;
    		else
    			return false;
    	}

    	for(int i=1;i<n;i++)
    	{
    		if(isSafe(graph,path,n,pos,i)==true)
    	     {
    	     	path[pos]=i;

    	     	if(cycleUtil(graph,path,n,pos+1)==true)
    	     		return true;
    	     	
            path[pos]=-1;
    	     }
    	}
    	return false;
      
    }

	public void cycle(int graph[][], int n)
	{
	  int i,j;
      int path[]= new int[n];
      for(i=0;i<n;i++)
      {
      	path[i]=-1;
      }
      path[0]=0;
     
     if(cycleUtil(graph,path,n,1)==false)
      System.out.println("Solution does not Exist\n");
     else
      printSol(path,n);
    }

	public static void main(String args[])
	{
	  int graph[][]={{0,1,0,0,0,0},
	             {1,0,1,0,1,1},
	             {0,1,0,1,0,0},
	             {0,0,1,0,1,0},
	             {0,1,0,1,0,1},
	             {1,1,0,0,1,0}};

	            int graph1[][]={{0,1,0,0},
	                            {1,0,1,0},
	                            {0,1,0,1},
	                            {1,0,1,0}};
	  Hamiltonian t=new Hamiltonian();
	  t.cycle(graph,6);
	}
}