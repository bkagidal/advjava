package com.lab.mt.wait;

class Processor {
	
	public void produce(){
		
		synchronized (this) {
			System.out.println("We are in producer method...");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Again produce method...");
		}
	}
	
	public void consume() throws InterruptedException{
		Thread.sleep(1000);
		
		synchronized (this) {
			System.out.println("Consume method...");
			notify();
			Thread.sleep(3000);
		}
		
	}

}

public class App{
	
	public static void main(String[] args) {
		Processor process = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process.produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
