package main;

import control.Teclado;
import dibujador.Draw;
import dibujador.ViewGame;
import mapa.BringDataOfTheStructure;

public class Juego implements Runnable {
	private static volatile Thread thread; // agregamos el volatile porque estamos usando 2 threads
	private static boolean enFuncionamiento = false;
	private static int aps = 0; // actualizaciones por segundo
	private static int fps = 0; // frames por segundo
	private static int contador_aps = 0; 
	private static int contador_fps = 0; 
	private static Teclado teclado;

	@SuppressWarnings("unused")
	private static ViewGame viewGame;
	private BringDataOfTheStructure dataStructures;
	private Draw draw;
	
	public Juego() {
		
		teclado = new Teclado();
		//addKeyListener(teclado);
		//setFocusable(true);
		dataStructures = new BringDataOfTheStructure();
		dataStructures.llenarLista();
		draw = new Draw(dataStructures.getObjetos());
		viewGame = new ViewGame(draw);
	}

	// synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void iniciar() {
		enFuncionamiento = true;
		thread = new Thread(this, "Graficos");
		thread.start();
	}

	public synchronized void detener() {
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		teclado.actualizar();
		if(teclado.salir) {
			System.exit(0);
		}
		aps++;
	}

	public void mostrar() {
		draw.DrawImages();
		fps++;
	}

	// utilizamos nanosegundos, para evitar conflictos si se ejecuta en otro sistema
	// operativo
	public void run() { // actualiza el avance y dibujos del juego
		final int NS_POR_SEGUNDO = 1000000000; // cantidad de nanosegundos equivalentes a un segundo
		final byte APS_OBJETIVO = 60; // cuantas actualizaciones queremos por segundo (60)
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; // cuantos nanosegundos transcurren por
																			// actualizacion

		long referenciaActualizacion = System.nanoTime(); // se almacena una cantidad exacta de nanosegundos, justo en
															// el momento que se ejecuta
		long referenciaContador = System.nanoTime(); // para contar los frames (EXTRA)

		double tiempoTranscurrido;
		double delta = 0;

		//requestFocus();// saltea tener que hacer el clik en pantalla. (osea, podes tocar teclas cuando
						// se inicia)

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime(); // tomamos la cantidad exacta de nanosegundos cuando comienza el
														// bucle
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;// tomamos el tiempo transcurrido de cada ciclo
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION; // sumamos a delta el tiempo trascurrido del ciclo
																// dividido por los nanosegundos
			while (delta >= 1) { // una vez que delta ya cumplio en llegar a uno de los bytes de APS_OBJETIVO, el
									// juego se actualizara
				actualizar();
				delta--;
			}
			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {// esto hace que el contador se actualice cada
																			// segundo.
				contador_aps = aps;
				contador_fps = fps;
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}

	public static int getCONTADOR_APS() {
		return contador_aps;
	}

	public static int getCONTADOR_FPS() {
		return contador_fps;
	}
	
}
