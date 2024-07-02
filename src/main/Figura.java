package main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {

	protected Scena scena;
	protected int x,y;
	protected Color c;
	
	public Figura(int x,int y,Scena scena,Color c) {
		this.x = x;
		this.y = y;
		this.scena = scena;
		this.c = c;
		scena.dodajFiguru(this);
	}
	
	public abstract char getOznaka();
	
	public abstract void draw();
	
	public void pomeriPoX(int pomeraj) {
		x +=pomeraj;
	}
	public void pomeriPoY(int pomeraj) {
		y += pomeraj;
		
	}
	
	public void unistiFiguru() {
		scena.ukloniFiguru(this);
		scena.repaint();
	}
}
