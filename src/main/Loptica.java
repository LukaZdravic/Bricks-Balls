package main;

import java.awt.Color;
import java.awt.Graphics;

public class Loptica extends AktivnaFigura {

	private int precnik;
	
	private double speed = 3 ;

	private double speedY = (-Math.random())*speed;
	private double speedX =(Math.random()*2 - 1)*speed;
	
	private int pomerajX,pomerajY;
	
	private int counter = 0;
	
	
	public Loptica(int x,int y,Scena scena,Color c, int perioda,int precnik) {
		super(x,y,scena,Color.GREEN,perioda);
		this.precnik=precnik;
		if(speedX<0) pomerajX = (int) Math.floor(speedX);
		else pomerajX = (int)Math.ceil(speedX);
		
		if(speedY<0) pomerajY = (int) Math.floor(speedY);
		else pomerajY = (int)Math.ceil(speedY);
		
	}
	
	@Override
	public void updatePlace() {
		counter++;
		if (counter % 100 == 0 && pomerajX < 8 && pomerajX > -8 && pomerajY <8 && pomerajY > -8) {
			double tmp1 = Math.abs(speedX/10);
			double tmp2 = Math.abs(speedY/10);

			
			if(pomerajX < 0) pomerajX -=tmp1;
			else pomerajX +=tmp1;
			if(pomerajY < 0) pomerajY -=tmp2;
			else pomerajY += tmp2;
			
			if (speedX < 0) speedX -=tmp1;
			else speedX +=tmp1;
			if(speedY < 0) speedY -=tmp2;
			else speedY +=tmp2;
			
		}
		
		this.x += pomerajX;
		this.y += pomerajY;
		
		
		if (this.x+(this.precnik/2) >= 500 || this.x-(this.precnik/2) <= 0) {
			pomerajX = -pomerajX;
		}
		for (int i =0;i<this.scena.getNumOfElements();i++) {
			if (this.scena.dohvatiFiguru(i) instanceof Cigla) {
				Cigla c = (Cigla) scena.dohvatiFiguru(i);
				if (c.getPogodjena() == false) {
					
					
					if (this.y>= c.y - c.getVisina()/2 && this.y <= c.y + c.getVisina()/2) {
						// LEVA I DESNA IVICA
						if (this.x + (this.precnik/2) >= c.x - c.getSirina()/2 && this.x<c.x-c.getSirina()/2) {
							pomerajX = -pomerajX;
							c.pogodjena();
						}
						if (this.x - (this.precnik/2) <= c.x + c.getSirina()/2 && this.x>c.x+c.getSirina()/2) {
							pomerajX = -pomerajX;
							c.pogodjena();
						}
						
						
						
					}
					if (this.x>= c.x - c.getSirina()/2 && this.x<= c.x+c.getSirina()/2) {
						if (this.y+(this.precnik/2)>= c.y - c.getVisina()/2 && this.y < c.y-c.getVisina()/2) {
							pomerajY = -pomerajY;
							c.pogodjena();
						}
						if (this.y-(this.precnik/2)<= c.y + c.getVisina()/2 && this.y > c.y + c.getVisina()/2) {
							pomerajY = -pomerajY;
							c.pogodjena();
						}
						
						
					}
				}
			}
		}
		
		if (this.y - (this.precnik/2) <=0) {
			pomerajY = -pomerajY;
		}
		
		
		if (this.y + (this.precnik/2) >= 500) unistiFiguru();
		
		Igrac f = (Igrac)scena.dohvatiFiguru(0);
		if (this.y + (this.precnik/2) >= f.y - (f.getVisina()/2) && this.y < f.y-f.getVisina()/2 && this.x>=f.x-(f.getSirina()/2) && this.x <= f.x+(f.getSirina()/2)) {
			pomerajY = -pomerajY;
		}
		
	}

	@Override
	public char getOznaka() {
		return 'L';
	}

	@Override
	public void draw() {
		Graphics g = this.scena.getGraphics();
		Color oldC = g.getColor();
		g.setColor(this.c);
		g.fillOval(x-(precnik/2), y-(precnik/2), precnik, precnik);
		
		
		g.setColor(oldC);
		
		
		
	}

}
