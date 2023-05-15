import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private Level level = new Level(34, 34);

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	protected void paintComponent(Graphics g) {
		for (int y = 0; y < level.getHeight(); y++)
			for (int x = 0; x < level.getWidth(); x++) {

				LevelCell cell = level.getCell(x, y);
				final int gx = 32 * x;
				final int gy = 32 * y;
				final int dx = 32;
				final int dy = 32;

				switch (cell.getStatus()) {
				case ghostSpawn:
					g.setColor(Color.BLACK);
					g.fillRect(gx, gy, dx, dy);
					final Image ghostImage = ImageCache.getInstance().getImage("/res/BLINKY_LINKS.png", dx, dy);
					if (ghostImage != null)
						g.drawImage(ghostImage, gx, gy, this);
					break;

				case playerSpawn:
					g.setColor(Color.BLACK);
					g.fillRect(gx, gy, dx, dy);
					final Image playerImage = ImageCache.getInstance().getImage("/res/PACMAN_AUF.png", dx, dy);
					if (playerImage != null)
						g.drawImage(playerImage, gx, gy, this);
					break;

				case empty:
					final Image emptyImage = ImageCache.getInstance().getImage("/res/index.jpg", dx, dy);
					if (emptyImage != null)
						g.drawImage(emptyImage, gx, gy, this);
					break;

				case wall:
					final Image wallImage = ImageCache.getInstance().getImage("/res/PINKY_UNTEN.png", dx, dy);
					if (wallImage != null)
						g.drawImage(wallImage, gx, gy, this);
					break;

				case pacDot:
					final Image dotbackImage = ImageCache.getInstance().getImage("/res/PINKY_UNTEN.png", dx, dy);// emptyImage
					if (dotbackImage != null)
						g.drawImage(dotbackImage, gx, gy, this);
					g.setColor(Color.GREEN);

					//g.drawOval(gx + 4, gy + 4, dx - 8, dy - 8);
					break;
				default:
					break;
				}

			}
	}

}
