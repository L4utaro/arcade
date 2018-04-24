package map;

import java.awt.Point;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReaderTiled {
	private int widthMapInTiles;
	private int heightMapInTiles;
	private JSONObject globalJSON;
	private JSONArray layers;
	private JSONArray layersofImages;
	
	public ReaderTiled(String content){
		globalJSON = getObjectJSON(content);
		widthMapInTiles = getIntFromJSON(globalJSON,"width");
		heightMapInTiles = getIntFromJSON(globalJSON,"height");
		layers = getArrayJSON(globalJSON.get("layers").toString());
		layersofImages = getArrayJSON(globalJSON.get("tilesets").toString());
	}

	public void getLayers(ArrayList<LayerSprite> layersOfSprites){
		for(int i=0; i < layers.size(); i++){
			JSONObject layerData = getObjectJSON(layers.get(i).toString());
			JSONObject layerDataImage  = getObjectJSON(layersofImages.get(i).toString());

			int widthLayer = getIntFromJSON(layerData, "width");
			int heightLayer = getIntFromJSON(layerData, "height");
			int xLayer = getIntFromJSON(layerData, "y");
			int yLayer = getIntFromJSON(layerData, "x");
			String nameLayer = getStringFromJSON(layerData, "name");
			String imageLayer = getStringFromJSON(layerDataImage, "image");

			String type = layerData.get("type").toString();
			
			switch(type){
				case "tilelayer":
					JSONArray sprites = getArrayJSON(layerData.get("data").toString());
					int[] spritesLayer = new int [sprites.size()];
					String[] layerSpritesImages = new String [sprites.size()];//ESTO ES PARA PACMAN
					for(int j=0; j < sprites.size();j++){
						//aca tenemos cada numero del vector de una capa
						int codeSprite = Integer.parseInt(sprites.get(j).toString());
						spritesLayer[j] = codeSprite -1;
						layerSpritesImages[j] = bringImageFromJSON(spritesLayer[j]+1);//ESTO ES PARA PACMAN
					}
					layersOfSprites.add(new LayerSprite(nameLayer, imageLayer, new Point (widthLayer,heightLayer),new Point (xLayer,yLayer),spritesLayer,layerSpritesImages));
					break;
			}
		}
	}

	public String bringImageFromJSON(int layerSprite) {//ESTO ES PARA PACMAN
		for(int i=0; i < layersofImages.size(); i++){//obtengo una de las capas de imagenes
			JSONObject layerDataImage = getObjectJSON(layersofImages.get(i).toString());
			if(getStringFromJSON(layerDataImage, "firstgid").equals(""+layerSprite)){
				return getStringFromJSON(layerDataImage, "image");
			}
		}	
		return "-1";
	}
	
	private JSONObject getObjectJSON(final String codeJSON){
		JSONParser reader = new JSONParser();
		JSONObject objectJSON = null;
		try{
			Object recovered = reader.parse(codeJSON);
			objectJSON = (JSONObject) recovered;
		}catch(ParseException e){
			//System.out.println("Posicion: " + e.getPosition());
			//System.out.println(e);
		}
		return objectJSON;
	}
	
	private JSONArray getArrayJSON(final String codigoJSON){
		JSONParser reader = new JSONParser();
		JSONArray arrayJSON = null;
		try{
			Object recovered = reader.parse(codigoJSON);
			arrayJSON = (JSONArray) recovered;
		}catch(ParseException e){
			//System.out.println("Posicion: " + e.getPosition());
			//System.out.println(e);
		}
		
		return arrayJSON;
	}
	
	
	private int getIntFromJSON(final JSONObject objectJSON, final String key){
		return Integer.parseInt(objectJSON.get(key).toString());
	}
	
	private String getStringFromJSON(final JSONObject objectJSON, final String key){
		return (objectJSON.get(key).toString());
	}

	public int getWidthMapInTiles() {
		return widthMapInTiles;
	}

	public int getHeightMapInTiles() {
		return heightMapInTiles;
	}
}

