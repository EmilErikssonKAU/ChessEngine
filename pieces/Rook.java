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
		// TODO Auto-generated method stub
		
	}

}
