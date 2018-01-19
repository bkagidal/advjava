package com.lab.mt.cycbar;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {

	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;

	public Worker(int id, CyclicBarrier cyclicBarrier) {
		this.id = id;
		this.cyclicBarrier = cyclicBarrier;
		this.random = new Random();
	}

	@Override
	public void run() {

		doWork();

	}

	private void doWork() {

		System.out.println("Thread with Id " + id + " started working....");

		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread with id " + id + " has finished");

		try {
			cyclicBarrier.await();
			System.out.println("After await");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

	}

}

public class App {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

			@Override
			public void run() {
				System.out.println("All Threads are finished...");
			}
		});

		for (int i = 0; i < 5; i++)
			executorService.execute(new Worker(i + 1, barrier));
		
		executorService.shutdown();

	}

}
