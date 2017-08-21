import java.util.*;
import java.io.*;

public class heap
{
	public static void insert(int a[],int data,int m,int n)
	{
		int last,j=0,t;
		if(a[0]==0)
		{
		 a[0]=a[0]+1;       //a[0] is used to store the no. of Elements stored in the heap
		 a[m]=data;         
	    }
	    else
	    {
          last=a[0];
          if(last>=n)
          {
          	System.out.println("Heap is Full");
          }
          else
          {
          a[0]++;
          a[m]=data;
          j=m;

          //Reheapify....Comparing the Parent with child, so as to make it a max heap
          while(true)
          {
          	j=j/2;   //The parent of the current Element will be on i/2th position if the elemnt is on ith position
          	if(j>=1)
          	{
          		if(a[j]<a[m])
          		{
                  t=a[j];
                  a[j]=a[m];
                  a[m]=t;
          		}
          		m=j;    //Now we have set m to it's parent's position
          	}
          	else
          		break;
          }
	    }
	    return;
	}
	}   //Insertion Ends


	//Driver Program to Display Heap
	public static void displayHeap(int a[])
	{
		for(int i=1;i<=a[0];i++)     //We are printing the heap in the form of a complete binary tree
		{
			System.out.println(a[i]+" ");
		}
	}
  
  public static void main(String args[])
  {
    int data;
    int m=1;
    Scanner in=new Scanner(System.in);
    System.out.print("Enter the no. of Elements : ");
    int n=in.nextInt();
    int a[]=new int[n+1];   //n+1 elements since the insertion in array is starting from 1st index
    a[0]=0;
    System.out.println("Enter the Elements : ");
    for(;m<=n;m++)
    {
    	data=in.nextInt();
    	insert(a,data,m,n);
    } 
    System.out.println();
    displayHeap(a);	
   }
  }
