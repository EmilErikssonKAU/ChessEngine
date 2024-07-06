package pieces;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.Player;
import core.Tile;
import core.TileManager;
import enums.PieceColor;

public class Bishop extends Piece{

	public Bishop(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager, Player owner) {
		super(image, tile, piececolor, tilemanager, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		
		//left-upward
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber - i*9;
			if(nextTileNumber > 0 && nextTileNumber % 8 != 0  && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;			
		}
		
		//right-upward
		for(int i=1; i<8; i++) {
			nextTileNumber = currentTileNumber - i*7;
			if(nextTileNumber > 0 && nextTileNumber % 8 != 1  && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;	
		}
		
		//left-downward
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + i*7;
			if(nextTileNumber < 65 && nextTileNumber % 8 != 0  && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;			
		}
		
		//right-downward
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + i*9;
			if(nextTileNumber < 65 && nextTileNumber % 8 != 1  && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;			
		}		
		
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
		
	}


}
