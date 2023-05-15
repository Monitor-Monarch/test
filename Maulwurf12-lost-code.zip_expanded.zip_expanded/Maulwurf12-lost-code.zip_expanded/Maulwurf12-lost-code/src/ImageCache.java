import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;

import javax.imageio.ImageIO;

public class ImageCache {

	private Map<String, Image> imageCache = new HashMap<>();

	// Singleton pattern
	private static final ImageCache SELF = new ImageCache();

	public static ImageCache getInstance() {
		return SELF;
	}

	private ImageCache() {
		// private constructor
	}

	public Image getImage(String key) {
		return getImage(key, -1, -1);
	}

	public Image getImage(String key, int dx, int dy) {
		final String cacheKey = key + "-" + dx + ":" + dy;

		final Image image = imageCache.computeIfAbsent(cacheKey, k -> {
			final String imageResource = key;
			final InputStream isImage = ImageCache.class.getResourceAsStream(imageResource);
			if (isImage == null)
				throw new MissingResourceException("Image '" + imageResource + "' not found on classpath",
						ImageCache.class.getName(), key);

			try {
				final Image tempImage;
				final BufferedImage rawImage = ImageIO.read(isImage);

				// Check if scaling is required or if the loaded image already has the expected
				// size.
				if (rawImage.getWidth() == dx && rawImage.getHeight() == dy || dx == -1 || dy == -1)
					tempImage = rawImage;
				else
					tempImage = rawImage.getScaledInstance(dy, dx, Image.SCALE_SMOOTH);
				return tempImage;
			} catch (IOException e) {
				throw new UncheckedIOException(e);
			}
		});

		return image;
	}

}
