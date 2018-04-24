package claseProperties;

public class EleccionMenu {
	public String tecla_movimiento_arriba;
	public String tecla_movimiento_abajo;
	public String tecla_movimiento_izquierda;
	public String tecla_movimiento_derecha;
	public String tecla_disparo;
	public int personaje1_posX;
	public int personaje1_posY;
	public int personaje1_height;
	public int personaje1_width;
	public String personaje1_string_imagen;

	public EleccionMenu(String tecla_movimiento_arriba, String tecla_movimiento_abajo, String tecla_movimiento_izquierda,
			String tecla_movimiento_derecha, String tecla_disparo, int personaje1_posX, int personaje1_posY, int personaje1_height, int personaje1_width,
			String personaje1_string_imagen) {
		this.tecla_movimiento_arriba= tecla_movimiento_arriba;
		this.tecla_movimiento_abajo= tecla_movimiento_abajo;
		this.tecla_movimiento_izquierda= tecla_movimiento_izquierda;
		this.tecla_movimiento_derecha= tecla_movimiento_derecha;
		this.tecla_disparo= tecla_disparo;
		
		this.personaje1_posX= personaje1_posX;
		this.personaje1_posY= personaje1_posY;
		this.personaje1_height= personaje1_height;
		this.personaje1_width= personaje1_width;
		this.personaje1_string_imagen= personaje1_string_imagen;
	}


	
	
	
}
