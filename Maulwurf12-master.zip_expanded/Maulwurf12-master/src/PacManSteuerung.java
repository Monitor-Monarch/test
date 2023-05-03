import java.awt.event.ActionEvent;

public class PacManSteuerung {
    private pacman derPacman;
    pacman pacmanAnzeigeObjekt = new pacman();
    private PacManGUI dieGUI;
    PacManGUI dasGUI = new PacManGUI();
    private Reader derReader;
    Reader dasReader = new Reader();
    private Geistah Geist;
    Geistah geist = new Geistah();
    private int richtung;
    public void setzeRichtung(int pRichtung){
        richtung = pRichtung;
    }

    public void move() {
            if (richtung == 1) {
                pacmanAnzeigeObjekt.addX(1);
                dieGUI.bewegungAnzeigen(pacmanAnzeigeObjekt.getX(),pacmanAnzeigeObjekt.getY());
            } else if (richtung == 2) {
                pacmanAnzeigeObjekt.addY(-1);
                dieGUI.bewegungAnzeigen(pacmanAnzeigeObjekt.getX(),pacmanAnzeigeObjekt.getY());
            } else if (richtung == 3) {
                pacmanAnzeigeObjekt.addX(-1);
                dieGUI.bewegungAnzeigen(pacmanAnzeigeObjekt.getX(),pacmanAnzeigeObjekt.getY());
            } else if (richtung == 4) {
                pacmanAnzeigeObjekt.addY(1);
                dieGUI.bewegungAnzeigen(pacmanAnzeigeObjekt.getX(),pacmanAnzeigeObjekt.getY());
            }
    }
    public void spielStart() {
    	long lastLoopTime = System.nanoTime();
    	final int TARGET_FPS = 60;
    	final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
    	long lastFpsTime = 0;
    	
    	while(true){
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            lastFpsTime += updateLength;
            if(lastFpsTime >= 1000000000){
                lastFpsTime = 0;
            }

            this.updateGame(delta);

            try{
               /* Room.gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                System.out.println(Room.gameTime);
                Thread.sleep(Room.gameTime);
                */
            	//
            }catch(Exception e){
            }
        }
    }

	private void updateGame(double delta) {
		derPacman.getX();
		derPacman.getY();
		Geist.getX();
		Geist.getY();
		derReader.reader();
		//derReader.//fieldstate[x][y];//enum state mit bildern verknüpfen...
		
		
		dasGUI.bilder();
		
	}
}