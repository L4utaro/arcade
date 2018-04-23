package drawer;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import main.Constants;
import util.ChargerResource;

public class ViewGame {		
	//private static final long serialVersionUID = 1L;
	private static JFrame view;
	private final ImageIcon icon;
	
	public ViewGame(Draw draw){
		BufferedImage image = ChargerResource.loadImageTranslated(Constants.ROUTE_ICON);
		this.icon = new ImageIcon(image);
		configureView(draw);
	}
	
	public void configureView(Draw draw){
		view = new JFrame(Constants.GAMENAME);
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
