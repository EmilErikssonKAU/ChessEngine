package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Player;
import core.Tile;
import core.TileManager;

public class Pawn extends Piece{

	public Pawn(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager, Player owner) {
		super(image, tile, piececolor, tilemanager, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int passedTileNumber;
		int nextTileNumber;
		
		if(piececolor == piececolor.White) {
			//	one step forward
			nextTileNumber = currentTileNumber - 8;
			if(nextTileNumber > 0 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber - 16;
				passedTileNumber = nextTileNumber + 8;
				if(nextTileNumber > 0 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this) && tilemanager.getTile(passedTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
				
		}
		else if(piececolor == piececolor.Black) {
			//	one step forward
			nextTileNumber = currentTileNumber + 8;
			if(nextTileNumber < 65 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber + 16;
				passedTileNumber = nextTileNumber - 8;
				if(nextTileNumber < 65 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this) && tilemanager.getTile(passedTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
		}
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
	}

}
