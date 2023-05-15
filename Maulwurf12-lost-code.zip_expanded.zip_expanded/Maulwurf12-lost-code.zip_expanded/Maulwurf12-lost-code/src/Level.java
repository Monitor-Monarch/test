import enums.State;

public class Level {

	private int width = 800; // noch keinen wert
	private int height = 600; // noch keinen wert
	private final LevelCell[][] cells;
	private static final LevelCell EMPTY_CELL = new LevelCell(State.empty);

	public void setCell(int x, int y, LevelCell status) {
		cells[x][y] = status;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public LevelCell getCellBounded(int x, int y) {// alles au�erhalb des Bildschrims = empty

		if (x < 0)
			return EMPTY_CELL;
		if (y < 0)
			return EMPTY_CELL;
		if (x >= width)
			return EMPTY_CELL;
		if (y >= height)
			return EMPTY_CELL;

		return cells[x][y];
	}

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new LevelCell[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++)
				cells[x][y] = new LevelCell();
		}

	}

	public LevelCell getCell(int x, int y) {
		return cells[x][y];
	}
}
