package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class ball extends Rectangle{
	private int velocityY = -9;
	private int initialVelocityY = velocityY;
	private int velocityX = 1;
	private int initialVelocityX = velocityX;
	private boolean particleSwitch = true;

	public ball(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	public void draw(Graphics2D pb) {
		pb.drawOval(x, y, width, height);
		pb.setColor(Color.white);
		pb.fillOval(x, y, width, height);
	}
	
	public void ballMove() {
		x += velocityX;
		y += velocityY;
		if (y <= 0) velocityY = -velocityY;
		if (x >= (GDV5.getMaxWindowX()-width) || x <= 0) velocityX = -velocityX;
	}
	
	public int getVelocityY() {
		return velocityY;
	}
	
	public int getVelocityX() {
		return velocityX;
	}
	
	public int generateRandXvelocity() {
		return (int)(Math.random()*2)+1;
	}
	
	public void increaseSpeed() {
		velocityY += 2;
	}
	
	public void bouncePaddle(int paddleX, int paddleWidth, int paddleY, int paddleHeight, int ballWidth) {
		if ((y+height) >= paddleY && (y+height) <= (paddleY+paddleHeight) && x >= (paddleX-ballWidth) && x <= (paddleX+paddleWidth+ballWidth)) {
			velocityY = -velocityY;
			if (x < (paddleX + paddleWidth/2)) {
				velocityX = -(Math.abs(generateRandXvelocity()));
			}
			if (x >= (paddleX + paddleWidth/2)) {
				velocityX = Math.abs(generateRandXvelocity());
			}
		}
	}
	
	public void respawn() {
		x = GDV5.getMaxWindowX()/2;
		y = GDV5.getMaxWindowY()/2;
		velocityY = initialVelocityY;
		velocityX = initialVelocityX;
	}
	
	public void bounceOffBrick(boolean brickHit, int collisionResult ) {
		if (collisionResult == 0 || collisionResult == 2) {
			if (!brickHit) velocityX = -velocityX;
		}
		if (collisionResult == 1 || collisionResult == 3) {
			if (!brickHit) velocityY = -velocityY;
		}
	}
	
	public void checkBrickCollision (brick [] brickArr, scoreboard scoreDisplay, particles particleEffect, paddle p) {
		for (brick b: brickArr) {
			if (this.intersects(b)) {
				this.bounceOffBrick(b.checkHit(), GDV5.collisionDirection(b, this, velocityX, velocityY));
				if (!b.checkHit()) {
					scoreDisplay.increaseScore();
					if (particleSwitch) particleEffect.makeParticleEffectOne(b);
					if (!particleSwitch) particleEffect.makeParticleEffectTwo(b);
					particleSwitch = !particleSwitch;
					
					if (b.getPowerUpStatus()) {
						increaseSpeed();
						p.increaseSize();
					}
				}
				b.makeHit();
			}
		}
	}
}
