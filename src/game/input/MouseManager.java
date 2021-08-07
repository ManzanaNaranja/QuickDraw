package game.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	
	public static Point mouse;
	public static boolean mouseDown;
	public static boolean justPressed;
	public static boolean cantPress;
	public static boolean justReleased;
	
	
	public MouseManager() {
		mouse = new Point();
		mouseDown = false;
		justPressed = false;
		cantPress = false;
		justReleased = false;
	}
	
	public void tick() {
		if(cantPress && !mouseDown) {
			cantPress = false;
			justReleased = true;
		} else if(justPressed) {
			cantPress = true;
			justPressed = false;
		} else {
			justReleased = false;
		}
		
		if(!cantPress && mouseDown) {
			justPressed = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouse.x = e.getX();
		mouse.y = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse.x = e.getX();
		mouse.y = e.getY();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouse.x = e.getX();
		mouse.y = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
