package map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.StructureType;
import model.ObjectGraphic;
import structure.Structure;
import structure.TypeOfStructure;
import util.ChargerResource;

public class MapTiled {
	private String content;
	private ArrayList<LayerSprite> layersOfSprites;
	private ReaderTiled readerTiled;
	private Point[][] structuresMap; 
	private ArrayList<String> typeOfStructures;
	private String[][] images;
	
	public MapTiled(final String route){
		content = ChargerResource.readTextFile(route);
		readerTiled = new ReaderTiled(content);
		this.layersOfSprites = new ArrayList<LayerSprite>();
		this.typeOfStructures = new ArrayList<>();
	}
	
	public void initialize(){
		readerTiled.getLayers(layersOfSprites);
	}
	
	public Point getCoordinate(int sizeTile, int heightMap, int widthMap, int placeOfSprite){
		int count = 0;
		for(int y=0; y < heightMap;y++){
			for(int x=0; x < widthMap; x++){
				if(count == placeOfSprite){
					return new Point (x*sizeTile,y*sizeTile);
				}
				count = count + 1 ;
			}
		}
		return null;
	}
	
	public void createStructures(List<ObjectGraphic> structures){
		this.structuresMap = new Point[layersOfSprites.size()][];
		this.images = new String [layersOfSprites.size()][];
		for (int i = 0; i < layersOfSprites.size(); i++) {//RECORRO LAS CAPAS
			int totalTilesByLayer = 0;
			ArrayList<Point> coordinates = new ArrayList<>();
			ArrayList<String> images = new ArrayList<>();
			for (int j = 0; j < layersOfSprites.get(i).getArrayPosSprites().length; j++) {//RECORRO LOS TILES DE CADA CAPA
				if (layersOfSprites.get(i).getArrayPosSprites()[j] != -1) {
					totalTilesByLayer = totalTilesByLayer + 1; //GUARDO EL TOTAL DE TILES DE LA CAPA
					coordinates.add(getCoordinate(40, readerTiled.getHeightMapInTiles(), readerTiled.getWidthMapInTiles(), j)); //GUARDO TODAS LAS COORDENADAS
					images.add(layersOfSprites.get(i).getArrayImagesSprites()[j]);
				}
			}
			insertCoordinatesInTheMatrix(i, coordinates);
			insertImagesInTheMatrix(i, images);
			this.typeOfStructures.add(layersOfSprites.get(i).getNombre());
			coordinates.removeAll(coordinates);
		}
		adaptMatrixToStructureAndCreate(this.typeOfStructures, this.images, this.structuresMap, structures);
	}

	private void insertImagesInTheMatrix(int i, ArrayList<String> images) {
		this.images[i] = new String [images.size()];
		for (int img=0; img < images.size();img++){
			this.images[i][img] = "/" + images.get(img);
		}
	}

	private void insertCoordinatesInTheMatrix(int i, ArrayList<Point> coordinates) {
		structuresMap[i] = new Point [coordinates.size()];
		for (int cor=0; cor < coordinates.size();cor++){
			structuresMap[i][cor] = coordinates.get(cor);
		}
	}

	private void adaptMatrixToStructureAndCreate(ArrayList<String> typeStructures, String[][] image, Point[][] coordinates, List<ObjectGraphic>  structures){
		for(int i = 0; i < coordinates.length; i++){
			for(int j=0; j < coordinates[i].length; j++){
				if(typeStructures.get(i).equals("Agua"))
					structures.add(new Structure(coordinates[i][j], new Point(40,40), ChargerResource.loadImageTranslated(image[i][j]), new TypeOfStructure(StructureType.UNDESTROYABLE,false,true)));
				else if(typeStructures.get(i).equals("Fondo"))
					structures.add(new Structure(coordinates[i][j], new Point(40,40), ChargerResource.loadImageTranslated(image[i][j]), new TypeOfStructure(StructureType.UNDESTROYABLE,false,false)));
				else if(typeStructures.get(i).equals("Ladrillo"))
					structures.add(new Structure(coordinates[i][j], new Point(40,40), ChargerResource.loadImageTranslated(image[i][j]), new TypeOfStructure(StructureType.DESTROYABLE,true,true)));
				else
					structures.add(new Structure(coordinates[i][j], new Point(40,40), ChargerResource.loadImageTranslated(image[i][j]), new TypeOfStructure(StructureType.UNDESTROYABLE,true, true)));
			}
		}
	}
}