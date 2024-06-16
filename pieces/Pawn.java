package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Tile;
import core.TileManager;

public class Pawn extends Piece{
	private boolean firstMove;

	public Pawn(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		super(image, tile, piececolor, tilemanager);
		firstMove = true;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		System.out.println("HEHEHE");
		
		if(piececolor == piececolor.White) {
			//	one step forward
			nextTileNumber = currentTileNumber - 8;
			if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber - 16;
				if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
				
		}
		else if(piececolor == piececolor.Black) {
			//	one step forward
			nextTileNumber = currentTileNumber + 8;
			if(nextTileNumber < 65 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber + 16;
				if(nextTileNumber < 65 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
		}
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
	}

}
