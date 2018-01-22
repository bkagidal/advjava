package com.lab.mt.dp;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	private int id;
	private Lock lock;
	
	public ChopStick(int id) {
		this.id=id;
		lock = new ReentrantLock();

	}
	
	public boolean pickUp(Philosopher philosppher,State state) throws InterruptedException{
		
		if(lock.tryLock(10, TimeUnit.MILLISECONDS)){
			
			System.out.println(philosppher +" picked up "+state.toString()+ this);
			return true;
		}
		
		return false;
	}
	
	
	public void putDown(Philosopher philosppher,State state) {
		lock.unlock();
		System.out.println(philosppher + " put down "+state.toString()+ this);
	}

	@Override
	public String toString() {
		return " ChopStick "+id;
	}
}
