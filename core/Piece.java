package core;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Piece {
	protected ImageIcon image;
	protected Tile tile;
	protected PieceColor piececolor;
	protected TileManager tilemanager;
	protected ArrayList<Tile> availableMoves;
	
	public Piece(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		this.image = image;
		this.tile = tile;
		this.piececolor = piececolor;
		this.tilemanager = tilemanager;
		availableMoves = new ArrayList<Tile>();
	}
	
	public void draw(Graphics2D graphics) {
		Point p = tile.getLocation();
		image.paintIcon(null, graphics, p.x, p.y);
		
	}
	
	public PieceColor returnPieceColor() {
		return piececolor;
	}
	
	public void emptyMoves() {
		for(Tile tile : availableMoves) {
			tile.setAvailableMove(false);
		}
		availableMoves.clear();
		
	}
	
	public abstract void showAvailableMoves();

	public abstract void move();
	
}
