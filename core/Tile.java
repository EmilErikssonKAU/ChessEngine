package core;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

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
	
	public void enterPiece(Piece piece) {
		occuppier = piece;
	}
	
	public void exitPiece() {
		occuppier = null;
	}
	
	public Piece returnOccuppier() {
		return occuppier;
	}
	
	public int getTileNumber() {
		return tileNumber;
	}
	
	public void setAvailableMove(boolean bool) {
		availableMove = bool;
	}
	
	
	public void draw(Graphics2D graphics){
		if(selected) {
			graphics.setColor(Color.cyan);
			Piece p = returnOccuppier();
			p.showAvailableMoves();
		}
		else if(availableMove) {
			graphics.setColor(Color.green);
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
