import java.util.*;

public class BST
{
	int data;
	BST left=null;
	BST right=null;

	public static BST insert(BST root,int d)
	{
      if(root==null)
      {
        root=new BST();
        root.data=d;
      }
      else if(d<root.data)
      {
        root.left=insert(root.left,d);
      }
      else if(d>root.data)
      {
        root.right=insert(root.right,d);
      }
      return root;
    }

    public static void inorder_insert(BST root1, BST root2)
    {
       if(root1.left!=null)
       inorder_insert(root1.left,root2);
       insert(root2,root1.data); 
       if(root1.right!=null)
       inorder_insert(root1.right,root2);
    }

    static int n1,n2;
    static int a[];
    static int l=0;

    public static void inorder(BST root)
    {
      if(root.left!=null)
      inorder(root.left);
      a[l++]=root.data;
      if(root.right!=null)
      inorder(root.right);
    }

	public static void main(String args[])
	{
	  int data;
      BST root1=null;
      BST root2=null;
	  BST tree1 = new BST();
	  BST tree2 = new BST();
	  Scanner in =new Scanner(System.in);
	  System.out.print("Enter number of Elements in Tree 1: ");
	  n1= in.nextInt();
	  System.out.println("Enter data for Tree 1 : ");
	  for(int i=0;i<n1;i++)
	  {
        data=in.nextInt();
	    root1=insert(root1,data);
	  }
	  System.out.print("Enter number of Elements in Tree 1: ");
	  n2= in.nextInt();
	  System.out.println("Enter data for Tree 2 : ");
	  for(int i=0;i<n2;i++)
	  {
        data=in.nextInt();
	    root2=insert(root2,data);
	  }
      a=new int[n1+n2];
      inorder_insert(root1,root2);
      System.out.print("Enter value of k : ");
      int k=in.nextInt();
      System.out.print("Enter value of p : ");
      int p=in.nextInt();
      inorder(root2); 
      if(k<p)
      for(int i=(k-1);i<p;i++)
      {
         System.out.print(a[i]+" ");
      } 
       
	}
}