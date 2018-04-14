package grafico;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprite {
	private final int ancho;
	private final int alto;
	public final int [] pixeles;
	
	public HojaSprite(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		pixeles = new int[ancho*alto];
		
		BufferedImage imagen;
		try {
			imagen = ImageIO.read (HojaSprite.class.getResource(ruta));
		} catch (IOException e) {

		}
	}

	public int getAncho() {
		return ancho;
	}
}