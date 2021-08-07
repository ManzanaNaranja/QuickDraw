package game.states;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import game.Game;
import game.input.KeyManager;
import game.input.MouseManager;

public class DrawState extends State {
	
	ArrayList<ArrayList<Point>> lines;
	int lineIndex = -1;
	public DrawState(Game game) {
		super(game);
		lines = new ArrayList<ArrayList<Point>>();
		this.addNewLine();
	}
	
	private void addNewLine() {
		lines.add(new ArrayList<Point>());
		lineIndex++;
	}

	@Override
	public void tick() {
		if(MouseManager.justReleased) {
			this.addNewLine();
		}
	}

	@Override
	public void render(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		if(MouseManager.mouseDown) {
			Point pos = MouseManager.mouse;
			lines.get(lineIndex).add(new Point(pos.x, pos.y));
		}
		for(ArrayList<Point> line : lines) {
			for(int i = 0; i < line.size()-1; i++) {
				Point d1 = line.get(i);
				Point d2 = line.get(i+1);
				g2.drawLine(d1.x, d1.y, d2.x, d2.y);
			}
		}
		
		
		}

}
