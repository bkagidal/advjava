package com.lab.mt.parellel.sum;

public class ParellelSum {

	private ParellelWorker[] sums;
	private int noOfThreads;

	public ParellelSum(int noOfThreads) {
		this.noOfThreads = noOfThreads;
		this.sums = new ParellelWorker[noOfThreads];
	}

	public int sum(int[] nums) {

		int steps = (int) Math.ceil(nums.length * 1.0 / noOfThreads);

		for (int i = 0; i < noOfThreads; i++) {

			sums[i] = new ParellelWorker(i * steps, (i + 1) * steps, nums);
			sums[i].start();

		}

		for (ParellelWorker worker : sums) {
			try {
				worker.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int total = 0;

		for (ParellelWorker worker : sums) {
			total += worker.getPartialSum();
		}

		return total;

	}

}
