package core;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class TileManager {
	private ArrayList <Tile> tiles;
	private int width_tiles;
	private int height_tiles;
	private int numberOfTiles;
	
	private int tile_width_pixels;
	private int tile_height_pixels;
	
	public TileManager(int width_tiles, int tile_width_pixels) {
		this.width_tiles = width_tiles;
		this.height_tiles = width_tiles;
		this.numberOfTiles = width_tiles*width_tiles;
		
		this.tile_width_pixels = tile_width_pixels;
		this.tile_height_pixels = tile_width_pixels;
		
		//	initialize tiles
		tiles = new ArrayList<Tile>(numberOfTiles);
		TileColor tileColor = TileColor.White;
		
		for(int i=0; height_tiles > i; i++) {
			for(int j=1; width_tiles+1 > j; j++ ) {
				//	change tilecolor
				if(j% 8 == 1)
					;
				else if(tileColor == TileColor.White)
					tileColor = TileColor.Black;
				else if (tileColor == TileColor.Black)
					tileColor = TileColor.White;
				
				int tileNumber = height_tiles*i + j;
				int tile_x_coordinate = tile_width_pixels * (j-1);
				int tile_y_coordinate = tile_height_pixels * i;
				tiles.add(new Tile(tileNumber, tileColor, tile_x_coordinate, tile_y_coordinate, tile_width_pixels, tile_height_pixels));
			}
		}
	}
	
	public Tile getTile(int tileNumber) {
		return tiles.get(tileNumber-1);
	}
	
	public void checkHover(int x, int y){
		Tile targetTile;
		for(Tile tile : tiles) {
			if(tile.getBounds().contains(new Point(x,y))) {
				tile.setHovered(true);
			}
			else
				tile.setHovered(false);
		}
	}
	
	public void checkClick(int x, int y) {
		//	check if click is on available move
		for(Tile tile : tiles) {
			if(tile.getBounds().contains(new Point(x,y))){
				if(tile.getAvailableMove()) {
					Tile t = getSelectedTile();
	
					// no tile is selected
					if(t == null)
						return;
					
					Piece p = t.returnOccuppier();
					
					// no piece in tile, probably unneccesary
					if(p == null)
						return;
					
					p.move(tile);
					t.exitPiece();
					deselectAll();
					return;
					
				}
			}
		}
		//	check if click is on friendly piece
		for(Tile tile: tiles) {
			if(tile.getBounds().contains(new Point(x,y))) {
				if(checkForFriendlyPiece(tile))
					selectTile(tile);
			}			
			else
				tile.setSelected(false);
				
		}
	}
	
	public boolean checkForFriendlyPiece(Tile tile) {
		if(tile.returnOccuppier() == null)
			return false;
		else if(tile.returnOccuppier().returnPieceColor() == PieceColor.White)		//temporary side selector
			return true;
		else
			return false;
		
	}
	
	public void deselectAll() {
		for(Tile tile: tiles) {
			tile.setSelected(false);
			tile.setAvailableMove(false);
		}
	}
	
	public void selectTile(Tile tile) {
		tile.setSelected(true);
	}
	
	public Tile getSelectedTile() {
		// return Tile; if there is selected tile
		// return null; if there is no selected tile
		
		for(Tile t: tiles) {
			if(t.getSelected()) {
				return t;
			}
		}
		//	no selected tile
		return null;
	}
	
	public void draw(Graphics2D graphics) {
		for(Tile tile: tiles) {
			tile.draw(graphics);
		}
	}
}
