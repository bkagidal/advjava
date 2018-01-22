package com.lab.mt.pq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstWorker implements Runnable{
	
	BlockingQueue<String> blockingQueue;
	
	public FirstWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
	
		try {
			blockingQueue.add("H");
			//Thread.sleep(2000);
			blockingQueue.add("C");
			//Thread.sleep(1000);
			blockingQueue.add("J");
			//Thread.sleep(1000);
			blockingQueue.add("L");
			//Thread.sleep(3000);
			blockingQueue.add("I");
			blockingQueue.add("Z");
			//Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class SecondWorker implements Runnable{
	
	BlockingQueue<String> blockingQueue;
	
	public SecondWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	
	@Override
	public void run() {
	
		try {
			Thread.sleep(5000);
			System.out.println(blockingQueue.take());
			//Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			//Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			//Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			//System.out.println(blockingQueue.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


public class App {
	
	
	public static void main(String[] args) {
		
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		
		new Thread( new FirstWorker(queue)).start();
		
		new Thread(new SecondWorker(queue)).start();
		
	}
	

}
