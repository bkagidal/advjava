package com.lab.mt.mine;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cell[] cells;
	private int numberofMines;

	public Board() {
		initializeClass();
		setLayout(new GridLayout(Constants.BOARD_ROWS, Constants.BOARD_COLUMNS));
		initializeBoard();
	}

	public synchronized void incrimentBombNUmber() {
		this.numberofMines++;
	}

	public synchronized void decrementBombNUmber() {
		this.numberofMines--;
	}

	private void initializeBoard() {

		for (int i = 0; i < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; i++) {
			cells[i] = new Cell(i + 1);
			add(cells[i]);

			int row = (i / Constants.BOARD_ROWS) % 2;

			if (row == 0)
				cells[i].setBackground(i % 2 == 0 ? Color.GRAY : Color.WHITE);
			else
				cells[i].setBackground(i % 2 == 0 ? Color.WHITE : Color.GRAY);
		}

	}

	private void initializeClass() {
		this.cells = new Cell[Constants.BOARD_ROWS * Constants.BOARD_COLUMNS];
		this.numberofMines = 0;
	}

	public void clearBoard() {

		for (int i = 0; i < Constants.BOARD_COLUMNS * Constants.BOARD_ROWS; i++) {
			//cells[i] = new Cell(i + 1);
			//add(cells[i]);

			int row = (i / Constants.BOARD_ROWS) % 2;

			if (row == 0)
				cells[i].setBackground(i % 2 == 0 ? Color.GRAY : Color.WHITE);
			else
				cells[i].setBackground(i % 2 == 0 ? Color.WHITE : Color.GRAY);
		}

	}

	private void sleepThread(int duration) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getNumberOfMines() {
		return this.numberofMines;
	}
	
	public void setMine(int i){
		
		cells[i].lock();
		incrimentBombNUmber();
		cells[i].setBackground(Color.RED);
		cells[i].unLock();
		sleepThread(200);
		
	}
	
	public void sweepMine(int index){
		
		cells[index].lock();
		
		decrementBombNUmber();
		
		int row = (index / Constants.BOARD_ROWS) % 2;
		
		if(row ==0)
			cells[index].setBackground(index%2 ==0 ? Color.GRAY:Color.WHITE);
		else
			cells[index].setBackground(index%2 ==0 ? Color.WHITE:Color.GRAY);
		
		cells[index].unLock();
		
		sleepThread(200);
	}

}
