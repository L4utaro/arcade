package dibujador;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import main.Constantes;
import main.Juego;
import modelo.ObjectGraphic;

public class Draw  extends Canvas {
	private static final long serialVersionUID = -6227038142688953660L;
	private ArrayList<ObjectGraphic> datos;

	public Draw(ArrayList<ObjectGraphic> datos) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(Constantes.ANCHO, Constantes.ALTO));
		//addKeyListener(GestorControles.teclado);
		setFocusable(true);
		requestFocus();
		this.datos = datos;
	}
	
	public void DrawImages() {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		
		//DrawDebug.reiniciarContadorObjetos();

		DrawDebug.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO, Constantes.ALTO, Color.black);

		//if (Constantes.FACTOR_ESCALADO_X != 1.0 || Constantes.FACTOR_ESCALADO_Y != 1.0) {
		//	g.scale(Constantes.FACTOR_ESCALADO_X, Constantes.FACTOR_ESCALADO_Y);
		//}

		g.setColor(Color.white);

		DrawDebug.dibujarString(g, "APS: " + Juego.getCONTADOR_APS(), 20, 20);
		DrawDebug.dibujarString(g, "FPS: " + Juego.getCONTADOR_FPS(), 20, 30);

		//DatosDebug.enviarDato("ESCALA X: " + Constantes.FACTOR_ESCALADO_X);
		//DatosDebug.enviarDato("ESCALA Y: " + Constantes.FACTOR_ESCALADO_Y);
		//DatosDebug.enviarDato("OPF: " + DrawDebug.obtenerContadorObjetos());

	/*	if (GestorControles.teclado.debug) {
			DatosDebug.dibujarDatos(g);
		} else {
			DatosDebug.vaciarDatos();
		}*/

		//Toolkit.getDefaultToolkit().sync();
		//-------

		for(ObjectGraphic obj : datos) {
			DrawDebug.dibujarImagen(g, obj.getImage(), obj.getCoordinate());
		}
		g.dispose();
		buffer.show();
	}
}
