package com.lab.mt.bq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable{
	
	private BlockingQueue<Integer> blockQueue;
    private int count;
    
	public FirstWorker(BlockingQueue<Integer> blockQueue) {
		this.blockQueue = blockQueue;

	}
	@Override
	public void run() {
		while(true){
			
			
			try {
				blockQueue.offer(count);
				System.out.println("Adding element :"+count);
				count++;
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}catch(IllegalStateException e){
				e.printStackTrace();
			}
		}
	}
}

class SecondWorker implements Runnable{
	
	private BlockingQueue<Integer> blockQueue;
    
	public SecondWorker(BlockingQueue<Integer> blockQueue) {
		this.blockQueue = blockQueue;

	}
	@Override
	public void run() {
		while(true){
			int ele;
			try {
				ele = blockQueue.take();
				System.out.println("Taken Element :"+ele);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}


public class App {
	
	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		FirstWorker fw = new FirstWorker(queue);
		SecondWorker sw = new SecondWorker(queue);
		
		new Thread(fw).start();
		new Thread(sw).start();
	}

}
