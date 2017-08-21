import java.util.*;

public class DFS
{
	int n=5;
	LinkedList<Integer> adj[];
  boolean visit[]=new boolean[n];
	
	public DFS()
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
	}

  public void DFSUtil(int v)
  {
    visit[v]=true;
    System.out.print(v+" ");
    Iterator<Integer> i = adj[v].listIterator();
    while(i.hasNext())
    {
      int a = i.next();
      if(visit[a]!=true)
      {
        DFSUtil(a);
      }
    }
  }

	public void traversal(int start)
	{
	  int j;
	  for(j=0;j<n;j++)
	  {
	  // visit[i]=new boolean();
	   visit[j]=false;
	  }
	  DFSUtil(start);	      
      
	}

	public static void main(String args[])
	{
	  int i;
      DFS vertex=new DFS();
      vertex.add(0,1);
      vertex.add(0,3);
      vertex.add(0,4);
      vertex.add(1,2);
      vertex.add(1,3);
      vertex.add(2,4);
      vertex.add(3,4);
      vertex.traversal(0);
	}
}