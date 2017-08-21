import java.util.*;

public class Dijkstra
{
    

    public int min(int dist[],int n, Boolean set[])
    {
    	int mini=Integer.MAX_VALUE;   //Minimum initially is Infinite
    	int min_index=-1;
    	for(int i=0;i<n;i++)
    	{
			if (set[i] == false && dist[i] < mini)    //Find the minimum if that index is not a labelled node and distance is less than minimum
    		{
              mini=dist[i];
              min_index=i;
    		}
    	}
    	return min_index;
    }

    
    public void displayPath(int a[],int n,int s, int d)
    {
    	int temp_array[]=new int[n];
    	int k=0;
    	int temp=d;
    	temp_array[k++]=d+1;   //Temp array stored the destination first, we've added +1 so that it shows the index '0' as V1 or in general index i as vertex V(i+1) for our convenience 
    	//System.out.print((d+1)+" -->");
    	for(int i=0;i<n;i++)
    	{
          if(a[temp]!=-1)
          {
          	//System.out.print(a[temp]+1);
          	temp_array[k++]=a[temp]+1;  //Parent of Destination is stored in temp_array, we've added +1 so that it shows the index '0' as V1 or in general index i as vertex V(i+1) for our convenience
          	temp=a[temp];               //temp is updated as destination (temp) now becomes the index stored at previous temp position of parent array
          	if(temp==s)                //if the index becomes source then break
            break;
          	//System.out.print(" -->");
          }

    	}

    	for(int i=k-1;i>=0;i--)       //Display the temp_array in reverse order to display the path from source to destination
    	{
    		if(i!=0)     //So that '-->' is not displayed for last element i.e source
    		System.out.print(temp_array[i]+" -->");
    	    else
    	    	System.out.print(temp_array[i]);
    	}
    }

    public int shortestPath(int graph[][],int s, int d,int n)
    {
      int dist[]=new int[n];              //This array records the minimum distances from a vertex to all other vertex
      Boolean set[] = new Boolean[n];    //This array Marks true for Verices which are made permanent Labelled nodes
      int parent[]=new int[n];           //Parent array for marking parent for every vertex for minimum path
      for(int i=0;i<n;i++)
      {
        dist[i] = Integer.MAX_VALUE;     //Set all distances to infinite initially
      	set[i]=false;                    //No vertices are marked labelled node yet
      	parent[i]=-1;                    //Initialize parent array by -1 as array index starts from 0
      }
      dist[s]=0;                         //Distance from source to source is 0
      //parent[s]=s;
      for(int j=0;j<n-1;j++)            //To calculate from source to all n-1 vertices
      {
         int u= this.min(dist,n,set);    //Calculate index of vertex having Minimum distance from labelled node 
         set[u]=true;                    //Set that index as labelled node
         for(int v=0;v<n;v++)
         {
             /* Update dist[v] only if is not a labelled node set[v] should be false, there is an edge from u to v, and total weight of
              path from source node 's' to v through u is smaller than current value of dist[v] */
         	if(!set[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && (dist[u]+graph[u][v])<dist[v])
         	{
         		dist[v]=dist[u]+graph[u][v];
         		parent[v]=u;   //Update the parent...the parent of vertex at index v is index u
         	}
         }
      }
        displayPath(parent,n,s,d);
        return dist[d];        //return distance of destination from source, where 'd' is the destination
    }

	public static void main(String args[])
	{
        /*       2
            --V1-----V2         The Graph
        2  /  |  3___/| 5
          /   |__/    |        EDGES :-
         V4__/|      V3        V1--V2 = 2
          \   | 4   /          V2--V3 = 5
         3 \  |    / 1         V3--V5 = 1
            V5____/            V2--V4 = 3
                               V1--V4 = 2
                               V4--V5 = 3
                               V1--V5 = 4
       */

       int i,j;
	   Scanner in =new Scanner(System.in);
       int min_path=0;

       int graph[][]={{0,2,0,2,4},{2,0,5,3,0},{0,5,0,0,1},{2,4,0,0,3},{4,0,1,3,0}};
       int n=5;    //No. of vertices
       System.out.print("Enter the starting vertex : ");
       i=in.nextInt();     
       System.out.print("Enter the destination vertex : ");
       j=in.nextInt();
       Dijkstra t =new Dijkstra();
       min_path=t.shortestPath(graph,i-1,j-1,n);    //Vi is the (i-1)th index in graph array similarly for Vj
       System.out.println("\nThe distance is : "+min_path);	  
	}
}