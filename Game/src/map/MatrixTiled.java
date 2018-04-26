package map;

import java.awt.Point;
import java.util.*;
import enums.StructureType;
import model.ObjectGraphic;
import structure.*;
import util.LoadImage;

public class MatrixTiled {
	
	public MatrixTiled(){
		
	}

	public static void insertImagesInTheMatrix(int i, ArrayList<String> images, String[][] imagesMatrix) {
		imagesMatrix[i] = new String [images.size()];
		for (int img=0; img < images.size();img++){
			imagesMatrix[i][img] = "/" + images.get(img);
		}
	}

	public static void insertCoordinatesInTheMatrix(int i, ArrayList<Point> coordinates, Point[][] structuresMap) {
		structuresMap[i] = new Point [coordinates.size()];
		for (int cor=0; cor < coordinates.size();cor++){
			structuresMap[i][cor] = coordinates.get(cor);
		}
	}

	public static void adaptMatrixToStructureAndCreate(ArrayList<String> typeStructures, String[][] image, Point[][] coordinates, List<ObjectGraphic>  structures){
		for(int i = 0; i < coordinates.length; i++){
			for(int j=0; j < coordinates[i].length; j++){
				structures.add(	new Structure(coordinates[i][j], new Point(40,40), LoadImage.loadImageTranslated(image[i][j]), 
								buildTypeOfStructure(typeStructures.get(i))));
			}
		}
	}

	public static TypeOfStructure buildTypeOfStructure(String type) { // por mover a una clase factory
		Map<String, TypeOfStructure> mapTypes = new HashMap<>();
		mapTypes.put("Agua", new TypeOfStructure(StructureType.UNDESTROYABLE, false, true));
		mapTypes.put("Fondo", new TypeOfStructure(StructureType.UNDESTROYABLE, false, false));
		mapTypes.put("Ladrillo", new TypeOfStructure(StructureType.DESTROYABLE, true, true));
		mapTypes.put("Acero", new TypeOfStructure(StructureType.UNDESTROYABLE, true, true));
		mapTypes.put("Panel", new TypeOfStructure(StructureType.UNDESTROYABLE, false, true));
		return mapTypes.get(Optional.ofNullable(type).orElse("Ladrillo"));
	}
	
	public static Point getCoordinate(int sizeTile, int heightMap, int widthMap, int placeOfSprite){
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
}
