package pkg.bs;

import java.util.*;

public class BinarySearch {

	public static int binarySearch(int a[],int key,int left,int right)
	{
		if (left>right)
		{
			return -1;
		}
		
		int mid=(left+right)/2;
		
		if(a[mid]==key)
		{
			return mid;
		}
		else if (a[mid]>key)
		{
			return binarySearch(a,key,left,mid-1);
		}
		else
		{
			return binarySearch(a,key,mid+1,right);
		}
	}
	
	public static void print(int a[])
	{
		for (int i=0;i<a.length;++i)
		{
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Array Size: ");
		
		int size=in.nextInt();
		
		int a[]=new int[size];
		
		Random rn=new Random();
		
		for (int i=0;i<a.length;++i)
		{
			int temp=rn.nextInt(100);
			a[i]=temp;
		}
		
		Arrays.sort(a);
		print(a);
		
		System.out.println("\nEnter number to search: ");
		int toSearch=in.nextInt();
		
		if (binarySearch(a,toSearch,0,a.length-1)<0)
		{
			System.out.println(toSearch+" not found");
		}
		else
		{
			System.out.println("Found "+toSearch+" at index: "+binarySearch(a,toSearch,0,a.length-1));
		}
		
	}

}
