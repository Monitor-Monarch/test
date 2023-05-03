
public class pacman {
    private int x = 222;
    private int y = 374;
    private boolean powerupAktiv;

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
    public pacman() {
    }

}