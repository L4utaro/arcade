package mapa;

import java.awt.Point;

public class CapaSprites extends CapaTiled{
	private String imagenCapa;
	private int[] arrayPosSprites;
	private String[] spritesImagenes;
	
	public CapaSprites(String nombre, String imagenCapa, Point size, Point coordinate, int []arrayPosSprites, String[] spritesCapaDeImagenes){
		super(nombre, size, coordinate);
		this.imagenCapa = imagenCapa;
		this.arrayPosSprites = arrayPosSprites;
		this.spritesImagenes = spritesCapaDeImagenes;
	}

	public int[] getArrayPosSprites() {
		return arrayPosSprites;
	}

	public String getImagenCapa() {
		return imagenCapa;
	}

	public String[] getSpritesImagenes() {
		return spritesImagenes;
	}
}
