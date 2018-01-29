package com.lab.mt.fork.sm;

import java.util.concurrent.RecursiveTask;

public class ParellelMaxFinding extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	int[] nums;
	int lowIndex;
	int highIndex;

	public ParellelMaxFinding(int[] nums, int lowIndex, int highIndex) {

		this.nums = nums;
		this.lowIndex = lowIndex;
		this.highIndex = highIndex;

	}

	@Override
	protected Integer compute() {

		if ((highIndex-lowIndex) < App.THRESHOLD)
			return sequencialMax();
		else {

			int middleIndex = (lowIndex + highIndex) / 2;

			ParellelMaxFinding task1 = new ParellelMaxFinding(nums, lowIndex, middleIndex);
			ParellelMaxFinding task2 = new ParellelMaxFinding(nums, middleIndex + 1, highIndex);

			invokeAll(task1, task2);

			return Math.max(task1.join(), task2.join());
		}

		//return null;
	}

	private int sequencialMax() {

		int max = nums[lowIndex];

		for (int i = lowIndex + 1; i < highIndex; i++) {

			if (nums[i] > max)
				max = nums[i];
		}

		return max;
	}
}
