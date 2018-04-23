package mapa;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.TipoEstructura;
import estructura.Estructura;
import estructura.TipoDeEstructura;
import model.ObjectGraphic;
import util.ChargerResource;

public class MapaTiled {
	private String contenido;
	private ArrayList<CapaSprites> capasDeSprites;
	private LectorTiled lectorTiled;
	private Point[][] estructurasMapa; 
	private ArrayList<String> tiposDeEstructuras;
	private String[][] imagenes;
	
	public MapaTiled(final String ruta){
		contenido = ChargerResource.readTextFile(ruta);
		lectorTiled = new LectorTiled(contenido);
		this.capasDeSprites = new ArrayList<CapaSprites>();
		this.tiposDeEstructuras = new ArrayList<>();
	}
	
/*	public void controlarCargaDeMapa(final String ruta){
		try{
			contenido = CargadorRecursos.leerArchivoTexto(ruta);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"El mapa no existe o no es del formato .csv","Error!! Mapa invalido", JOptionPane.WARNING_MESSAGE);
		}
	}*/
	
	public void inicializar(){
		lectorTiled.obtenerCapas(capasDeSprites);
	}
	
		
	public Point obtenerCoordenada(int tamanoDeTiles, int altoMapa, int anchoMapa, int lugarDelSprite){
		int contador = 0;
		for(int y=0; y < altoMapa;y++){
			for(int x=0; x < anchoMapa; x++){
				if(contador == lugarDelSprite){
					return new Point (x*tamanoDeTiles,y*tamanoDeTiles);
				}
				contador = contador + 1 ;
			}
		}
		return null;
	}
	
	public void crearEstructuras(List<ObjectGraphic>  estructuras){
		this.estructurasMapa = new Point[capasDeSprites.size()][];
		this.imagenes = new String [capasDeSprites.size()][];
		for (int i = 0; i < capasDeSprites.size(); i++) {//RECORRO LAS CAPAS
			int totalTilesPorCapa = 0;
			ArrayList<Point> coordenadas = new ArrayList<>();
			ArrayList<String> imagenes = new ArrayList<>();
			for (int j = 0; j < capasDeSprites.get(i).getArrayPosSprites().length; j++) {//RECORRO LOS TILES DE CADA CAPA
				if (capasDeSprites.get(i).getArrayPosSprites()[j] != -1) {
					totalTilesPorCapa = totalTilesPorCapa + 1; //GUARDO EL TOTAL DE TILES DE LA CAPA
					coordenadas.add(obtenerCoordenada(40, lectorTiled.getAltoMapaEnTiles(), lectorTiled.getAnchoMapaEnTiles(), j)); //GUARDO TODAS LAS COORDENADAS
					imagenes.add(capasDeSprites.get(i).getSpritesImagenes()[j]);
				}
			}
			insertarCoordenadasEnLaMatriz(i, coordenadas);
			insertarImagenesEnLaMatriz(i, imagenes);
			this.tiposDeEstructuras.add(capasDeSprites.get(i).getNombre());
			coordenadas.removeAll(coordenadas);
		}
		adaptarMatrizAEstructuraYCrearlas(this.tiposDeEstructuras, this.imagenes, this.estructurasMapa, estructuras);
	}

	private void insertarImagenesEnLaMatriz(int i, ArrayList<String> imagenes) {
		this.imagenes[i] = new String [imagenes.size()];
		for (int img=0; img < imagenes.size();img++){
			this.imagenes[i][img] = "/" + imagenes.get(img);
		}
	}

	private void insertarCoordenadasEnLaMatriz(int i, ArrayList<Point> coordenadas) {
		estructurasMapa[i] = new Point [coordenadas.size()];
		for (int cor=0; cor < coordenadas.size();cor++){
			estructurasMapa[i][cor] = coordenadas.get(cor);
		}
	}

	private void adaptarMatrizAEstructuraYCrearlas(ArrayList<String> tipoEstructura, String[][] imagen, Point[][] coordenadas, List<ObjectGraphic>  estructuras){
		for(int i = 0; i < coordenadas.length; i++){
			for(int j=0; j < coordenadas[i].length; j++){
				if(tipoEstructura.get(i).equals("Agua"))
					estructuras.add(new Estructura(coordenadas[i][j], new Point(40,40), ChargerResource.loadImageTranslated(imagen[i][j]), new TipoDeEstructura(TipoEstructura.INDESTRUCTIBLE,false,true)));
				else if(tipoEstructura.get(i).equals("Fondo"))
					estructuras.add(new Estructura(coordenadas[i][j], new Point(40,40), ChargerResource.loadImageTranslated(imagen[i][j]), new TipoDeEstructura(TipoEstructura.INDESTRUCTIBLE,false,false)));
				else if(tipoEstructura.get(i).equals("Ladrillo"))
					estructuras.add(new Estructura(coordenadas[i][j], new Point(40,40), ChargerResource.loadImageTranslated(imagen[i][j]), new TipoDeEstructura(TipoEstructura.DESTRUCTIBLE,true,true)));
				else
					estructuras.add(new Estructura(coordenadas[i][j], new Point(40,40), ChargerResource.loadImageTranslated(imagen[i][j]), new TipoDeEstructura(TipoEstructura.INDESTRUCTIBLE,true, true)));
			}
		}
	}
}