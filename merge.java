import java.util.*;
import java.io.*;

public class merge
{
    public static void merging(int arr[],int l,int m,int h)
    {
    	int i,j,k;
    	int n1 = m-l+1;
    	int n2 = h-m;
        int L[]=new int[n1];
        int R[]=new int[n2];
        
        for(i=0;i<n1;i++)
        L[i]=arr[l+i];
        
        for(j=0;j<n2;j++)
        R[j]=arr[m+1+j];
        
        i=0;
        j=0;
        k=l;
        while(i<n1 && j<n2)
        {
        	if(L[i]<=R[j])
        	{
        		arr[k]=L[i];
        		i++;
        	}
        	else
        	{
        		arr[k]=R[j];
        		j++;
        	}
        	k++;
        }

       while(i<n1)
       {
       	arr[k]=L[i];
       	i++;
       	k++;
       }

       while(j<n2)
       {
       	arr[k]=R[j];
       	j++;
       	k++;
       }

    }

	public static void mergeSort(int a[],int l,int h)
	{
		if(l<h)
		{
			int mid = (l+h)/2;;
			mergeSort(a,l,mid);
			mergeSort(a,mid+1,h);
			merging(a,l,mid,h);
		}
	}

	public static void print(int a[])
	{
		for(int i=0;i<5;i++)
		{
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String args[])
	{
	  Scanner in=new Scanner(System.in);
	  int a[]={15,3,6,2,1};
	  mergeSort(a,0,4);
	  print(a);
	}
}