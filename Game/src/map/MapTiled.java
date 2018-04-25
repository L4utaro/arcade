package map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.ObjectGraphic;
import util.ReadTextFile;

public class MapTiled {
	private String content;
	private ArrayList<LayerSprite> layersOfSprites;
	private ReaderTiled readerTiled;
	private Point[][] structuresMap; 
	private ArrayList<String> typeOfStructures;
	private String[][] images;
	
	public MapTiled(final String route){
		content = ReadTextFile.readTextFile(route);
		readerTiled = new ReaderTiled(content);
		this.layersOfSprites = new ArrayList<LayerSprite>();
		this.typeOfStructures = new ArrayList<>();
	}
	
	public void initialize(){
		readerTiled.getLayers(layersOfSprites);
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
					coordinates.add(MatrixTiled.getCoordinate(40, readerTiled.getHeightMapInTiles(), readerTiled.getWidthMapInTiles(), j)); //GUARDO TODAS LAS COORDENADAS
					images.add(layersOfSprites.get(i).getArrayImagesSprites()[j]);
				}
			}
			MatrixTiled.insertCoordinatesInTheMatrix(i, coordinates, structuresMap);
			MatrixTiled.insertImagesInTheMatrix(i, images, this.images);
			this.typeOfStructures.add(layersOfSprites.get(i).getNombre());
			coordinates.removeAll(coordinates);
		}
		MatrixTiled.adaptMatrixToStructureAndCreate(this.typeOfStructures, this.images, this.structuresMap, structures);
	}
}