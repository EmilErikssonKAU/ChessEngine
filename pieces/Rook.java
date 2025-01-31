package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.Player;
import core.Tile;
import core.TileManager;
import enums.PieceColor;

public class Rook extends Piece{

	public Rook(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager, Player owner) {
		super(image, tile, piececolor, tilemanager, owner);
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
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
		
	}

}
