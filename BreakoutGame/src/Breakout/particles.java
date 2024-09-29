package Breakout;

import java.awt.Graphics2D;

public class particles {
	private brick[] totalParticleArrOne = new brick[200];
	private brick[] totalParticleArrTwo = new brick[200];
	
	public particles( ) {}
	
	public void makeParticleEffectOne(brick b) {
		int k = 0;
		int particleRNum = 20;
		int particleCNum = 10;
		int particleWidth = b.returnWidth() / particleRNum;
		int particleHeight = b.returnHeight() / particleCNum;
		
		int y = b.returnY();
		for (int j = 0; j<particleCNum; j++) {
			int x = b.returnX();
			for (int i = 0; i<particleRNum; i++) {
				totalParticleArrOne[k] = new brick(x,y,particleWidth,particleHeight, b.returnColor(), 0);
				totalParticleArrOne[k].makeParticleDrawn();
				x += particleWidth;
				k++;
			}
			y += particleHeight;
		}
	}
	
	public void makeParticleEffectTwo(brick b) {
		int k = 0;
		int particleRNum = 20;
		int particleCNum = 10;
		int particleWidth = b.returnWidth() / particleRNum;
		int particleHeight = b.returnHeight() / particleCNum;
		
		int y = b.returnY();
		for (int j = 0; j<particleCNum; j++) {
			int x = b.returnX();
			for (int i = 0; i<particleRNum; i++) {
				totalParticleArrTwo[k] = new brick(x,y,particleWidth,particleHeight, b.returnColor(), 0);
				totalParticleArrTwo[k].makeParticleDrawn();
				x += particleWidth;
				k++;
			}
			y += particleHeight;
		}
	}
	
	public void particleDeletionOne() {
		try {
			for (brick b: totalParticleArrOne) {
				if ((int)(Math.random()*100)+1 < 15) {
					b.makeParticleNotDrawn();
				}
			}
		}
		catch(Exception e) {
			return;
		}
	}
	
	public void particleDeletionTwo() {
		try {
			for (brick b: totalParticleArrTwo) {
				if ((int)(Math.random()*100)+1 < 15) {
					b.makeParticleNotDrawn();
				}
			}
		}
		catch(Exception e) {
			return;
		}
	}
	
	public void drawParticlesOne(Graphics2D particle) {
		try {
			for (brick b: totalParticleArrOne) {
				if(b.getParticleDraw()) b.draw(particle);
			}
		}
		catch (Exception e) {
			return;
		}
	
	}
	
	public void drawParticlesTwo(Graphics2D particle) {
		try {
			for (brick b: totalParticleArrTwo) {
				if(b.getParticleDraw()) b.draw(particle);
			}
		}
		catch (Exception e) {
			return;
		}
	
	}
	
	public void particleDeletion() {
		particleDeletionOne();
		particleDeletionTwo();
	}
	
	public void drawParticles(Graphics2D particle) {
		drawParticlesOne(particle);
		drawParticlesTwo(particle);
	}
	
}
