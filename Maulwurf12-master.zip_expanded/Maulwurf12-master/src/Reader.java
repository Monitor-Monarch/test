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

	State[][] fieldstate = new State[x][y];

	public enum State {
		wall, pacDot, playerSpawn, ghostSpawn, item, empty, modifier
	}

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
				if (fieldstate[a][j].equals("#")) {
					fieldstate[a][j] = State.wall;
					System.out.println();
				} else if (fieldstate[a][j].equals(".")) {
					fieldstate[a][j] = State.pacDot;
				} else if (fieldstate[a][j].equals("!")) {
					fieldstate[a][j] = State.item;
				} else if (fieldstate[a][j].equals("p")) {
					fieldstate[a][j] = State.playerSpawn;
				} else if (fieldstate[a][j].equals("g")) {
					fieldstate[a][j] = State.ghostSpawn;
				} else if (fieldstate[a][j].equals(" ")) {
					fieldstate[a][j] = State.empty;
				} else if (fieldstate[a][j].equals("m")) {
					fieldstate[a][j] = State.modifier;
				}

			}

		}

	}

}
