package com.lab.chap1.sort;

import java.util.Scanner;

public class InsertionSirtTest {
	
	final static int MaxNumbers=5;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		int[] num = new int[MaxNumbers];
		
		System.out.print("Enter "+MaxNumbers+" numbers followed by 0 !: ");

		int n=0;
		int v = in.nextInt();
		
		while(v!=0 && n < MaxNumbers){
			num[n++] = v;
			v = in.nextInt();
		}
		
		if( v!=0){
			System.out.println("Entered more than "+MaxNumbers+" numbers");
			System.out.println("Considering first "+MaxNumbers+" numbers");
		}
		
		if(n==0){
			System.out.println("numbers not supplied");
			System.exit(1);;
		}
		
		insertionSort(num,n);
		
		System.out.println("Sorted numbers :");
		for(v=0;v<n;v++)System.out.print(num[v]+" ");
		in.close();
	}

	public static void insertionSort(int[] list,int n){
		
		for(int h=1;h<n;h++){
			
			int k = h-1;
			int key = list[h];
			
			while(k>=0 && key < list[k]){
				list[k+1] = list[k];
				--k;
			}
			
			list[k+1] = key;
			
		}
	}
}
