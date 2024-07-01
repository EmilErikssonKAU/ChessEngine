package pieces;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import core.Piece;
import core.PieceColor;
import core.Tile;
import core.TileManager;

public class Knight extends Piece{

	public Knight(ImageIcon image, Tile tile, PieceColor piececolor, TileManager tilemanager) {
		super(image, tile, piececolor, tilemanager);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void showAvailableMoves() {
		int currentTileNumber = tile.getTileNumber();
		int nextTileNumber;
		
		//	  +
		//	1++
		nextTileNumber = currentTileNumber - 6;
		if(nextTileNumber > 0 && nextTileNumber % 8 != 1 && nextTileNumber % 8 != 2 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));
		
		//	1++
		//	  +
		nextTileNumber = currentTileNumber + 10;
		if(nextTileNumber < 65 && nextTileNumber % 8 != 1 && nextTileNumber % 8 != 2 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	
	
		//	+
		//	++1
		nextTileNumber = currentTileNumber - 10;
		if(nextTileNumber > 0 && nextTileNumber % 8 != 0 && nextTileNumber % 8 != 7 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	
		
		
		//	++1
		//	+
		nextTileNumber = currentTileNumber + 6;
		if(nextTileNumber < 65 && nextTileNumber % 8 != 0 && nextTileNumber % 8 != 7 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));			
		
		//	++
		//	 +
		//	 1
		nextTileNumber = currentTileNumber - 17;
		if(nextTileNumber > 0 && nextTileNumber % 8 != 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	
		
		
		//	++
		//	+
		//	1
		nextTileNumber = currentTileNumber - 15;
		if(nextTileNumber > 0 && nextTileNumber % 8 != 1 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	
		
		
		//	1
		//	+ 
		//  ++
		nextTileNumber = currentTileNumber + 17;
		if(nextTileNumber < 65 && nextTileNumber % 8 != 1 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	

		//	 1
		//	 +
		//	++
		nextTileNumber = currentTileNumber + 15;
		if(nextTileNumber < 65 && nextTileNumber % 8 != 0 && tilemanager.getTile(nextTileNumber).returnOccuppier() == null)
			availableMoves.add(tilemanager.getTile(nextTileNumber));	
		
		for(Tile tile: availableMoves) {
			tile.setAvailableMove(true);
		}
		
		
	}

}
