package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import game.Game;
import game.input.MouseManager;

public class TaskState extends State{
	
	public TaskState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		if(MouseManager.justReleased) {
			game.getStateManager().setState(game.drawState);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.decode("#FFD139"));
		g.fillRect(0, 0, game.width,game.height);
		g.setColor(Color.black);		
		drawCenteredString(g, "Draw", new Rectangle(0,100,game.width,0), f1);
		drawCenteredString(g, game.task, new Rectangle(0,200,game.width,0), f2);
		drawCenteredString(g, "in less than 20 seconds", new Rectangle(0,325,game.width,0), f1);
		
	}

}
