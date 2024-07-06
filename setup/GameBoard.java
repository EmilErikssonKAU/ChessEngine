package setup;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JComponent;

import core.Game;
import core.TileManager;

public class GameBoard extends JComponent {
	private Game game;
	private TileManager tilemanager;
	private boolean mouseEnabled;
	
	private final int BOARD_WIDTH_TILES = 8;
	
	public GameBoard() {
		tilemanager = new TileManager(BOARD_WIDTH_TILES, this.getPreferredSize().width/BOARD_WIDTH_TILES);
		//	(numberOfTiles, pixelWidthOfTile)
		game = new Game(this, tilemanager);
		mouseEnabled = true;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(Color.green);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		tilemanager.draw(graphics);
		game.draw(graphics);
	}
	
	public void processMouseClick(int x, int y) {
		if(mouseEnabled)
			tilemanager.checkClick(x, y);
	}
	
	public void processMouseMovement(int x, int y) {
		tilemanager.checkHover(x,y);
	}

	
	public void disableMouse() {
		mouseEnabled = false;
	}
	
	public void enableMouse() {
		mouseEnabled = true;
	}

}
