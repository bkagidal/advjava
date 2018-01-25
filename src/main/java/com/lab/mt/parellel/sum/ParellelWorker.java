package com.lab.mt.parellel.sum;

public class ParellelWorker extends Thread{
	
	int low;
	int high;
	int[] nums;
	int partialSum =0;
	
	public ParellelWorker(int low,int high, int[] nums) {
		this.low = low;
		this.high = high;
		this.nums = nums;
	}
	
	

	@Override
	public void run() {
		
		for(int i=low;i<high;i++)
			partialSum = partialSum+nums[i];
	}
	
	public int getPartialSum(){
		return partialSum;
	}
}
