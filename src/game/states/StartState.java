package game.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import game.Game;
import game.input.MouseManager;

public class StartState extends State{

	public StartState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		if(MouseManager.justReleased) {
			game.newRandomTask();
			game.getStateManager().setState(game.taskState);
		}
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.decode("#EE7AAA"));
		g.fillRect(0, 0, game.width,game.height);
		g.setColor(Color.black);		
		drawCenteredString(g, "Can a neural network", new Rectangle(0,100,game.width,0), f3);
		drawCenteredString(g, "learn to recognize doodling?", new Rectangle(0,150,game.width,0), f3);
		
		
	}

}
