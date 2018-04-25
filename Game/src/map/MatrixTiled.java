package map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import enums.StructureType;
import model.ObjectGraphic;
import structure.Structure;
import structure.TypeOfStructure;
import util.ChargerResource;

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
