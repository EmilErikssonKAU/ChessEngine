package pieces;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Tile;
import core.TileManager;

public class Rook extends Piece{

	public Rook(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		super(image, tile, piececolor, tilemanager);
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		
		//	upwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber - 8*i;
			if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			else
				break;
		}
		
		//	downwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + 8*i;
			if(nextTileNumber < 65 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			else
				break;
		}
		
		//	rightwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber + i;
			if(nextTileNumber % 8 != 1 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			else
				break;
		}
		
		//	leftwards
		for(int i=1; i<8; i++){
			nextTileNumber = currentTileNumber - i;
			if(nextTileNumber % 8 != 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null) {
				availableMoves.add(tilemanager.getTile(nextTileNumber));
			}
			else
				break;
		}
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
		
	}

}
