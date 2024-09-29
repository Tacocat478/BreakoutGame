package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import utilities.GDV5;

public class scoreboard {
	private int score = 0;
	private int level = 1;
	
	public scoreboard() {}
	
	public void draw(Graphics2D scorePrint) {
		scorePrint.setColor(Color.darkGray);
		scorePrint.setFont(new Font("SansSerif", Font.BOLD, 50));
		scorePrint.drawString("SCORE: " + score, 255, 400);
		scorePrint.setFont(new Font("SansSerif", Font.BOLD, 30));
		scorePrint.drawString("LEVEL: " + level, 310, 450);
	}
	
	public void increaseScore() {
		score++;
	}
	
	public void resetScore() {
		score = 0;
		level = 1;
	}
	
	public void increaseLevel(brick [] brickArr, ball b, paddle p) {
		boolean exit = false;;
		for (brick br: brickArr) {
			if (br.checkHit() == false) exit = true;;
		}
		if (exit == true) return;
		level++;
		b.respawn();
		p.respawn();
		for (brick br: brickArr) br.makeNotHit();
	}
}
