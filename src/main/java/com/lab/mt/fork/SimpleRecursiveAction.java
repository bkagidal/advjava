package com.lab.mt.fork;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int simulateWork;
	
	public SimpleRecursiveAction(int simulateWork) {
		
		this.simulateWork = simulateWork;

	}

	@Override
	protected void compute() {
		
		if(simulateWork>100){
			
			System.out.println("Parellel Execution Start");
			
			SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulateWork/2);
			SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulateWork/2);
			
			action1.fork();
			action2.fork();
			
		}else
			System.out.println("No Need of Parellel Execution "+simulateWork);
	}

}
