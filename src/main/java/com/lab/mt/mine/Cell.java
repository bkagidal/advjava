package com.lab.mt.mine;

import java.awt.GridBagLayout;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;

public class Cell  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Lock lock;
	private State state;
	private boolean hasBomb;
	
	public Cell(int id){
		initVariables(id);
		setLayout(new GridBagLayout());
	}

	private void initVariables(int id) {
		this.id=id;
		this.lock = new ReentrantLock();
		this.state = State.EMPTY;
		this.hasBomb = false;
	}
	
	public void lock(){
		try {
			
			lock.tryLock(10, TimeUnit.HOURS);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void unLock(){
		lock.unlock();
	}
	
	@Override
	public String toString() {
		return this.id+"-"+state.toString()+" has Bomb";
	}
}
