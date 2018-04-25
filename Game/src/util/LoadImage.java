package util;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {

	public static BufferedImage loadImageTranslated(final String route) {
		Image image = null;

		try {
			image = ImageIO.read(ClassLoader.class.getResource(route));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

		BufferedImage acceleratedImage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), Transparency.TRANSLUCENT);

		Graphics g = acceleratedImage.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return acceleratedImage;
	}
}
