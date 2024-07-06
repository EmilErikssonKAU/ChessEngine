package core;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import enums.TileColor;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Tile {
	private int tileNumber;
	private TileColor tilecolor;
	private int width_pixels;
	private int height_pixels;
	private int x_coordinate;
	private int y_coordinate;
	private boolean hovered;
	private boolean selected;
	private boolean availableMove;
	private Piece occuppier;
	
	public Tile(int tileNumber, TileColor tilecolor, int x_coordinate, int y_coordinate, int width_pixels, int height_pixels) {
		this.tileNumber = tileNumber;
		this.tilecolor = tilecolor;
		this.x_coordinate = x_coordinate;
		this.y_coordinate = y_coordinate;
		this.width_pixels = width_pixels;
		this.height_pixels = height_pixels;
		this.hovered = false;
		this.selected = false;
		this.availableMove = false;
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x_coordinate, y_coordinate, width_pixels, height_pixels);
	}
	
	public Point getLocation() {
		return new Point(x_coordinate, y_coordinate);
	}
	
	public boolean getHovered() {
		return hovered;
	}
	
	public void setHovered(boolean bool) {
		hovered = bool;
	}
	
	public void setSelected(boolean bool){
		
		selected = bool;
		//	deselect
		if(!selected) {
			Piece p = returnOccuppier();
			if(p != null)
				p.emptyMoves();
		}
		
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void enterPiece(Piece piece) {
		occuppier = piece;
	}
	
	public void exitPiece() {
		occuppier = null;
	}
	
	public void capturePiece(Piece piece) {
		occuppier.die();
		exitPiece();
		enterPiece(piece);
	}
	
	public int getOccuppierValue() {
		//	king	- 1000
		//	queen	- 10
		//	rook	- 5
		//	bishop	- 3
		//	knight	- 3
		//	pawn 	- 1
		
		if(occuppier instanceof King)
			return 1000;
		if(occuppier instanceof Queen)
			return 10;
		if(occuppier instanceof Rook)
			return 5;
		if(occuppier instanceof Knight)
			return 3;
		if(occuppier instanceof Bishop)
			return 3;
		if(occuppier instanceof Pawn)
			return 1;
		return 0;	
					
	}
	
	public Piece returnOccuppier() {
		return occuppier;
	}
	
	public boolean hasFriendlyPiece(Piece p) {
		if(occuppier == null)
			return false;
		else if(occuppier.isFriendly(p))
			return true;
		else
			return false;
	}
	
	public boolean hasHostilePiece(Piece p) {
		if(occuppier == null)
			return false;
		else if(occuppier.isHostile(p))
			return true;
		else
			return false;

	}
	
	public int getTileNumber() {
		return tileNumber;
	}
	
	public void setAvailableMove(boolean bool) {
		availableMove = bool;
	}
	
	public boolean getAvailableMove() {
		return availableMove;
	}
	
	public void draw(Graphics2D graphics){
		if(selected) {
			graphics.setColor(Color.cyan);
			Piece p = returnOccuppier();
			if(p != null)
				p.showAvailableMoves();
		}
		else if(availableMove) {
			if(returnOccuppier() == null)
				graphics.setColor(Color.green);
			else
				graphics.setColor(Color.red);
		}
		else if(hovered)
			graphics.setColor(Color.yellow);
		else if(tilecolor == TileColor.White)
			graphics.setColor(Color.white);
		else if(tilecolor == TileColor.Black)
			graphics.setColor(Color.black);
		graphics.fillRect(x_coordinate, y_coordinate, width_pixels, height_pixels);
		
	}

}
