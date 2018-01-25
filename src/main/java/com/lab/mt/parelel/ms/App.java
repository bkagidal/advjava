package com.lab.mt.parelel.ms;

import java.util.Random;

public class App {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int[] nums = new int[10];
		
		for(int i=0;i<nums.length;i++)
			nums[i] = random.nextInt(1000)-500;
		
		System.out.print("Array  :");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		
		MergeSort sort = new MergeSort(nums);
		
		sort.mergeSort(0, nums.length-1);
		System.out.print("\nSorted :");
		sort.showResult();
	}

}
