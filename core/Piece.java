package core;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Piece {
	protected ImageIcon image;
	protected Tile tile;
	protected PieceColor piececolor;
	protected TileManager tilemanager;
	protected ArrayList<Tile> availableMoves;
	protected boolean firstMove;
	protected boolean alive;
	protected Player owner;
	
	public Piece(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager, Player owner) {
		this.image = image;
		this.tile = tile;
		this.piececolor = piececolor;
		this.tilemanager = tilemanager;
		this.owner = owner;
		firstMove = true;
		alive = true;
		availableMoves = new ArrayList<Tile>();
	}
	
	public void draw(Graphics2D graphics) {
		if(alive) {
			Point p = tile.getLocation();
			image.paintIcon(null, graphics, p.x, p.y);
		}
		
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
	
	public boolean isFriendly(Piece p) {
		if(p.returnPieceColor() == this.returnPieceColor())
			return true;
		else
			return false;
	}
	
	public boolean isHostile(Piece p) {
		if(p.returnPieceColor() == this.returnPieceColor())
			return false;
		else
			return true;
	}
	
	public Tile getRandomMove() {
		Random randomGenerator = new Random();
		Tile randomMove = availableMoves.get(randomGenerator.nextInt(availableMoves.size()));
		return randomMove;
		
	}
	
	public int getNumberOfAvailableMoves() {
		//	requires showAvailableMoves to be run beforehand
		return availableMoves.size();
	}
	
	
	public void die() {
		owner.deletePiece(this);
		alive = false;
	}

	public void move(Tile t) {
		tile = t;
		if(t.returnOccuppier() != null)
			tile.capturePiece(this);
		else
			tile.enterPiece(this);
		firstMove = false;
		owner.passTurn();
	}
	
	public int testMove(Tile t) {
		return t.getOccuppierValue();
	}
	
	public abstract void showAvailableMoves();
	
	public TileScorePair getBestMove() {
		//	requires showAvailableMoves to be run beforehand
		//	returns tile with highest value piece to capture, or null if no tile allows capture
		Tile highestTile = null;
		int highest = 0;
		int test;
		
		for(Tile t: availableMoves) {
			test = testMove(t);
			if(test > highest) {
				highest = test;
				highestTile = t;
			}
		}
		return new TileScorePair(highestTile, highest);
	}
}
