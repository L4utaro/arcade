package drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import controls.ManagerControl;
import main.Constants;
import main.Game;
import model.ObjectGraphic;

public class Draw  extends Canvas {
	private static final long serialVersionUID = 2L;//-6227038142688953660
	private ArrayList<ObjectGraphic> data;

	public Draw(ArrayList<ObjectGraphic> data) {
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		addKeyListener(ManagerControl.keyboard);
		setFocusable(true);
		requestFocus();
		this.data = data;
	}
	
	public void DrawImages() {
		final BufferStrategy buffer = this.getBufferStrategy();
		if(buffer == null) {
			createBufferStrategy(3);
			return;
		}
		
		final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
		DrawCommand.drawRectangleFill(g, 0, 0, Constants.WIDTH, Constants.HEIGHT, Color.black);
		
		for(ObjectGraphic obj : data) {
			DrawCommand.drawImage(g, obj.getImage(), obj.getCoordinate());
		}

		g.setColor(Color.white);
		DrawCommand.drawString(g, "APS: " + Game.getCONTADOR_APS(), 20, 20);
		DrawCommand.drawString(g, "FPS: " + Game.getCONTADOR_FPS(), 20, 30);
		
		g.dispose();
		buffer.show();
	}
}
