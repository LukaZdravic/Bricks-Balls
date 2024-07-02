package main;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {

	private int sirina,visina;
	private boolean pogodjena = false;
	
	public Cigla(int x,int y,Scena scena,Color c, int perioda,int sirina,int visina) {
		super(x,y,scena,Color.RED,perioda);
		this.sirina=sirina;
		this.visina=visina;
	}
	
	public int getSirina() {
		return sirina;
	}
	public int getVisina() {
		return visina;
	}
	
	public void pogodjena() {
		this.c=Color.GRAY;
		pogodjena = true;
	}
	
	public boolean getPogodjena() {
		return pogodjena;
	}
	
	
	@Override
	public void updatePlace() {
		if (pogodjena == false) return;
		this.pomeriPoY(1);
	
		if (this.y + this.visina/2 >= 500) this.unistiFiguru();
	}

	@Override
	public char getOznaka() {
		return 'C';
	}

	@Override
	public void draw() {
		Graphics g = this.scena.getGraphics();
		Color oldC = g.getColor();
		g.setColor(this.c);
		g.fillRect(x-(sirina/2), y-(visina/2), sirina, visina);
		
		
		g.setColor(oldC);
	}

}
