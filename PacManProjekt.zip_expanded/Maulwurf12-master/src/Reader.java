import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Reader {

	private int x = 0;
	private int y = 0;
	private int anzZeilen = 0;
	private int anzZeichen = 0;

	public ENUM.State[][] fieldstate = new ENUM.State[x][y];

	

	@SuppressWarnings("unlikely-arg-type")
	public void reader() {
		String randomMap = "";
		int anzMaps = 1;
		double i = Math.random() * anzMaps;
		System.out.println(i);
		randomMap = "/res/Map" + i + ".txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(randomMap));
			while (reader.readLine() != null) {
				anzZeilen++;
			}
			System.out.println("Anzahl Zeilen: " + anzZeilen);
			String line = reader.readLine();
			anzZeichen = line.length();
			System.out.print("Anzahl Zeichen einer Zeile: " + anzZeichen);

		} catch (IOException e) {
			System.err.println("Kann '/res/Map" + i + ".txt' nicht finden oder nicht einlesen");
		}

		x = anzZeichen;
		y = anzZeilen;

		for (int j = 0; j < y; j++) {
			for (int a = 0; a < x; a++) {
				if (fieldstate[a][j].equals("#")) {		// Prio 0
					fieldstate[a][j] = ENUM.State.wall;
				} else if (fieldstate[a][j].equals(".")) {
					fieldstate[a][j] = ENUM.State.pacDot;
				} else if (fieldstate[a][j].equals("!")) {
					fieldstate[a][j] = ENUM.State.item;
				} else if (fieldstate[a][j].equals("p")) {	// Prio 0
					fieldstate[a][j] = ENUM.State.playerSpawn;
				} else if (fieldstate[a][j].equals("g")) {	// Prio 1
					fieldstate[a][j] = ENUM.State.ghostSpawn;
				} else if (fieldstate[a][j].equals(" ")) {
					fieldstate[a][j] = ENUM.State.empty;
				} else if (fieldstate[a][j].equals("m")) {	// Pacman kann Geister jagen Prio 2 + Geschwindi
					fieldstate[a][j] = ENUM.State.modifier;
				}

			}

		}

	}

}
