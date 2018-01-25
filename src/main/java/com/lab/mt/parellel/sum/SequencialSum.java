package com.lab.mt.parellel.sum;

public class SequencialSum {

	

	public int sum(int[] nums) {
		int total=0;
		
		for (int i = 0; i < nums.length; i++)
			total = total + nums[i];

		return total;
	}
}
