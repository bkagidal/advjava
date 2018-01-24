package com.lab.mt.mine;

import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class MainFrame extends JFrame implements ButtonListener{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Toolbar toolbar;
	private Board board;
	private ExecutorService layersExecutor;
	private ExecutorService sweepersExecutor;
	private MineLayer[] mineLayers;
	private MineSweeper[] mineSweepers;
	
	public MainFrame() {
		
		super(Constants.APP_NAME);
		
		toolbar = new Toolbar();
		board = new Board();
		
		initializeVariables();
		
		toolbar.setListener(this);
		add(toolbar,BorderLayout.NORTH);
		add(board,BorderLayout.CENTER);
		setSize(Constants.BOARD_WIDTH,Constants.BOARD_HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	private void initializeVariables() {
		
		mineLayers = new MineLayer[Constants.NUMBER_OF_LAYERS];
		mineSweepers = new MineSweeper[Constants.NUMBER_OF_SWEEPERS];
		
	}



	@Override
	public void startClicked() {
		
		this.layersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_LAYERS);
		this.sweepersExecutor = Executors.newFixedThreadPool(Constants.NUMBER_OF_SWEEPERS);
		
		try{
			
				for(int i=0;i<Constants.NUMBER_OF_LAYERS;i++){
					mineLayers[i] = new MineLayer(i,board);
					layersExecutor.execute(mineLayers[i]);
				}
				
				for(int i=0;i<Constants.NUMBER_OF_SWEEPERS;i++){
					mineSweepers[i] = new MineSweeper(i,board);
					sweepersExecutor.execute(mineSweepers[i]);
				}
					
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			layersExecutor.shutdown();
			sweepersExecutor.shutdown();
		}
	}

	@Override
	public void stopClicked() {
		
		for(MineLayer mineLayer:mineLayers)
			mineLayer.setLayerMining(false);
		
		for(MineSweeper mineSweeper:mineSweepers)
			mineSweeper.setSweepRunning(false);
		
		
		layersExecutor.shutdown();
		sweepersExecutor.shutdown();
		//this.board.clearBoard();
		try {
			layersExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
			sweepersExecutor.awaitTermination(500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.board.clearBoard();
		}
		
		layersExecutor.shutdownNow();
		sweepersExecutor.shutdownNow();
		this.board.clearBoard();
	}

}
