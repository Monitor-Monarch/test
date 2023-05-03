import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static java.awt.event.KeyEvent.*;

public class PacManGUI extends JFrame{


    private JPanel contentPane;
    private PacManSteuerung dieSteuerung;
    private int richtung;
    private JLabel pacmanLbl;



    /**
     * Create the frame.
     */
    public PacManGUI() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        pacmanLbl = new JLabel("");
        pacmanLbl.setVerticalAlignment(SwingConstants.TOP);

        ImageIcon pacmanIcon =  new ImageIcon("D:/IT-Projekt/PacManProjekt/out/production/PacManProjekt/res/PACMAN_ZU.png");
        pacmanLbl.setIcon(pacmanIcon);

        pacmanLbl.setBounds(222, 374, 22, 22);
        System.out.println("Ich habe die Koordinaten gesetzt");
        contentPane.add(pacmanLbl);

        System.out.println("funzt2");
        this.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("funzt");
                if (e.getKeyCode() == VK_RIGHT){
                    System.out.println("rechts");
                    richtung = 1;
                    dieSteuerung.setzeRichtung(richtung);
                }
                if (e.getKeyCode() == VK_LEFT){
                    richtung = 4;
                    dieSteuerung.setzeRichtung(richtung);

                }
                if (e.getKeyCode() == VK_DOWN){
                    richtung = 3;
                    dieSteuerung.setzeRichtung(richtung);

                }
                if (e.getKeyCode() == VK_UP){
                    richtung = 2;
                    dieSteuerung.setzeRichtung(richtung);

                }
                dieSteuerung.move();
            }
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyReleased(KeyEvent e) {

                }


        });
    }

    public void bewegungAnzeigen(int pacManKoordX, int pacManKoordY) {
        pacmanLbl.setBounds(pacManKoordX, pacManKoordY, 22, 22);
    }
    public void bilder() {
    	//PacMan bild
    	//GeistBilder
    	//Bilder für enum State : empty
    	//:wall
    	//:modifier
    	//:item
    	//:ghost
    	//:pacDot
    	repaint();
    }
};
