package grafico;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprite {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;

	// cloección de hojas de sprites
	public static HojaSprite desierto = new HojaSprite("/texturas/desierto.png", 320, 320);
	// fin de la colección

	public HojaSprite(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		pixeles = new int[ancho * alto];

		BufferedImage imagen;
		try {
			imagen = ImageIO.read(HojaSprite.class.getResource(ruta));
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {

		}
	}

	public int getAncho() {
		return ancho;
	}
}
