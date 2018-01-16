package com.lab.mt.syncbl;

import java.util.concurrent.locks.Lock;

public class App {
	
	private static int count1 = 0;
	private static int count2 = 0;
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	
	public   static void add(){
		synchronized (lock1) {
			count1++;
		}
		
	}
	
	public  static void addAgain(){
		synchronized (lock2) {
			count2++;
		}
	}
	
	public static void compute(){
	
		for(int i=0;i<10000;i++){
			add();
			addAgain();
		}
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				//System.out.println("IN T1");
				compute();
				
			}
		});
		
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//System.out.println("IN T2");
				compute();
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
		
		System.out.println("Counter1="+count1+" - Counter2="+count2);
	}
	

}