package com.lab.mt.vol;


class worker implements Runnable{
	
	private volatile boolean isTerminated = false;

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

	@Override
	public void run() {
		while(!isTerminated){
			System.out.println("Hello from worker class ....");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class App {

	public static void main(String[] args) {
		worker worker = new worker();
		Thread t1 = new Thread(worker);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		System.out.println("Finished");
		
		
	}
}
