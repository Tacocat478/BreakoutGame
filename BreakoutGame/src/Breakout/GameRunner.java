package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import utilities.GDV5;


public class GameRunner extends GDV5{
	//private brick b1 = new brick(10, 10, 100, 10, Color.cyan);
	private int brickNum = 9, rowNum = 5;
	private brick[] brickArr = new brick[brickNum*rowNum];
	private int padding = 2;
	private int brickWidth = (GDV5.getMaxWindowX() - ((brickNum+1)*padding))/brickNum , brickHeight = 20;
	private Color[] color = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue};
	
	private ball theBall= new ball(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, 20, 20);
	private paddle thePaddle = new paddle(GDV5.getMaxWindowX()/2, 750, 100, 10);
	private scoreboard scoreDisplay = new scoreboard();
	private splash screen = new splash();
	private life lives = new life();
	private particles particleEffect = new particles();
	
	
	public GameRunner() {
		int k = 0, y = padding;
		for (int j = 0; j<rowNum; j++) {
			int x = padding;
			for (int i = 0; i<brickNum; i++) {
				brickArr[k] = new brick(x,y,brickWidth,brickHeight, color[j]);
				x += brickWidth + padding;
				k++;
			}
			y += brickHeight + padding;
		}
	}
	
	public static void main(String[] args) {
		GameRunner g = new GameRunner();
		g.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (screen.getScreenSet().equals("splash")) {
			lives.setLifeCount(screen.getLifeCount());
			screen.changeScreenSetSplash();
		}
		if (screen.getScreenSet().equals("play")) {
			lives.reset(theBall, thePaddle, lives);
			theBall.ballMove();
			theBall.checkBrickCollision(brickArr, scoreDisplay, particleEffect, thePaddle);
			thePaddle.paddleMove();
			theBall.bouncePaddle(thePaddle.x, thePaddle.width, thePaddle.y, thePaddle.height, theBall.width);
			lives.loseCheck(screen, theBall, thePaddle, brickArr, scoreDisplay);
			scoreDisplay.increaseLevel(brickArr, theBall, thePaddle);
			particleEffect.particleDeletion();
		}
		if (screen.getScreenSet().equals("lose")) screen.changeScreenSetLose(lives);
	}
 
	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		if (screen.getScreenSet().equals("play")) {
			for (brick b: brickArr) {
				if (!b.checkHit()) b.draw(win);
			}
			lives.drawHearts(win);
			scoreDisplay.draw(win);
			theBall.draw(win);
			thePaddle.draw(win);
			particleEffect.drawParticles(win);
		}
		
		if (screen.getScreenSet().equals("splash")) {
			screen.displaySplash(win);
		}
		
		if(screen.getScreenSet().equals("lose")) {
			screen.displayLoseScreen(win);
		}
		
	}
}
