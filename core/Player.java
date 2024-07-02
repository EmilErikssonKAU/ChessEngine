package core;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class Player {
	private ArrayList <Piece> pieces;
	private PieceColor piececolor;
	private TileManager tilemanager;
	private Game game;
	
	public Player(PieceColor piececolor, TileManager tilemanager, Game game) {
		this.piececolor = piececolor;
		this.tilemanager = tilemanager;
		this.game = game;
		pieces = new ArrayList<Piece>(16);
		Tile tile;
		Piece piece;
		
		if(piececolor == PieceColor.White) {
			ImageIcon w_rook = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-rook.png");
			ImageIcon w_knight = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-knight.png");
			ImageIcon w_bishop = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-bishop.png");
			ImageIcon w_queen = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-queen.png");
			ImageIcon w_king = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-king.png");
			ImageIcon w_pawn = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/w-pawn.png");
			
			//	Rooks
			tile = tilemanager.getTile(57);
			piece = new Rook(w_rook, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(64);
			piece = new Rook(w_rook, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Bishops 
			tile = tilemanager.getTile(59);
			piece = new Bishop(w_bishop, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(62);
			piece = new Bishop(w_bishop, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Knights
			tile = tilemanager.getTile(58);
			piece = new Knight(w_knight, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(63);
			piece = new Knight(w_knight, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Queen
			tile = tilemanager.getTile(60);
			piece = new Queen(w_queen, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	King
			tile = tilemanager.getTile(61);
			piece = new King(w_king, tile, PieceColor.White, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			for(int i=0; 8>i; i++) {
				tile = tilemanager.getTile(49+i);
				piece = new Pawn(w_pawn, tile, PieceColor.White, tilemanager, this);
				pieces.add(piece);
				tile.enterPiece(piece);
			}
		}
		else if(piececolor == PieceColor.Black) {
			ImageIcon b_rook = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-rook.png");
			ImageIcon b_knight = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-knight.png");
			ImageIcon b_bishop = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-bishop.png");
			ImageIcon b_queen = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-queen.png");
			ImageIcon b_king = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-king.png");
			ImageIcon b_pawn = new ImageIcon("/home/emil/Downloads/ChessPixelArt/pieces/b-pawn.png");
			
			//	Rooks
			tile = tilemanager.getTile(1);
			piece = new Rook(b_rook, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(8);
			piece = new Rook(b_rook, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Bishops 
			tile = tilemanager.getTile(3);
			piece = new Bishop(b_bishop, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(6);
			piece = new Bishop(b_bishop, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Knights
			tile = tilemanager.getTile(2);
			piece = new Knight(b_knight, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			tile = tilemanager.getTile(7);
			piece = new Knight(b_knight, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	Queen
			tile = tilemanager.getTile(4);
			piece = new Queen(b_queen, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			//	King
			tile = tilemanager.getTile(5);
			piece = new King(b_king, tile, PieceColor.Black, tilemanager, this);
			pieces.add(piece);
			tile.enterPiece(piece);
			
			for(int i=0; 8>i; i++) {
				tile = tilemanager.getTile(9+i);
				piece = new Pawn(b_pawn, tile, PieceColor.Black, tilemanager, this);
				pieces.add(piece);
				tile.enterPiece(piece);
			}
			
		}
	}
	
	public void draw(Graphics2D graphics) {
		for(Piece piece : pieces) {
			piece.draw(graphics);
		}
	}
	
	public void passTurn() {
		game.nextTurn();
	}
	
	public void deletePiece(Piece piece) {
		pieces.remove(piece);
	}
	
	

	public int returnPieceScore() {
		//	king	- 1000
		//	queen	- 10
		//	rook	- 5
		//	bishop	- 3
		//	knight	- 3
		//	pawn 	- 1
		int sum = 0;
		
		for(Piece p: pieces) {
			if(p instanceof King)
				sum += 1000;
			else if(p instanceof Queen)
				sum += 10;
			else if(p instanceof Rook)
				sum += 5;
			else if(p instanceof Bishop)
				sum += 3;
			else if(p instanceof Knight)
				sum += 3;
			else if(p instanceof Pawn)
				sum += 1;			
		}
		
		return sum;
	}
	
	//	exclusive for the ai
	//
	
	
	public void computeRandomMove() {
		Random randomGenerator = new Random();
		Piece randomPiece;
		
		for(Piece p: pieces) {
			p.showAvailableMoves();
		}
		
		do {
			randomPiece = pieces.get(randomGenerator.nextInt(pieces.size()));
		} while(randomPiece.getNumberOfAvailableMoves() < 1);
		
		Tile randomMove = randomPiece.getRandomMove();
		randomPiece.move(randomMove);

	}
	
	public void computeMove() {
		Piece bestPieceToMove = null;
		TileScorePair bestMove = null;
		TileScorePair temp = null;
		
		for(Piece p: pieces) {
			p.showAvailableMoves();
			temp = p.getBestMove();
			
			if(bestMove == null || bestMove.getScore() < temp.getScore()) {
				bestMove = temp;
				bestPieceToMove = p;
			}
		}
		if(bestMove.getScore() > 0)
			bestPieceToMove.move(bestMove.getTile());
		else
			computeRandomMove();
		
		
	}
	
}
