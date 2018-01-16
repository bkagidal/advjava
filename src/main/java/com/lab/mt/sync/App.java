package com.lab.mt.sync;




public class App {
	
	private static int counter=0;
	
	public static synchronized void incriment(){
		++counter;
	}
	public static  void process(){
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<2000;i++){
					incriment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<200;i++){
					incriment();
				}
			}
		});	
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		process();
		System.out.println(counter);
	}

}
