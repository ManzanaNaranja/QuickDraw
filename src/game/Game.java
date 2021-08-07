package game;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.input.KeyManager;
import game.input.MouseManager;
import game.states.DrawState;
import game.states.StartState;
import game.states.State;
import game.states.StateManager;
import game.states.TaskState;

public class Game {
	private Window window;
	private BufferStrategy bs;
	private Graphics g;
	public int width, height;
	public KeyManager keyManager;
	public MouseManager mouseManager;
	private StateManager stateManager;
	public State taskState, startState, drawState;
	public String task = null;
	public String[] tasks = new String[] {"watermellon", "apple", "cheese"};
	public Game(String title, int w, int h) {
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		window = new Window("title", w, h);
		stateManager = new StateManager();
		startState = new StartState(this);
		drawState = new DrawState(this);
		taskState = new TaskState(this);
		this.width = w;
		this.height = h;
		window.canvas.addKeyListener(keyManager);
		window.canvas.addMouseListener(mouseManager);
		window.canvas.addMouseMotionListener(mouseManager);
		this.stateManager.setState(startState);
		
	}
	
	public void newRandomTask() {
		this.task = tasks[(int) (Math.random() * tasks.length)];
	}
	
	
	private void render() {
		bs = window.canvas.getBufferStrategy();
		if(bs == null) {
			window.canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		if(stateManager.getState() != null) {
			stateManager.getState().render(g);
		}
		bs.show();
		g.dispose();
	}
	
	private void tick() {
		keyManager.tick();
		mouseManager.tick();
		if(stateManager.getState() != null) {
			stateManager.getState().tick();
		}
	}
	
	public void start() {
		double last = System.currentTimeMillis();
		double time = 0;
		while(true) {
			double current = System.currentTimeMillis();
			double elapsed = current - last;
			time += elapsed;
			while(time >= 17) {
				this.tick();
				time -= 17;
			}
			this.render();

			last = current;
		}
	}
	
	public StateManager getStateManager() {
		return this.stateManager;
	}
	
	public static void main(String[] args) {
		Game g = new Game("Quick, Draw!", 500, 500);
		g.start();
	}
}
