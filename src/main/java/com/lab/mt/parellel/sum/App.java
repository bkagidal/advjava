package com.lab.mt.parellel.sum;

import java.util.Random;

public class App {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int nums[] = new int[100000000];
		
		for(int i=0;i<nums.length;i++)
			nums[i] = random.nextInt(400);
		
		SequencialSum sequencial = new SequencialSum();
		
		long start = System.currentTimeMillis();
		System.out.println(sequencial.sum(nums));
		System.out.println("Sequencial Time : "+(System.currentTimeMillis()-start)+" ms ");
		
		int noOfThreads = Runtime.getRuntime().availableProcessors();
		
		ParellelSum psum = new ParellelSum(noOfThreads);
		start = System.currentTimeMillis();
		System.out.println( psum.sum(nums));
		System.out.println("Parellel Time : "+(System.currentTimeMillis()-start)+" ms ");
		
	}

}
