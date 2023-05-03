import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import de.haller.beat.pacman.model.LevelCell;
import de.haller.beat.pacman.model.LevelCell.EStatus;

import static java.awt.event.KeyEvent.*;

public class PacManGUI extends JFrame{


    public JPanel contentPane;
    public JLabel pacmanLbl;



    /**
     * Create the frame.
     */
    public PacManGUI(Key_Listener derListener) {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 700);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        this.addKeyListener(derListener);


        
        
        
    }
    public void addPacman(){
        pacmanLbl = new JLabel("x");
        pacmanLbl.setVerticalAlignment(SwingConstants.TOP);
        //ImageIcon pacmanIcon =  new ImageIcon("D:/IT-Projekt/PacManProjekt/out/production/PacManProjekt/res/PACMAN_ZU.png");
        //pacmanLbl.setIcon(pacmanIcon);
        pacmanLbl.setSize(22,22);
        pacmanLbl.setVisible(false);
        contentPane.add(pacmanLbl);
        JOptionPane.showMessageDialog(contentPane, "Press 3 times enter to start", "Start Condition", JOptionPane.INFORMATION_MESSAGE);

    }

    public void bewegungAnzeigen(int pacManKoordX, int pacManKoordY) {
        pacmanLbl.setLocation(pacManKoordX, pacManKoordY);
    }
    public void drawLevel(Graphics g/*,class level*/) {
    	for (int y = 0; y < level.getHeight(); y++) {
			for (int x = 0; x < level.getWidth(); x++) {
				/*	public Level(int width, int height) {
		this.width = width;
		this.height = height;

		// create empty playing field
		this.cells = new LevelCell[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++)
				cells[x][y] = new LevelCell();
		}
	}

	public LevelCell getCell(int x, int y) {
		return cells[x][y];
	}

	public LevelCell getCellBounded(int x, int y) {

		if (x < 0)
			return EMPTY_CELL;
		if (y < 0)
			return EMPTY_CELL;
		if (x >= width)
			return EMPTY_CELL;
		if (y >= height)
			return EMPTY_CELL;

		return cells[x][y];
		public class LevelCell {

	public static enum EStatus {
		EMPTY, WALL, PACDOT, PLAYER1_START, GHOST_START;
	}

	/** the status of the current cell */
	/*private EStatus status;

	public LevelCell() {
		this(EStatus.EMPTY);
	}

	public LevelCell(EStatus status) {
		this.status = status;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public boolean mayMoveInto() {
		return getStatus() != EStatus.WALL;
	}
}

	}*/
				//LevelCell cell = level.getCell(x, y);
				switch(cell.getStatus()) {
				case ghost://enum
					g.setColor(Color.black);
					ImageIcon ghostImage = new ImageIcon("Pfad");
				break;
				case playerstart:
				break;
				}
			}}
    }
}
