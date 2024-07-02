package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Scena extends Canvas {

	private ArrayList<Figura> figures = new ArrayList<Figura>();
	private IgraLoptica owner;
	
	public Scena(IgraLoptica owner) {
		this.owner = owner;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Loptica(owner.igy.x, owner.igy.y - owner.igy.getVisina()/2 - owner.igy.getVisina(), Scena.this, Color.GREEN, 10, owner.igy.getVisina()).start();
				
				owner.requestFocus();
			}
		});
	}
	
	public synchronized int getNumOfElements() {
		return figures.size();
	}
	
	public synchronized void dodajFiguru(Figura f) {
		figures.add(f);
	}
	public synchronized void ukloniFiguru(Figura f) {
		figures.remove(f);
	}
	public synchronized Figura dohvatiFiguru(int index) {
		return figures.get(index);
	}
	
	
	public void pokreniScenu() {
		for(Figura f : figures) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).start();
			}
		}
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		super.paint(g);
		for(Figura f : figures) {
			f.draw();
		}
	}
	
	public void zaustaviScenu() {
		for(Figura f : figures) {
			if (f instanceof AktivnaFigura) {
				((AktivnaFigura) f).stop();
			}
		}
	}
	
	
}
