package com.lab.mt.excha;

import java.util.concurrent.Exchanger;

class FirstWorker implements Runnable {

	private int count = 0;
	private Exchanger<Integer> exchanger;

	public FirstWorker(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		while (true) {
			count = count + 1;
			System.out.println("FirstWorker increments :" + count);

			try {
				count=exchanger.exchange(count);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class SecondWorker implements Runnable {

	private int count = 0;
	private Exchanger<Integer> exchanger;

	public SecondWorker(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {

		while (true) {
			try {

				count = count - 1;
				System.out.println("SecondWorker decrements :" + count);
				count = exchanger.exchange(count);
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			try {
				exchanger.exchange(count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class App {

	public static void main(String[] args) {
		Exchanger<Integer> exchanger = new Exchanger<>();

		new Thread(new FirstWorker(exchanger)).start();
		new Thread(new SecondWorker(exchanger)).start();
	}

}
