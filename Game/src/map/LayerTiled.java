package map;

import java.awt.Point;


public abstract class LayerTiled {
	protected String name;
	protected Point coordinate;
	protected Point size;
	
	public LayerTiled(String name,Point size, Point coordinate){
		this.name = name;
		this.size = size;
		this.coordinate = coordinate;
	}

	public String getNombre() {
		return name;
	}
}
