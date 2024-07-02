package main;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura {

	private int sirina,visina;
	
	public Igrac(int x,int y,Scena scena,Color c,int sirina,int visina) {
		super(x,y,scena,Color.BLUE);
		this.sirina=sirina;
		this.visina=visina;
	}
	
	public int getSirina() {
		return sirina;
	}
	
	public int getVisina() {
		return visina;
	}
	
	@Override
	public char getOznaka() {
		return 'I';
	}

	@Override
	public void draw() {
		Graphics g = this.scena.getGraphics();
		Color oldC = g.getColor();
		g.setColor(this.c);
		g.fillRect(x - (sirina/2) ,y - (visina/2), sirina, visina);
		
		
		g.setColor(oldC);
		

	}
	
	public boolean canMove(int pixels) {
		if (this.x + (sirina/2) + pixels > this.scena.getWidth()) return false;
		if (this.x - (sirina/2) + pixels < 0) return false;
		return true;
	}
	

}
