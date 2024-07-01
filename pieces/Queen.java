package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Tile;
import core.TileManager;

public class Queen extends Piece{

	public Queen(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		super(image, tile, piececolor, tilemanager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		
		//	upwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber - 8*i;
			if(nextTileNumber > 0 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;
		}
		
		//	downwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + 8*i;
			if(nextTileNumber < 65 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;
		}
		
		//	rightwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + i;
			if(nextTileNumber % 8 != 1 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;
		}
		
		//	leftwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber - i;
			if(nextTileNumber % 8 != 0 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
				if(tilemanager.getTile(nextTileNumber).returnOccuppier() != null)
					break;
			}
			else
				break;
		}
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
			if(nextTileNumber < 65 && nextTileNumber % 8 != 0  && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this)) {
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
