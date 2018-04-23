package controls;

public class Key {

	private boolean pressed = false;
	private long lastPress = System.nanoTime();

	public void pressedKey() {
		pressed = true;
		lastPress = System.nanoTime();
	}

	public void releasedKey() {
		pressed = false;
	}

	public boolean isPressed() {
		return pressed;
	}

	public long getLastPress() {
		return lastPress;
	}
}