package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class ObjectGraphic {
	protected Point coordinate;
	protected Point size;
	protected BufferedImage image;

	public ObjectGraphic(Point coordinate, Point size, BufferedImage imagen) {
		this.coordinate = coordinate;
		this.size = size;
		this.image = imagen;
	}

	public ObjectGraphic(Point coordinate, Point size) {
		this.coordinate = coordinate;
		this.size = size;
	}

	public ObjectGraphic(BufferedImage image) {
		this.image = image;
	}

	public BufferedImage getImage() {
		return this.image;
	}

	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

	public Point getSize() {
		return size;
	}

	public void setSize(Point size) {
		this.size = size;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
