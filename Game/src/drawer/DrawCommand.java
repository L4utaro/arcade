package drawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class DrawCommand {
	
	public static void drawImage(final Graphics g, final BufferedImage img, final Point p) {
		g.drawImage(img, p.x, p.y, null);
	}

	public static void drawString(final Graphics g, final String s, final int x, final int y) {
		g.drawString(s, x, y);
	}

	public static void drawRectangleFill(final Graphics g, final int x, final int y, final int ancho, final int alto, final Color c) {
		g.setColor(c);
		g.fillRect(x, y, ancho, alto);
	}

}