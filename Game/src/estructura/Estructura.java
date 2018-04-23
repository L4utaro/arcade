package estructura;

import java.awt.Point;
import java.awt.image.BufferedImage;

import modelo.ObjectGraphic;

public class Estructura extends ObjectGraphic {
	private TipoDeEstructura tipoDeEstructura;
	
	public Estructura(Point coordinate, Point size, BufferedImage imagen, TipoDeEstructura tipoDeEstructura)
	{
		super(coordinate, size, imagen);
		this.tipoDeEstructura = tipoDeEstructura;
	}

	public TipoDeEstructura getTipoDeEstructura() {
		return tipoDeEstructura;
	}

	public void setTipoDeEstructura(TipoDeEstructura tipoDeEstructura) {
		this.tipoDeEstructura = tipoDeEstructura;
	}
}
