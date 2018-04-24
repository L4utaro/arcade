package structure;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.ObjectGraphic;

public class Structure extends ObjectGraphic {
	private TypeOfStructure typeOfStructure;
	
	public Structure(Point coordinate, Point size, BufferedImage image, TypeOfStructure typeOfStructure)
	{
		super(coordinate, size, image);
		this.typeOfStructure = typeOfStructure;
	}

	public TypeOfStructure getTypeOfStructure() {
		return typeOfStructure;
	}

	public void setTypeOfStructure(TypeOfStructure typeOfStructure) {
		this.typeOfStructure = typeOfStructure;
	}
}
