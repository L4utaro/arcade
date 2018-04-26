package main;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import claseProperties.EleccionMenu;
import claseProperties.Principal;
import views.PrincipalView;

public class ControlPrincipalView implements ActionListener{
	
	private PrincipalView principalView;
	
	public ControlPrincipalView() {
		principalView = new PrincipalView();
		this.principalView.getBtnPlay().addActionListener(this);
		this.principalView.getBtnConfiguration().addActionListener(this);
		this.principalView.getBtnAccept().addActionListener(this);
	}
	
	public void iniciar() {
		this.principalView.getFrmPrincipalView().setVisible(true);		//encapsular codigo repetido
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//FactoryActioner
		if (e.getSource() == this.principalView.getBtnConfiguration()) {
			this.principalView.getConfigurationPanel().setVisible(true);
		}
		
		else if (e.getSource() == this.principalView.getBtnAccept()) {
			this.principalView.getConfigurationPanel().setVisible(false);

			String up = this.principalView.getTextFieldUp().getText();		//encapsular codigo repetido
			String down = this.principalView.getTextFieldDown().getText();	//encapsular codigo repetido
			String left = this.principalView.getTextFieldLeft().getText();	//encapsular codigo repetido
			String right = this.principalView.getTextFieldRight().getText();//encapsular codigo repetido
			//String shoot = this.principalView.getTextShoot().getText(); // AGREGAR TECLA DE DISPARO
			// guardar informacion de la configuracion

			EleccionMenu eleccion = new EleccionMenu(up, down, left, right, "shoot", 300, 300, 40, 40, "image");
			Principal principal = new Principal();
			principal.modificarArchivo(eleccion);
		}
		
		else if (e.getSource() == this.principalView.getBtnPlay()) {
			//loadMap();
			this.principalView.getFrmPrincipalView().dispose();
			Game game = new Game();
			game.start();
		}
		
	}

	private void loadMap() {
		System.out.println("si");
		if (this.principalView.getRdbtnBomberman().isSelected()){
			System.out.println(this.principalView.getRdbtnBomberman().getName());
		}
		
	}
}

