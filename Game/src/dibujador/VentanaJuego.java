package dibujador;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import main.Constantes;

public class VentanaJuego extends Canvas{		
	private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	
	public VentanaJuego(){
		configurarVentana();
	}
	
	private void configurarVentana(){
		setPreferredSize(new Dimension(Constantes.ANCHO, Constantes.ALTO));
		ventana = new JFrame(Constantes.NOMBREJUEGO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
