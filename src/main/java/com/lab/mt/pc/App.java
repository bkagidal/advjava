package com.lab.mt.pc;

import java.util.ArrayList;
import java.util.List;


class Processor{
	
	private List<Integer> list = new ArrayList<>();
	private final  int LIMIT = 5;
	private int BOTTOM = 0;
	private int value =0;
	
	Object lock = new Object();
	
	public  void produce() throws InterruptedException{
		
		synchronized (lock) {
			
			while(true){
				
				if(list.size() == LIMIT){
					System.out.println("Witing to be removed");
					lock.wait();
				}else{
					System.out.println("Adding :"+value);
					list.add(value);
					value++;
					lock.notify();
				}
				
				Thread.sleep(1000);
			}
			
		}
		
	}
	
	public  void consume() throws InterruptedException{
		
		synchronized (lock) {
			
			while(true){
				if(list.size() == BOTTOM){
					System.out.println("Waiting to add values..");
					lock.wait();
				}else{
					System.out.println("Removed :"+list.remove(--value));
					lock.notify();
				}
				Thread.sleep(1000);
			}
		}
	}
	
}
public class App {
	
	public static void main(String[] args) {
		
		Processor process = new Processor();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
