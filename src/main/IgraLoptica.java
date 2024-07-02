package main;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class IgraLoptica extends Frame {

	public Igrac igy;
	private Loptica l;
	private Scena scene;
	
	public IgraLoptica() {
		setBounds(300, 400, 500, 500);
		
		setResizable(false);
		
		setTitle("Loptica");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scene.zaustaviScenu();
				dispose();
			}
		});
		
		
		
		scene = new Scena(this);
		scene.setPreferredSize(new Dimension(500,500));
		
		igy =new Igrac(250,440,scene,Color.GRAY,60,10);

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int s = e.getKeyCode();
				switch(s) {
					case KeyEvent.VK_LEFT:{
						if(igy.canMove(-10)) {
							igy.pomeriPoX(-10);
							scene.repaint();
						}
						break;
					}
					case KeyEvent.VK_RIGHT:{
						if(igy.canMove(10)) {
							igy.pomeriPoX(10);
							scene.repaint();
						}
						
						break;
					}
					
				
				
				}
			}
		});		
		int pomerajX = 0;
		int pomerajY = 0;
		for (int i =0;i<3;i++) {
			for (int j =0;j<5;j++) {
				new Cigla(pomerajX+50,pomerajY + 15,scene,Color.GREEN,10,90,20);
				pomerajX+=100;
			}
			pomerajY+=25;
			pomerajX=0;
		}
		MenuBar mb = new MenuBar();
		
		Menu m = new Menu("File");
		MenuItem mi = new MenuItem("LukaCar");
		
		m.add(mi);
		CheckboxMenuItem cbi = new CheckboxMenuItem("Lukaaaa");
		m.add(cbi);
		m.addSeparator();
		m.add(new MenuItem("Exit",new MenuShortcut(KeyEvent.VK_Q, true)));
		
		mb.add(m);
		
		setMenuBar(mb);
		
		setLayout(new GridLayout(1,1));
		
		scene.pokreniScenu();
		
		add(scene);
		
		pack();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IgraLoptica();
	}
	
}
