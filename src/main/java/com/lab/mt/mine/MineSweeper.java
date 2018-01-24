package com.lab.mt.mine;

import java.util.Random;

public class MineSweeper implements Runnable{
	
	private int id;
	private Board board;
	private  volatile boolean sweepRunning;
	
	public MineSweeper(int id, Board board) {
		this.id = id;
		this.board = board;
		this.sweepRunning = true;
	}

	@Override
	public void run() {
		
		Random randam = new Random();
		
		while(sweepRunning){
			
			if(Thread.currentThread().isInterrupted())
				return;
			
			int index = randam.nextInt(Constants.BOARD_COLUMNS*Constants.BOARD_ROWS);
			board.sweepMine(index);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	public void setSweepRunning(boolean sweepRunning) {
		this.sweepRunning = sweepRunning;
	}

}
