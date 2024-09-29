package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class splash {
	private String screenSet = "splash"; 
	private int count = 1;
	
	public splash() {}
	
	public String getScreenSet() {
		return screenSet;
	}
	
	public void changeScreenSetSplash() {
		if (GDV5.KeysPressed[KeyEvent.VK_P]) screenSet = "play";
	}
	
	public void changeScreenSetLose(life l) {
		if (GDV5.KeysPressed[KeyEvent.VK_P]) {
			l.setLifeCount(l.getInitialLifeCount());
			screenSet = "play";
		}
		if (GDV5.KeysPressed[KeyEvent.VK_M]) screenSet = "splash";
	}
	
	public void SetLoseScreen() {
		screenSet = "lose";
	}
	
	public void lifeCount(Graphics2D life) {
		int y = 610;
		int x = 210;
		if (GDV5.KeysPressed[KeyEvent.VK_1]) count = 1;
		if (GDV5.KeysPressed[KeyEvent.VK_2]) count = 2;
		if (GDV5.KeysPressed[KeyEvent.VK_3]) count = 3;
		
		life.setFont(new Font("SansSerif", Font.BOLD, 50));
		
		if (count == 1) {
			life.setColor(Color.red);
			life.drawString("1", x, y);
			life.drawString("_", x+3, y);
			life.setColor(Color.white);
			life.drawString("2", x+50, y);
			life.drawString("3", x+100, y);
		}
		
		if (count == 2) {
			life.setColor(Color.white);
			life.drawString("1", x, y);
			life.setColor(Color.red);
			life.drawString("2", x+50, y);
			life.drawString("_", x+51, y);
			life.setColor(Color.white);
			life.drawString("3", x+100, y);
		}
		
		if (count == 3) {
			life.setColor(Color.white);
			life.drawString("1", x, y);
			life.drawString("2", x+50, y);
			life.setColor(Color.red);
			life.drawString("3", x+100, y);
			life.drawString("_", x+100, y);
		}
		
		life.setColor(Color.white);
		life.drawString("LIVES", x+150, y);
	}
	
	public int getLifeCount() {
		return count;
	}
	
	public void displaySplash(Graphics2D splash) {
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 80));
		splash.drawString("WELCOME TO", 100, 100);
		splash.setFont(new Font("SansSerif", Font.BOLD, 80));
		splash.drawString("BREAKOUT", 150, 190);
		
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.ITALIC, 40));
		splash.drawString("by Sasan Liaw", 230, 250);
		
		splash.setFont(new Font("SansSerif", Font.ITALIC, 25));
		splash.drawString("STRIKE BRICKS WITH THE BALL TO SCORE POINTS", 70, 310);
		
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 160));
		splash.drawString("⬅️", 120, 430);
		splash.drawString("➡️", 450, 430);
		splash.setFont(new Font("SansSerif", Font.BOLD, 40));
		splash.drawString("'LEFT' Key:", 95, 460);
		splash.drawString("Paddle Left", 95, 510);
		splash.drawString("'RIGHT' Key:", 415, 460);
		splash.drawString("Paddle Right", 415, 510);
		
		splash.setFont(new Font("SansSerif", Font.ITALIC, 19));
		splash.drawString("[select '1', '2', or '3' lives]", 245, 650);
		
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 60));
		splash.drawString("Press 'P' to Play", 140, 740);
		
		lifeCount(splash);
	}
	
	public void displayLoseScreen(Graphics2D lose) {
		lose.setColor(Color.white);
		lose.setFont(new Font("SansSerif", Font.BOLD, 90));
		lose.drawString("GAME OVER", 100, 150);
		lose.setFont(new Font("SansSerif", Font.BOLD, 250));
		lose.drawString("💔", 250, 420);
		lose.setFont(new Font("SansSerif", Font.BOLD, 50));
		lose.drawString("Press 'P' to Play Again", 110, 520);
		lose.drawString("Press 'M' to Return", 150, 620);
		lose.drawString("to the Menu", 230, 680);
	}
}
