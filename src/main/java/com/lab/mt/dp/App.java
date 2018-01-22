package com.lab.mt.dp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = null;
		Philosopher[] philosophers = null;

		try {

			philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
			ChopStick[] chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICS];

			for (int i = 0; i < Constants.NUMBER_OF_CHOPSTICS; i++)
				chopSticks[i] = new ChopStick(i);

			executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

			for (int i = 0; i < Constants.NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % Constants.NUMBER_OF_CHOPSTICS]);
				executorService.execute(philosophers[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);

			for (Philosopher p : philosophers)
				p.setFull(true);
			
		} finally {
			executorService.shutdown();
			
			while(!executorService.isTerminated())
				Thread.sleep(1000);
			
			for(Philosopher p: philosophers)
				System.out.println(p+" eats "+ p.getCounter());
		}

	}
}
