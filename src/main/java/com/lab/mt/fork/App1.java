package com.lab.mt.fork;

import java.util.concurrent.ForkJoinPool;

public class App1 {
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		SimpleRecusiveTask task = new SimpleRecusiveTask(120);
		
		System.out.println(pool.invoke(task));
	}
}
