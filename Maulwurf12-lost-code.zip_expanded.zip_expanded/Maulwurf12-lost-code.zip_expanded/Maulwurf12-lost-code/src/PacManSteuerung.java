import java.awt.Color;
import java.io.IOException;

import javax.swing.*;

import enums.Richtungen;
import enums.State;

public class PacManSteuerung {

	private PacManGUI dieGUI;
	private Key_Listener derListener;
	private pacman pacman;

	MyPanel zeichenpanel = new MyPanel();

	public PacManSteuerung() throws IOException {
		derListener = new Key_Listener(this);
		// todo Berechnung Startpunkt
		int x = 222;
		int y = 374;
		int geschwindigkeit = 100;
		pacman = new pacman(x, y, Richtungen.stand, geschwindigkeit);
		dieGUI = new PacManGUI(derListener);
		dieGUI.addPacman();
		dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
		dieGUI.setVisible(true);

		dieGUI.getContentPane().add(zeichenpanel);

		// Create a level
		Reader levelReader = new Reader();
		State[][] reader = levelReader.reader();
		Level level = createLevel(reader);
		zeichenpanel.setLevel(level);

		run();
	}

	private Level createLevel(State[][] reader) {
		Level level = new Level( reader[0].length, reader.length );
		
		// TODO Auto-generated method stub
		return level;
	}

	public void changeDirection(Richtungen richtung) {
//            if (richtung == Richtungen.rechts) {
//                pacman.addX(3);
//                dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
//            } else if (richtung == Richtungen.oben) {
//                pacman.addY(-3);
//                dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
//            } else if (richtung == Richtungen.links) {
//                pacman.addX(-3);
//                dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
//            } else if (richtung == Richtungen.unten) {
//                pacman.addY(3);
//                dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
//            }
		pacman.setBewegungsRichtung(richtung);
	}

	public void start() {
		dieGUI.pacmanLbl.setVisible(true);
		dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
		pacman.start();
	}

	public void stop() {
		pacman.stop();
	}

	public void run() {
		while (true) {
			int breiteBildschirm = dieGUI.contentPane.getWidth();
			int hoeheBildschirm = dieGUI.contentPane.getHeight();
			int posXPacman = pacman.getX();
			int posYPacman = pacman.getY();

			// Pacman soll nicht rechts aus Bild raus
			if (posXPacman > breiteBildschirm - dieGUI.pacmanLbl.getWidth()) {
				pacman.setX(breiteBildschirm - dieGUI.pacmanLbl.getWidth());
			}

			// Pacman soll nicht links aus Bild raus
			if (posXPacman < 0) {
				pacman.setX(0);
			}

			// Pacman soll nicht unten aus Bild raus
			if (posYPacman > hoeheBildschirm - dieGUI.pacmanLbl.getHeight()) {
				pacman.setY(hoeheBildschirm - dieGUI.pacmanLbl.getHeight());
			}

			// Pacman soll nicht oben aus Bild raus
			if (posYPacman < 0) {
				pacman.setY(0);
			}

			/*
			 * if (x > MAX) x = MAX; if (x < MIN) x = MIN;
			 */

			// todo Wände kontrollieren

			dieGUI.bewegungAnzeigen(pacman.getX(), pacman.getY());
		}
	}
}