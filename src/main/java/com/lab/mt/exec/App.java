package com.lab.mt.exec;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class App {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<5;i++){
			executorService.submit(new Worker());
		}
		
		executorService.shutdown();
	}

}
