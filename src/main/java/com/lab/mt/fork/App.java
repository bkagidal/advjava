package com.lab.mt.fork;

import java.util.concurrent.ForkJoinPool;

public class App {
	
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		
		SimpleRecursiveAction action = new SimpleRecursiveAction(150);
		
		pool.invoke(action);
		
	}

}
