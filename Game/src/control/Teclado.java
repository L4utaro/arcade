package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
	private final static int numeroTeclas = 120;
	private final boolean[] teclas = new boolean[numeroTeclas];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean space;
	public boolean salir;
	
	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W]; // la tecla arriba equivale a pulsar W
		abajo = teclas[KeyEvent.VK_S]; // la tecla arriba equivale a pulsar S
		izquierda = teclas[KeyEvent.VK_A]; // la tecla arriba equivale a pulsar A
		derecha = teclas[KeyEvent.VK_D]; // la tecla arriba equivale a pulsar D
		salir = teclas[KeyEvent.VK_ESCAPE];
	}

	// HAY QUE ARREGLAR ESTA PARTE, NO HACE LAS ACCIONES DE DEBAJO
	// teclas que se mantienen pulsada
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true; // pone en true la tecla pulsada
	}

	// teclas que se sueltan
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false; // pone en false tecla soltada

	}

	// pulsar y soltar
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
