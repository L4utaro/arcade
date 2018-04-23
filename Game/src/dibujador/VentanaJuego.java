package dibujador;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import main.Constantes;
import util.CargadorRecursos;

public class VentanaJuego {		
	//private static final long serialVersionUID = 1L;
	private static JFrame ventana;
	private final ImageIcon icono;
	
	public VentanaJuego(Draw draw){
		BufferedImage imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_ICONO);
		this.icono = new ImageIcon(imagen);
		configurarVentana(draw);
	}
	
	public void configurarVentana(Draw draw){
		ventana = new JFrame(Constantes.NOMBREJUEGO);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setIconImage(icono.getImage());
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(draw, BorderLayout.CENTER);
		ventana.setUndecorated(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}
}
