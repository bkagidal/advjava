package com.lab.mt.sl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	
	public static void main(String[] args) {
		
		Book[] books = new Book[Constant.NUMBER_OF_BOOKS];
		Student[] students = new Student[Constant.NUMBER_OF_STUDENTS];
		
		for(int i=0;i<Constant.NUMBER_OF_BOOKS;i++)
			books[i] = new Book(i);
		
		for(int i=0;i<Constant.NUMBER_OF_STUDENTS;i++)
			students[i] = new Student(i,books);
		
		ExecutorService executorService = Executors.newFixedThreadPool(Constant.NUMBER_OF_STUDENTS);
		
		for(int i=0;i<Constant.NUMBER_OF_STUDENTS;i++)
			executorService.execute(students[i]);
		
		
	}

}
