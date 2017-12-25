package com.lab.chap1.sort;

import java.util.Scanner;

public class SelectionSort {
	
	final static int MaxNumbers = 5;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int[] num = new int[MaxNumbers];
		
		System.out.println("Enter "+ MaxNumbers+" Numbers followed by 0");
		
		int n=0;
		int v = in.nextInt();
		
		while(v!=0 && n<MaxNumbers){
			num[n++] = v;
			v= in.nextInt();
		}
	
		if(v!=0){
			System.out.println("More than "+MaxNumbers+" Numbers entered");
			System.out.println("First "+MaxNumbers+" used");
		}
		
		if(n ==0){
			System.out.println("No numbers supplied");
			System.exit(1);
		}
		
		
		selSort(num,0,n-1);
		
		System.out.println("The Sorted numbers are :");
		for(v=0;v<n;v++) System.out.print(num[v]+" ");
			
		in.close();
	}

	
	public static  void selSort(int[] num,int l,int h){
		
		for(int v=l;v<h;v++)
			swap(num,v,getSmallest(num,v,h));
	}
	
	public static void swap(int[] num,int v,int i){
		
		int hold = num[v];
		num[v] = num[i];
		num[i] = hold;
	}
	
	public static int getSmallest(int[] num,int lo,int hi){
		
		int small=lo;
		
		//s =i;
		for(int h=lo+1; h<=hi;h++)
			if(num[h]<num[small]) small =h;
		return small;
	}
}
