package com.lab.mt.fork.sm;

public class SequencialMaxFinding {

	public int sequencialMax(int[] nums) {

		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] > max)
				max = nums[i];
		}

		return max;
	}
}
