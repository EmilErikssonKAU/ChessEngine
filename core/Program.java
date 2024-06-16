package core;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

public class Program extends JFrame {
	private GameBoard board;
	private Keyboard keyboard;
	private MouseHandler mousehandler;
	private final int FPS = 40; 
	
	public Program() {
		board = new GameBoard();
		keyboard = new Keyboard();
		mousehandler = new MouseHandler(this);
		add(board);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		this.addMouseListener(mousehandler);
		this.addMouseMotionListener(mousehandler);
		
		//	Start main loop
		this.start();
	}
	
	@Override
	public Dimension getPreferredSize() {
		//	The bar is presumably 30 pixels high, no idea about extra 10 pixels in width
		return new Dimension(810, 830);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}
	
	public void processMouseClick(int x, int y) {
		board.processMouseClick(x,y);
	}
	
	public void processMouseMovement(int x, int y) {
		board.processMouseMovement(x,y);
	}
	

	public static void main(String[] args) {
		Program program = new Program();
	}
	
	public void start() {
		while(true) {
			//	Delay
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//	Actions
			board.update();
			board.repaint();
		}
	}

}
