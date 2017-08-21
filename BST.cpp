#include<iostream>

using namespace std;

void mergeSort(int arr[],int l,int m, int u)
{
    int n=sizeof(arr);
   int tempArr[n];
   int i;
   /*for(i=0;i<n;i++)
   {
   	 tempArr[i]=arr[i];
   }*/
   i=l;
   int j=m+1;
   int k=l;
   while(i<=m && j<=u)
   {
   	if(arr[i]>arr[j])
   	{
   		tempArr[k]=arr[j];
        j++;
   	}
   	else
   	{
   		tempArr[k]=arr[i];
   		i++;
   	}
   	k++;
   }
   while(i<=m)
   {
       tempArr[k]=arr[i];
       k++;
       i++;
   }
  for(i=0;i<sizeof(arr);i++)
   {
   	cout<<tempArr[i]<<", ";
   }
}

void merge(int arr[],int lower,int upper)
{
    int mid;
  if(lower<upper)
  {
    mid=(lower+upper)/2;
  }
  merge(arr,lower,mid);
  merge(arr,mid+1,upper);
  mergeSort(arr,lower,mid,upper);
}


int main()
{
  int arr[10]={5,4,3,2,8,6,5,1,3,9};
  merge(arr,0,10);
}
