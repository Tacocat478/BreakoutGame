package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class brick extends Rectangle{
	
	private Color color;
	private boolean hit;
	private boolean particleDrawn;
	private boolean powerUp = false;
	
	public brick(int x, int y, int width, int height, Color c) {
		super(x, y, width, height);
		if ((int)(Math.random()*100)+1 < 10) {
			color = Color.white;
			powerUp = true;
		}
		else {
			color = c;
		}
		hit = false;
	}
	
	public brick(int x, int y, int width, int height, Color c, int blank) { //for particles
		super(x, y, width, height);
		color = c;
		hit = false;
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(color);
		pb.fill(this);
	}
	
	public void makeHit() {
		hit = true;
	}
	
	public void makeNotHit() {
		hit = false;
	}
	
	public boolean checkHit() {
		return hit;
	}
	
	public boolean getPowerUpStatus() {
		return powerUp;
	}
	
	
	
	public int returnWidth() {
		return width;
	}
	
	public int returnHeight() {
		return height;
	}
	
	public int returnX() {
		return x;
	}
	
	public int returnY() {
		return y;
	}
	
	public Color returnColor() {
		return color;
	}
	
	
	
	public void makeParticleDrawn() {
		particleDrawn = true;
	}
	
	public void makeParticleNotDrawn() {
		particleDrawn = false;
	}
	
	public boolean getParticleDraw() {
		return particleDrawn;
	}
	
}
