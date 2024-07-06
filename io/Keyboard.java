package io;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import enums.Key;

public class Keyboard {
	HashMap<Key, Boolean> state;
	public Keyboard() {
		state = new HashMap<Key, Boolean>();
		state.put(Key.Left, false);
		state.put(Key.Right, false);
		state.put(Key.Escape, false);
	}
	
	public boolean isKeyDown(Key key) {
		if(state.containsKey(key)) {
			return state.get(key);
		}
		return false;
	}
	
	public boolean isKeyUp(Key key) {
		return !isKeyDown(key);
	}
	
	public void processKeyEvent(int key, boolean st) {
		switch(key) {
			case KeyEvent.VK_LEFT:   state.put(Key.Left,   st); break;
			case KeyEvent.VK_RIGHT:  state.put(Key.Right,  st); break;
			case KeyEvent.VK_ESCAPE: state.put(Key.Escape, st); break;
		}
	}
	
}
