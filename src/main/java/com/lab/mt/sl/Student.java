package com.lab.mt.sl;

import java.util.Random;

public class Student implements Runnable{
	
	private int id;
	Book[] books;
	Random randam;
	public Student(int id,Book[] books) {
		this.id=id;
		this.books = books;

	}
	
	@Override
	public void run() {
		randam = new Random();
		while(true){
			int bookid = randam.nextInt(Constant.NUMBER_OF_BOOKS);
			try {
				books[bookid].read(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Student #"+id;
	}

}
