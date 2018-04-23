package dibujador;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import main.Constantes;
import util.CargadorRecursos;

public class ViewGame {		
	//private static final long serialVersionUID = 1L;
	private static JFrame view;
	private final ImageIcon icon;
	
	public ViewGame(Draw draw){
		BufferedImage image = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_ICON);
		this.icon = new ImageIcon(image);
		configureView(draw);
	}
	
	public void configureView(Draw draw){
		view = new JFrame(Constantes.NOMBREJUEGO);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setIconImage(icon.getImage());
		view.setResizable(false);
		view.setLayout(new BorderLayout());
		view.add(draw, BorderLayout.CENTER);
		view.setUndecorated(true);
		view.pack();
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}
}
