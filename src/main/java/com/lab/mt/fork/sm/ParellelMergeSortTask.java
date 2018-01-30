package com.lab.mt.fork.sm;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParellelMergeSortTask extends RecursiveAction{
	
	
	int[] nums;

	public ParellelMergeSortTask(int[] nums) {
		this.nums = nums;
	}
	
	@Override
	protected void compute() {
		
		if(nums.length < 10){
			mergeSort(nums);
			return;
		}
		
		
		int middle = nums.length/2;
		
		int[] left  = Arrays.copyOfRange(nums, 0, middle);
		int[] right = Arrays.copyOfRange(nums, middle, nums.length);
		
		ParellelMergeSortTask task1 = new ParellelMergeSortTask(left);
		ParellelMergeSortTask task2 = new ParellelMergeSortTask(right);
		
		invokeAll(task1,task2);
			
		merge(left, right, nums);
	}
	
	
	private void mergeSort(int[] nums){
	
		if(nums.length<=1)
			return;
		
		int middle = nums.length/2;
		
		int[] left = Arrays.copyOfRange(nums, 0, middle);
		int[] right = Arrays.copyOfRange(nums, middle, nums.length);
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left,right,nums);
	}

	private void merge(int[] left, int[] right, int[] original) {
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i < left.length && j< right.length){
			
			if(left[i] < right[j])
				original[k++] = left[i++];
			else
				original[k++] =right[j++];
		}
		
		while(i<left.length)
			original[k++] = left[i++];
		
		while(j<right.length)
			original[k++] = right[j++];
		
	}

}
