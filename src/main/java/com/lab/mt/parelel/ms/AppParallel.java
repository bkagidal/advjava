package com.lab.mt.parelel.ms;

import java.util.Random;

public class AppParallel {
	
	public static void main(String[] args) {
		
		int noOfThreads = Runtime.getRuntime().availableProcessors();

		System.out.println("Number Of Threads :" +noOfThreads);
		System.out.println();
		
		/*int nums[]={6,1,8,3,-5,23,-36,7,-300};
		
		MergeSort sort = new MergeSort(nums);
		sort.parelleSort(0, nums.length-1, noOfThreads);
		
		sort.showResult();
		*/
		
		int[] numbers = createRandamArray();
		
		MergeSort sort = new MergeSort(numbers);
		
		long startTime =System.currentTimeMillis();
		sort.parelleSort(0, numbers.length-1, noOfThreads);
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time for Parellel Sort :"+(endTime-startTime));
		
		System.out.println();
		//sort.showResult();
		
		startTime=System.currentTimeMillis();
		sort.mergeSort(0, numbers.length-1);
		endTime = System.currentTimeMillis();
		
		System.out.println("Time for Sequencial     :"+(endTime-startTime));
		
		System.out.println();
		//sort.showResult();
	}

	private static int[] createRandamArray() {
		
		Random random = new Random();
		int[] a = new int[8000000];
		
		for(int i=0;i<a.length;i++)
			a[i] = random.nextInt(100)-500;
		
		return a;
	}

}
