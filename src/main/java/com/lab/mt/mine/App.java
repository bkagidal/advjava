package com.lab.mt.mine;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) {
		try{
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MainFrame();
				
			}
		});
	}
}
