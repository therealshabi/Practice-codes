import java.util.*;



public class BST_LAB
{
	int data;
    BST_LAB left=null;
    BST_LAB right=null;


    public static BST_LAB insert(BST_LAB r,int d)
    {
         if(r==null)
        {
          r =new BST_LAB();
          r.data=d;
        }
        else
        {
        	if(d<r.data)
            r.left=insert(r.left,d);
            else
            {
             if(d>r.data)
             {
             	r.right=insert(r.right,d);
             }
            }
        }

        return r;
    }

    public static void check(BST_LAB root)
    {
        if(root==null)
            return;
        if(root.right!=null && root.left!=null)
        {
            if((root.data+root.left.data)==root.right.data)
                System.out.println(root.data+" "+root.left.data);
        }
        check(root.left);
        check(root.right);
    }

    public static void inorder(BST_LAB root)
    {
       if(root.left!=null)
       	inorder(root.left);
       System.out.println(root.data);
       if(root.right!=null)
       	inorder(root.right);
    }

    public static void mirror(BST_LAB root)
    {
        BST_LAB temp=null;
        if(root!=null)
        {
    	if(root.right!=null && root.left!=null)
    	{
    		temp=root.right;
    		root.right=root.left;
    		root.left=temp;
    	}
    	if(root.right==null && root.left!=null)
    	{
    		root.right=root.left;
    		root.left=null;
    	}
    		if(root.right!=null && root.left==null)
    	{
    		root.left=root.right;
    		root.right=null;
    	}

    	mirror(root.left);
    	mirror(root.right);
       }
    }

    public static void main(String args[])
    {
    	Scanner in=new Scanner(System.in);
    	BST_LAB root=null;
    	int n,d;
    	System.out.print("Enter the no. of elements : ");
        n=in.nextInt();
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++)
        {
            d=in.nextInt();
            root=insert(root,d);
            //data=0;
        }
        System.out.println();
        check(root);
        //mirror(root);
       // inorder(root);

    }
}
