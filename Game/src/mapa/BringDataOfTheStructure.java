package mapa;

import java.util.ArrayList;
import main.Constants;
import model.ObjectGraphic;

public class BringDataOfTheStructure {
	private ArrayList<ObjectGraphic> objetos;
	private MapaTiled mapaTiled;
	
	public BringDataOfTheStructure() {
		objetos = new ArrayList<>();
		mapaTiled = new MapaTiled(Constants.RUTA_MAPA_TANK05);
		mapaTiled.inicializar();
	}

	public void llenarLista() {
		mapaTiled.crearEstructuras(objetos);
	}

	public ArrayList<ObjectGraphic> getObjetos() {
		return objetos;
	}
	public void setObjetos(ArrayList<ObjectGraphic> objetos) {
		this.objetos = objetos;
	}
}
