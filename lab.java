import java.util.*;

//Question for Lab-7 Q1 assignment with n^2 complexity

public class lab
{
	public static void main(String args[])
	{
	 int a[],n,i,j,sum=0,upperLimit=0,lowerLimit=0,max=0,k;
	 Scanner in =new Scanner(System.in);
	 System.out.print("Enter the size of the array : ");
     n=in.nextInt();
     a=new int[n];
     System.out.println("Enter the array Elements : ");
     for(i=0;i<n;i++)
     {
       a[i]=in.nextInt();
     }

     for(i=0;i<n;i++)
     {
       sum=0;
       for(j=i;j<n;j++)
       {
        sum+=a[j];
        if(sum>max)
        {
         max=sum;
         k=j-i;
         lowerLimit=i;
         upperLimit=j;
        }
       }
     }
     System.out.println("Maximum Sum is : "+max+" Starting from index : "+lowerLimit+" and Ending at index :  "+upperLimit);
	}
}