package Breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import utilities.GDV5;

public class life {
	private int lifeCount;
	private int initialLifeCount;
	private int x = 10;
	private int y = 170;
	
	public life() {}
	
	public void setLifeCount(int count) {
		lifeCount = count;
		initialLifeCount = count;
	}
	
	public void drawHearts(Graphics2D lives) {
		int gap = 0;
		lives.setColor(Color.darkGray);
		lives.setFont(new Font("SansSerif", Font.BOLD, 40));
		for (int i = 1; i<=lifeCount; i++) {
			lives.drawString("❤️", x, y+gap);
			gap += 45;
		}
	}
	
	public void loseLife() {
		lifeCount--;
	}
	
	public void reset(ball b, paddle p, life l) {
		if (b.getY() > GDV5.getMaxWindowY()) {
			b.respawn();
			p.respawn();
			l.loseLife();
		}
	}
	
	public void loseCheck(splash s, ball b, paddle p, brick [] brickArr, scoreboard sb) {
		if (lifeCount == 0) {
			s.SetLoseScreen();
			b.respawn();
			p.respawn();
			for (brick br: brickArr) br.makeNotHit();
			sb.resetScore();
		}
	}
	
	public int getInitialLifeCount() {
		return initialLifeCount;
	}
	
}
