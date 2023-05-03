import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Key_Listener implements KeyListener{
	private int richtung;
	private PacManSteuerung dieSteuerung;

public Key_Listener(PacManSteuerung steuerung) {
	this.dieSteuerung = steuerung;
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
	//Tasten abfragen
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("rechts,");
			dieSteuerung.changeDirection(Richtungen.rechts);
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("links,");
			dieSteuerung.changeDirection(Richtungen.links);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("unten,");
			dieSteuerung.changeDirection(Richtungen.unten);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("oben,");
			dieSteuerung.changeDirection(Richtungen.oben);
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			dieSteuerung.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_W){
			dieSteuerung.stop();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
