package pieces;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Tile;
import core.TileManager;

public class King extends Piece{

	public King(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		super(image, tile, piececolor, tilemanager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		
		//forward
		nextTileNumber = currentTileNumber - 8;
		if(nextTileNumber > 0 && tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//backward
		nextTileNumber = currentTileNumber + 8;
		if(nextTileNumber < 65 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//rightward
		nextTileNumber = currentTileNumber + 1;
		if(nextTileNumber % 8 != 1 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//leftward
		nextTileNumber = currentTileNumber - 1;
		if(nextTileNumber % 8 != 0 && !tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//left-upward
		nextTileNumber = currentTileNumber - 9;
		if(nextTileNumber % 8 != 0 && nextTileNumber > 0 &&!tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//right-upward
		nextTileNumber = currentTileNumber - 7;
		if(nextTileNumber % 8 != 1 && nextTileNumber > 0 &&!tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//left-downward
		nextTileNumber = currentTileNumber + 7;
		if(nextTileNumber % 8 != 0 && nextTileNumber < 65 &&!tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//right-downward
		nextTileNumber = currentTileNumber + 9;
		if(nextTileNumber % 8 != 1 && nextTileNumber < 65 &&!tilemanager.getTile(nextTileNumber).hasFriendlyPiece(this))
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
		
	}


}
