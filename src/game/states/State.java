package game.states;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import game.Game;


public abstract class State {
	protected Game game;
	protected Font f1 = new Font("Courier New Italic", Font.BOLD, 30);
	protected Font f2 = new Font("Courier New Italic", Font.BOLD, 55);
	protected Font f3 = new Font("Monospaced Bold Italic", Font.ITALIC, 30);
	public State(Game game) {
		this.game = game;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
}