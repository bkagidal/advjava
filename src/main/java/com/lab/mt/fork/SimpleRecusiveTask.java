package com.lab.mt.fork;

import java.util.concurrent.RecursiveTask;

public class SimpleRecusiveTask extends RecursiveTask<Integer>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int simulatedWork;
	
	public SimpleRecusiveTask(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected Integer compute() {
		
		if(simulatedWork>100){
			System.out.println("Parellel Execution is needed Because of Huge Task.."+simulatedWork);
			
			SimpleRecusiveTask task1 = new SimpleRecusiveTask(simulatedWork/2);
			SimpleRecusiveTask task2 = new SimpleRecusiveTask(simulatedWork/2);
			
			task1.fork();
			task2.fork();
			
			int solution =0; 	
			
			solution+=task1.join();
			solution+=task2.join();
			
			return solution;
		}else{
			System.out.println("No Need for Parellel Execution ...."+simulatedWork);
			return 2*simulatedWork;
		}
		
	}

}
