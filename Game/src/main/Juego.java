package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Teclado;
//import dibujador.VentanaJuego;

public class Juego extends Canvas implements Runnable{
	//private static VentanaJuego ventanaJuego;
	private static volatile Thread thread;		//agregamos el volatile porque estamos usando 2 threads
	private static boolean enFuncionamiento = false;
	private static int aps = 0; //actualizaciones por segundo
	private static int fps = 0; //frames por segundo
	private static Teclado teclado;
	
	//ventanaJuego
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	//ventanaJuego
	
	public Juego(){
		//ventanaJuego
		setPreferredSize(new Dimension(Constantes.ANCHO, Constantes.ALTO));
		ventana = new JFrame(Constantes.NOMBREJUEGO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		//ventanaJuego
		
		teclado = new Teclado();
		addKeyListener(teclado);
		setFocusable(true);
		//ventanaJuego = new VentanaJuego();
	}
	//synchronized permite que no se puedan ejecutar al mismo tiempo
	public synchronized void iniciar(){
		enFuncionamiento = true;
		thread = new Thread(this,"Graficos");
		thread.start();
	}
	
	public synchronized void detener(){
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar(){
		teclado.actualizar();
		if(teclado.w) {
			System.out.println("arriba");
		}
		if(teclado.s) {
			System.out.println("abajo");
		}
		if(teclado.a) {
			System.out.println("izquierda");
		}
		if(teclado.d) {
			System.out.println("derecha");
		}
		aps++;
	}
	
	public void mostrar(){
		fps++;
	}
	//utilizamos nanosegundos, para evitar conflictos si se ejecuta en otro sistema operativo
	public void run() {														//actualiza el avance y dibujos del juego 
		final int NS_POR_SEGUNDO = 1000000000; 								//cantidad de nanosegundos equivalentes a un segundo
		final byte APS_OBJETIVO = 60;										//cuantas actualizaciones queremos por segundo (60)
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; 	//cuantos nanosegundos transcurren por actualizacion
		
		long referenciaActualizacion = System.nanoTime();	//se almacena una cantidad exacta de nanosegundos, justo en el momento que se ejecuta
		long referenciaContador = System.nanoTime();		//para contar los frames (EXTRA)
		
		double tiempoTranscurrido;
		double delta = 0;
		
		requestFocus();//saltea tener que hacer el clik en pantalla. (osea, podes tocar teclas cuando se inicia)
		
		while(enFuncionamiento){
			final long inicioBucle = System.nanoTime();		//tomamos la cantidad exacta de nanosegundos cuando comienza el bucle
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;//tomamos el tiempo transcurrido de cada ciclo
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;	//sumamos a delta el tiempo trascurrido del ciclo dividido por los nanosegundos
			while (delta >= 1){			//una vez que delta ya cumplio en llegar a uno de los bytes de APS_OBJETIVO, el juego se actualizara
				actualizar();
				delta--;
			}
			mostrar();
			
			if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){//esto hace que el contador se actualice cada segundo.
				System.out.println("APS: " + aps + " || FPS: " + fps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}
