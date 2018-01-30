package com.lab.mt.fork.sm;

public class SequencialMergeSort {

	int[] nums;

	public SequencialMergeSort(int[] nums) {
		this.nums = nums;
	}

	public void mergeSort(int low, int high) {

		if (low >= high)
			return;

		int middle = (low + high) / 2;

		mergeSort(low, middle);
		mergeSort(middle + 1, high);
		merge(low, middle, high);
	}

	private void merge(int low, int middle, int high) {

		int i = low;
		int j = middle + 1;
		int k = low;
		int[] temp = new int[nums.length];

		for (int v = 0; v < nums.length; v++)
			temp[v] = nums[v];

		while (i <= middle && j <= high) {
			if (temp[i] < temp[j]) {
				nums[k++] = temp[i++];
			} else {
				nums[k++] = temp[j++];

			}

		}

		while (i <= middle)
			nums[k++] = temp[i++];

		while (j <= high)
			nums[k++] = temp[j++];
	}

}
