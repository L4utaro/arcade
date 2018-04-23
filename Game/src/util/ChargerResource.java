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
	
	public static String readTextFile(final String ruta) {
		String contenido = "";
		InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta);
		BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));
		String linea;
		try {
			while ((linea = lector.readLine()) != null) {
				contenido += linea;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (entradaBytes != null) {
					entradaBytes.close();
				}
				if (lector != null) {
					lector.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return contenido;
	}
	
	public static BufferedImage loadImageTranslated(final String ruta) {
		Image imagen = null;

		try {
			imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

		BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);

		Graphics g = imagenAcelerada.getGraphics();
		g.drawImage(imagen, 0, 0, null);
		g.dispose();

		return imagenAcelerada;
	}

}
