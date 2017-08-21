 import java.util.*;

public class Prim
{
	static int n;

    public int min(int dist[],boolean s[])
    {
    	int min_index=-1;
    	int mini=Integer.MAX_VALUE;
    	for(int i=0;i<n;i++)
    	{
    		if(s[i]!=true && dist[i]<mini)
    		{
    			mini=dist[i];
    			min_index=i;
    		}
    	}
    	return min_index;
    }

    public void print(int graph[][], int parent[])
    {
    	System.out.println("Edge\tWeight");
    	for(int i=1;i<n;i++)
    	{
    		System.out.println(parent[i]+"--"+i+"      "+graph[i][parent[i]]);
    	}
    }

	public void primAlgo(int graph[][])
	{
		int i;
		boolean set[]=new boolean[n];
		int parent[]=new int[n];
		int dist[] = new int[n];

		for(i=0;i<n;i++)
		{
			parent[i]=-1;
			set[i]=false;
			dist[i]=Integer.MAX_VALUE;
		}

		dist[0]=0;
		for(i=0;i<n-1;i++)
		{
			int u= min(dist,set);
			//System.out.println(u);
			set[u]=true;

			for(int v=0;v<n;v++)
			{
				if(set[v]!=true && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && graph[u][v]<dist[v] )
				{
					parent[v]=u;
					dist[v]=graph[u][v];
				}
			}
		}
		print(graph,parent);
		int sum=0;
    	for(i=0;i<n;i++)
    	{
          sum+=dist[i];
    	}
    	System.out.println(sum);
 
	}
	public static void main(String args[])
	{
		n=5;
	   int graph[][]={{0,2,0,2,4},{2,0,5,3,0},{0,5,0,0,1},{2,4,0,0,3},{4,0,1,3,0}};
	   Prim t =new Prim();
	   t.primAlgo(graph);

	}
}