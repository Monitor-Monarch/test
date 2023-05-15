import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.util.Objects;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static java.awt.event.KeyEvent.*;

public class PacManGUI extends JFrame{

	public JPanel contentPane;
	public JLabel pacmanLbl;

	public PacManGUI(Key_Listener derListener) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.addKeyListener(derListener);

	}

	public void addPacman() {
		pacmanLbl = new JLabel("x");
		pacmanLbl.setVerticalAlignment(SwingConstants.TOP);
		pacmanLbl.setSize(22, 22);
		pacmanLbl.setVisible(false);
		contentPane.add(pacmanLbl);
		JOptionPane.showMessageDialog(contentPane, "Press 3 (only 2 times lol) times enter to start", "Start Condition",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	

	public void bewegungAnzeigen(int pacManKoordX, int pacManKoordY) {
		pacmanLbl.setLocation(pacManKoordX, pacManKoordY);
	}

	
}
	

