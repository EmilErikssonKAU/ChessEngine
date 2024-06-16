package core;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener{
	private Program program;
	
	public MouseHandler(Program program) {
		this.program = program;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		program.processMouseClick(e.getX(), e.getY());
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		program.processMouseMovement(e.getX(), e.getY());
	}
	
	
	//	We currently don't care about the rest
	//
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
