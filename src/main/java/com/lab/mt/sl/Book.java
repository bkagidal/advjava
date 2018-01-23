package com.lab.mt.sl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	
	private int id;
	Lock lock;
	
	public Book(int id) {
		this.id=id;
		this.lock = new ReentrantLock();
	}
	
	public void read(Student student) throws InterruptedException {
		//lock.tryLock(10, TimeUnit.MILLISECONDS);
		lock.lock();
		System.out.println(student +" reading the book "+this);
		Thread.sleep(1000);
		lock.unlock();
		System.out.println(student +" finished reading the book "+this);
	}
	
	
	@Override
	public String toString() {
		return "Book #"+id;
	}

}
