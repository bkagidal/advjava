package com.lab.mt.mine;

import java.util.Random;

public class MineLayer implements Runnable{
	
	private int id;
	private Board board;
	private  volatile boolean layerMining;
	
	public MineLayer(int id,Board board) {
		this.id = id;
		this.board = board;
		this.layerMining = true;
	}

	@Override
	public void run() {
		
		Random randam = new Random();
		
		while(layerMining){
			
			if(Thread.currentThread().isInterrupted())
				return;
			
			int index = randam.nextInt(Constants.BOARD_COLUMNS*Constants.BOARD_ROWS);
			board.setMine(index);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	

	public void setLayerMining(boolean layerMining) {
		this.layerMining = layerMining;
	}

}
