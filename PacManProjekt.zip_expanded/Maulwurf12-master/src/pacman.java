import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class pacman {

    private int x;
    private int y;
    private int geschwindigkeit = 1; // in Pixel/Sekunde
    private ENUM.Richtungen bewegungsRichtung = ENUM.Richtungen.oben;
    private boolean powerupAktiv;
    private boolean running;
    private TimerTask timerTask;
    private Timer timer = new Timer();

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }



    public void addX(int value){
        this.x += value;
    }
    public void addY(int value){
        this.y += value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGeschwindigkeit() {return geschwindigkeit;}
    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
        if (running) {
            timer.cancel();
            start();
        }
    }

    public ENUM.Richtungen getBewegungsRichtung() {return bewegungsRichtung;}
    public void setBewegungsRichtung(ENUM.Richtungen bewegungsRichtung) {
        this.bewegungsRichtung = bewegungsRichtung;
//        if (running) {
//            timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    move(bewegungsRichtung);
//                }
//            }
//            changeMovement();
//        }
    }


    public pacman(int posX, int posY, ENUM.Richtungen richtung, int geschwindigkeit) {
        x = posX;
        y = posY;
        bewegungsRichtung = richtung;
        this.geschwindigkeit = geschwindigkeit;

        timerTask = new TimerTask() {
            @Override
            public void run() {
                move(bewegungsRichtung);
            }
        };

        timer = new Timer("Timer");
    }

    public void start() {
        running = true;
        long period = 1000/geschwindigkeit; // Zeit in ms zwischen Bewegungsschritten
        timer.scheduleAtFixedRate(timerTask, 0, period);
    }

    public void stop() {
        running = false;
        timer.cancel();
    }

    private void move(ENUM.Richtungen richtung) {
        switch (richtung) {
            case oben -> addY(-1);
            case rechts -> addX(1);
            case unten -> addY(1);
            case links -> addX(-1);
            case stand -> addX(0);
        }
    }

}