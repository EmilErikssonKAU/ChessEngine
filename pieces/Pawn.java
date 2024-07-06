package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.Player;
import core.Tile;
import core.TileManager;
import enums.PieceColor;

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
			if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber - 16;
				passedTileNumber = nextTileNumber + 8;
				if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null && tilemanager.getTile(passedTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
			//	capture left-upwards
			nextTileNumber = currentTileNumber - 9;
			if(nextTileNumber > 0 && nextTileNumber % 8 != 0&& tilemanager.getTile(nextTileNumber).hasHostilePiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			
			//	capture right-upwards
			nextTileNumber = currentTileNumber - 7;
			if(nextTileNumber > 0&& nextTileNumber % 8 != 1 && tilemanager.getTile(nextTileNumber).hasHostilePiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
				
		}
		else if(piececolor == piececolor.Black) {
			//	one step forward
			nextTileNumber = currentTileNumber + 8;
			if(nextTileNumber < 65 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			//	two steps forward
			if(firstMove) {
				nextTileNumber = currentTileNumber + 16;
				passedTileNumber = nextTileNumber - 8;
				if(nextTileNumber < 65 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null && tilemanager.getTile(passedTileNumber).returnOccuppier() == null)
					availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			
			//	capture left-downwards
			nextTileNumber = currentTileNumber + 7;
			if(nextTileNumber < 65 && nextTileNumber % 8 != 0 &&tilemanager.getTile(nextTileNumber).hasHostilePiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
			
			//	capture right-downwards
			nextTileNumber = currentTileNumber + 9;
			if(nextTileNumber < 65 && nextTileNumber % 8 != 1 && tilemanager.getTile(nextTileNumber).hasHostilePiece(this))
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			
		}
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
	}

}
