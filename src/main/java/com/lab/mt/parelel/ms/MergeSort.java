package com.lab.mt.parelel.ms;

public class MergeSort {

	private int[] nums;
	int[] tempArray;

	public MergeSort(int[] nums) {
		this.nums = nums;
		tempArray = new int[nums.length];
	}

	public void parelleSort(int low, int high, int noofThreads) {

		if (noofThreads <=1) {
			mergeSort(low, high);
			return;
		}

		int middle = (low + high) / 2;

		Thread leftArray = mergeSortParallel(low, middle, noofThreads);
		Thread rightArray = mergeSortParallel(middle+1 ,high, noofThreads);

		leftArray.start();
		rightArray.start();

		try {
			leftArray.join();
			rightArray.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		merge(low, middle, high);
	}

	private Thread mergeSortParallel(int low, int high, int noofThreads) {

		return new Thread() {

			@Override
			public void run() {

				parelleSort(low, high, noofThreads/2);

			}
		};
	}

	public void mergeSort(int low, int high) {

		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;

		mergeSort(low, middle);
		mergeSort(middle + 1, high);

		merge(low, middle, high);

	}

	private void merge(int low, int middle, int high) {

		for (int i = low; i <= high; i++)
			tempArray[i] = nums[i];

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {

			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			} else {
				nums[k] = tempArray[j];
				j++;
			}

			k++;
		}

		while (i <= middle) {

			nums[k] = tempArray[i];
			k++;
			i++;
		}

		while (j <= high) {
			nums[k] = tempArray[j];
			k++;
			j++;
		}

	}

	public void showResult() {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
	}
}
