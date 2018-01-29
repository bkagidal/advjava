package com.lab.mt.fork.sm;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {
	
	public static int THRESHOLD=0;
	
	public static void main(String[] args) {
		
		int[] nums;
		nums = intializeData();
		
		System.out.println(nums.length);
		THRESHOLD = nums.length/Runtime.getRuntime().availableProcessors();
		
		SequencialMaxFinding seq = new SequencialMaxFinding();
		ParellelMaxFinding par = new ParellelMaxFinding(nums, 0, nums.length);
		
		
		System.out.println("SequencialMax");
		long start = System.currentTimeMillis();
		System.out.println(seq.sequencialMax(nums));
		System.out.println("Sequncial Time :"+ (System.currentTimeMillis()-start));
		
		System.out.println();
		System.out.println("Parellel Max");
		start = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		System.out.println(pool.invoke(par));
		System.out.println("Parellel Time :"+(System.currentTimeMillis()-start));
		
		
		
		
		
		
		
	}

	private static int[] intializeData() {
		int[] nums = new int[500000000];
		Random random = new Random();
		
		for(int i=0;i<nums.length;i++)
			nums[i] = random.nextInt(1000000);
		
		return nums;
	}

}
