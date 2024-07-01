package core;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private Player user;
	private Player ai;
	private GameBoard gameboard;
	private TileManager tilemanager;
	private Player upNext;
	
	public Game(GameBoard gameboard, TileManager tilemanager) {
		this.gameboard = gameboard;
		this.tilemanager = tilemanager;
		
		user = new Player(PieceColor.White, tilemanager, this);
		ai = new Player(PieceColor.Black, tilemanager, this);
		
		upNext = user;

	}

	public void update() {

	}

	public void draw(Graphics2D graphics) {
		user.draw(graphics);
		ai.draw(graphics);
	}
	
	public void nextTurn() {
		//	swap turn
		if(upNext == user)
			upNext = ai;
		else if(upNext == ai)
			upNext = user;
		
		//	enable/disable mouse
		if(upNext == ai) {
			gameboard.disableMouse();
			ai.computeMove();
		}
		else if(upNext == user)
			gameboard.enableMouse();
		
	}
}
