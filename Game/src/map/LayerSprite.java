package map;

import java.awt.Point;

public class LayerSprite extends LayerTiled{
	private String layerImage;
	private int[] arrayPosSprites;
	private String[] arrayImagesSprites;
	
	public LayerSprite(String name, String layerImage, Point size, Point coordinate, int []arrayPosSprites, String[] arrayImagesSprites){
		super(name, size, coordinate);
		this.layerImage = layerImage;
		this.arrayPosSprites = arrayPosSprites;
		this.arrayImagesSprites = arrayImagesSprites;
	}

	public int[] getArrayPosSprites() {
		return arrayPosSprites;
	}

	public String getLayerImage() {
		return layerImage;
	}

	public String[] getArrayImagesSprites() {
		return arrayImagesSprites;
	}
}
