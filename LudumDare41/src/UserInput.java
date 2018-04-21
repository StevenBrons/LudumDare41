import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserInput implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			Player.UP = true;
			break;
		case KeyEvent.VK_A:
			Player.LEFT = true;
			break;
		case KeyEvent.VK_S:
			Player.DOWN = true;
			break;
		case KeyEvent.VK_D:
			Player.RIGHT = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			Player.UP = false;
			break;
		case KeyEvent.VK_A:
			Player.LEFT = false;
			break;
		case KeyEvent.VK_S:
			Player.DOWN = false;
			break;
		case KeyEvent.VK_D:
			Player.RIGHT = false;
			break;
		}
	}

}
