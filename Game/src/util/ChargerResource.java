package util;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class ChargerResource {
	
	public static String readTextFile(final String route) {
		String content = "";
		InputStream imputBytes = ClassLoader.class.getResourceAsStream(route);
		BufferedReader reader = new BufferedReader(new InputStreamReader(imputBytes));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (imputBytes != null) {
					imputBytes.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return content;
	}
	
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
