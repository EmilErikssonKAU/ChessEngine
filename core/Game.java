package core;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	private Player user;
	private Player ai;
	private GameBoard gameboard;
	private TileManager tilemanager;
	
	public Game(GameBoard gameboard, TileManager tilemanager) {
		this.gameboard = gameboard;
		this.tilemanager = tilemanager;
		
		user = new Player(PieceColor.White, tilemanager);
		ai = new Player(PieceColor.Black, tilemanager);

	}

	public void update() {

	}

	public void draw(Graphics2D graphics) {
		user.draw(graphics);
		ai.draw(graphics);
	}
}
