package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up.pressedKey();
			break;
		case KeyEvent.VK_S:
			down.pressedKey();
			break;
		case KeyEvent.VK_A:
			left.pressedKey();
			break;
		case KeyEvent.VK_D:
			right.pressedKey();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			up.releasedKey();
			break;
		case KeyEvent.VK_S:
			down.releasedKey();
			break;
		case KeyEvent.VK_A:
			left.releasedKey();
			break;
		case KeyEvent.VK_D:
			right.releasedKey();
			break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}