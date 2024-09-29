package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class paddle extends Rectangle{
	private int initialWidth;
	
	public paddle(int x, int y, int width, int height) {
		super(x,y,width,height);
		initialWidth = width;
	}
	
	int paddleSpeed = 7;
	
	public void draw(Graphics2D pb) {
		pb.setColor(Color.white);
		pb.draw(this);
		pb.fill(this);
	}
	
	public void paddleMove() {
		if(GDV5.KeysPressed[KeyEvent.VK_LEFT] && x >= 0) {
			x = x - paddleSpeed;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_RIGHT] && x <= (GDV5.getMaxWindowX() - width)) {
			x = x + paddleSpeed;
		}
	}
	
	public void respawn() {
		x = GDV5.getMaxWindowX()/2;
		width = initialWidth;
		
	}
	
	public void increaseSize() {
		width += 10;
	}
}
