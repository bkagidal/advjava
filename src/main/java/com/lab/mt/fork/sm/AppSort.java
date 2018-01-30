package com.lab.mt.fork.sm;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class AppSort {

	public static void main(String[] args) {

		int[] nums,nums1;

		nums = initializeData();
		nums1= new int[nums.length];
		
		System.out.println("Before Sort :");
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
			nums1[i] = nums[i];
		}
		
		/*SequencialMergeSort sort = new SequencialMergeSort(nums);
		sort.mergeSort(0, nums.length-1);*/
		Sequencial seq = new Sequencial();
		seq.mergeSort(nums);
		System.out.println("\nSorted");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		
		System.out.println("\nParelle");
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParellelMergeSortTask task = new ParellelMergeSortTask(nums1);
		
		pool.invoke(task);
		System.out.println("\nSorted");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		
		

	}

	private static int[] initializeData() {

		int[] nums = new int[5];
		Random random = new Random();

		for (int i = 0; i < nums.length; i++)
			nums[i] = random.nextInt(20);

		return nums;
	}

}
