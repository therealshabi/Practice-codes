import java.util.*;

public class BFS
{
	int n=5;
	LinkedList<Integer> adj[];

	public BFS()
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

	public void traversal(int start)
	{
	  int j;
	  LinkedList<Integer> queue = new LinkedList<Integer>();
	  boolean visit[]=new boolean[n];
	  for(j=0;j<n;j++)
	  {
	  // visit[i]=new boolean();
	   visit[j]=false;
	  }
	  visit[start]=true;
	  queue.add(start);
      while(queue.size()!=0)
      {
        int s=queue.poll();
        System.out.print(s+" ");
        Iterator<Integer> i = adj[s].listIterator();
        while(i.hasNext())
        {
          int a = i.next();
          if(visit[a]!=true)
          {
            queue.add(a);
            visit[a]=true;
          }
        }
      }
	}

	public static void main(String args[])
	{
	  int i;
      BFS vertex=new BFS();
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
