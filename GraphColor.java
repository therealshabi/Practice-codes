import java.util.*;

public class GraphColor
{
    int n=5;
    LinkedList<Integer> adj[];

    public GraphColor()
    {
     adj=new LinkedList[n];
     for(int i=0;i<n;i++)
     {
      adj[i]=new LinkedList();
     }
    }

    public void add(int s, int d)
    {
     adj[s].add(d);
     adj[d].add(s);
    }

    public void color()
    {
    	int i,j;
    	int result_color[]=new int[n];
    	boolean avail_color[]=new boolean[n];
    	for(i=0;i<n;i++)
    	{
          avail_color[i]=true;
          result_color[i]=-1;
    	}
    	result_color[0]=0;   //Assigning 1st vertex '0' color
    	avail_color[0]=false;  //Now '0' color is unavailable

    	for(i=1;i<n;i++)
    	{
    		Iterator<Integer> it = adj[i].listIterator();
    		while(it.hasNext())
    		{
    		  int s=it.next();
    		  if(result_color[s]!=-1)
    		  avail_color[result_color[s]]=false;   //For All adjacent vertex of i, color same as color assigned to i is unavailable 
    		}
             
    		for(j=0;j<n;j++)
    		{
    			if(avail_color[j]==true) //Find the first available color
    				break;
    		}

    		result_color[i]=j;

    		it = adj[i].listIterator();
    		while(it.hasNext())
    		{
    		  int s=it.next();
    		  if(result_color[s]!=-1)
    		  avail_color[result_color[s]]=true; 
    		}
    	}

    	for(i=0;i<n;i++)
    	{
    		System.out.println("Vertex "+i+" has color : "+result_color[i]);
    	}

    }

	public static void main(String args[])
	{
      int i;
      GraphColor vertex=new GraphColor();
      vertex.add(0,1);
      vertex.add(0,3);
      vertex.add(0,4);
      vertex.add(1,2);
      vertex.add(1,3);
      vertex.add(2,4);
      vertex.add(3,4);
      vertex.color();
	}
}