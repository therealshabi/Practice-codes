import java.util.*;

//Question for Lab-7 Q1 assignment with n complexity

public class lab1
{
	public static void main(String args[])
	{
	 int max=0,sum=0,i,a[],l=0,u=0,n,j=0;
	 Scanner in =new Scanner(System.in);
	 System.out.print("Enter the size of the array : ");
     n=in.nextInt();
     a=new int[n];
     System.out.println("Enter the array Elements : ");
     for(i=0;i<n;i++)
     {
       a[i]=in.nextInt();
     }
     int count=0;
     for(i=0;i<n;i++)
     {
       if(count==0)   //Checking if the first element is not less than 0
       {
       if(a[i]<0)
       continue;
       }
         if(count!=1)
         {                //Temporarily storing the lower limit of the sub array in j
          j=i;
         }
         count=1;          //Count=1 signifies that we have started from the element which is not -ve 
         sum=sum+a[i];      //storing the sum
         if(sum<0 || i==n-1)   //Either the sum becomes negative or we have reached the end of array then break that subarray
         {
         	if(sum<0)
         	{		
            sum=sum-a[i];      //If sum became negative then undo the step or the element which you have added earlier such that the sum became -ve
            }
            if(sum>max)        //Storing the maximum sum
            {
             l=j;               //Storing the temporary lower limit into lower limit if max is found
             if(sum+a[i]<0)
             u=i-1;             //Storing the upper limit if the sub array was broken due to -ve sum if max is found

             else
             	u=i;        //Storing the upper limit if subarray was broken due to end of array was reached
             max=sum;
             count=0;        //Now checking for the next sub arrays so count and sum =0
             sum=0;
             //i++;
            }
         }
     }
     System.out.println("Maximum sum is : "+max+" With Lower Limit : "+l+" and Upper Limit : "+u);
	}
}