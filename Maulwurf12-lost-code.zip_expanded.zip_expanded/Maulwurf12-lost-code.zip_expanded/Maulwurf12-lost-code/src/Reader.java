import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import enums.State;

public class Reader {

	public State[][] reader() throws IOException {
		int anzZeilen = 0;
		int anzZeichen;
		int anzMaps = 1;
		int i = (int) (Math.random() * anzMaps);

		System.out.println(i);
		String randomMap = "/res/Map" + i + ".txt";

		String line;
		List<String> lines = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(Reader.class.getResourceAsStream(randomMap)));
			while ((line = reader.readLine()) != null) {
				anzZeilen++;
				lines.add(line);
			}
			System.out.println("Anzahl Zeilen: " + anzZeilen);
			anzZeichen = lines.get(0).length();
			System.out.print("Anzahl Zeichen einer Zeile: " + anzZeichen);

		} catch (IOException e) {
			System.err.println("Kann '/res/Map" + i + ".txt' nicht finden oder nicht einlesen: " + e);
			throw e;
		}

		int x = anzZeichen;
		int y = anzZeilen;
		State[][] fieldstate = new State[x][y];

		for (int j = 0; j < y; j++) {
			String l = lines.get(j);

			for (int a = 0; a < x; a++) {
				char c = l.charAt(a);

				switch (c) {
				case '#': // Prio 0
					fieldstate[a][j] = State.wall;
					break;

				case '.':
					fieldstate[a][j] = State.pacDot;
					break;

				case '!':
					fieldstate[a][j] = State.item;
					break;

				case 'P':
				case 'p':
					fieldstate[a][j] = State.playerSpawn;
					break;

				case 'G':
				case 'g':
					fieldstate[a][j] = State.ghostSpawn;
					break;

				case ' ':
					fieldstate[a][j] = State.empty;
					break;
				
				case 'M':
				case 'm':
					fieldstate[a][j] = State.modifier;
					break;

				default:
					fieldstate[a][j] = State.empty;
					break;
				}

			}

		}

		return fieldstate;
	}

}
