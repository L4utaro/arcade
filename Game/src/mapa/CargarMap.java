package mapa;

public class CargarMap {
	private MapaTiled mapa;
	
	public CargarMap( String archivo)
	{	
		this.mapa= new MapaTiled(archivo);
	}
	
	public  void cargarMapa() 
	{
		this.mapa.inicializar();
		
	}
}