package main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class AktivnaFigura extends Figura implements Runnable{

	private int perioda;
	private Thread t;
	
	public AktivnaFigura(int x,int y,Scena scena,Color c, int perioda) {
		super(x,y,scena,c);
		this.perioda = perioda;
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				updatePlace();
				Thread.sleep(perioda);
				scena.repaint();
				
			}
		}
		catch(InterruptedException e) {}
		
		
	}
	
	public void stop() {
		t.interrupt();
		
	}
	
	public void start() {
		t.start();
	}
	
	@Override
	public void unistiFiguru() {
		super.unistiFiguru();
		stop();
	}
	
	
	public abstract void updatePlace();

}
