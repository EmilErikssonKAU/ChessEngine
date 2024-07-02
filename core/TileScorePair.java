package core;

public class TileScorePair {
	private int score;
	private Tile tile;
	
	public TileScorePair(Tile tile, int score) {
		this.score = score;
		this.tile = tile;
	}
	
	public int getScore() {
		return score;
	}
	
	public Tile getTile() {
		return tile;
	}

}
