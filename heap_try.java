import java.util.*;
import java.io.*;

//Wrong Code needs Modification
//Heap By Linked List

class stack
{
	int a[];
	int count=0;
	
	public stack(int n)
	{
		a=new int[n];
	}

	public void push(int d)
	{
      a[count]=d;
      count=1;
	}

	public int getElement()
	{
		return a[0];
	} 
    
    public void pop()
	{	
      a[0]=0;
      --count;
	}

}

class queue
{
	int a[];
	int front=-1;
	int rear=0;
	
	public queue(int n)
	{
		a=new int[n];
	}

	public void push(int d)
	{
      if(front==-1)
      {
      	front=0;
      	a[front]=d;
      	rear=1;
      }
      else
      {
      	a[rear]=d;
      	rear=2;
      }	
	}

	public int getElement()
	{
		int n=a[front];
		pop();
      return n;
	}

	public void pop()
	{
		a[front]=0;
		front++;
      if(front==rear)
      {
      	front=-1;
      	rear=0;
      }

	} 

	public int getRear()
	{
		return rear;
	}
}

public class heap
{
    int data;
    heap left=null;
    heap right=null;


	public static heap insert(heap r,int d)
	{
        if(r==null)
        {
          r =new heap();
          r.data=d;  	
        }
        else
        {
        	if(r.left==null)
            r.left=insert(r.left,d);
            else{
            if(r.left!=null && r.right==null)
             {
             	r.right=insert(r.right,d);
             }	
             else
             	if(r.left!=null && r.right!=null)
             		r.left.left=insert(r.left.left,d);
            }		
        }

        return r;
	}

	public static void swap(heap r, heap child,stack obj)
	{
		heap temp;
		temp=r;
		r=child;
		child=temp;
		obj.pop();
		obj.push(child.data);
	}

	public static void compare(heap r,stack obj,queue obj1)
	{
		for(int i=0;i<obj1.getRear();i++)
		if(obj.getElement()<obj1.getElement())
		{
		  if(i==0)	
          swap(r,r.left,obj);
          else
          swap(r,r.right,obj);   
		}
		obj.pop();
	}

	public static void heapify(heap root,stack obj, queue obj1)
	{
		if(root!=null && root.left==null && root.right!=null)
		{
           root.left=root.right;
           root.right=null;
		}
		if(root!=null)
		obj.push(root.data);
		if(root.left!=null)
        obj1.push(root.left.data);
    	if(root.right!=null)
        obj1.push(root.right.data);
        compare(root,obj,obj1);
        if(root.left!=null)
        heapify(root.left,obj,obj1);
        if(root.right!=null)
        heapify(root.right,obj,obj1);

	}

	 public static void inorder(heap root)
    {
       if(root.left!=null)
       	inorder(root.left);
       System.out.println(root.data);
       if(root.right!=null)
       	inorder(root.right);
    }

	public static void main(String args[])
	{
		int d;
		heap root=null;
		Scanner in = new Scanner(System.in);
        System.out.print("Enter the no. of Elements you want to enter : ");
        int n=in.nextInt();
        stack obj=new stack(1);
        queue obj1=new queue(2);
        System.out.println("Enter the Elements : ");
        for(int i=0;i<n;i++)
        {
           d=in.nextInt();
           root=insert(root,d);
        }
        heapify(root,obj,obj1);
        System.out.println();
        inorder(root);

	}
}