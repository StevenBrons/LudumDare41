import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Screen() {

	}

	public void drawAll(Level level) {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(4);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, getWidth(), getHeight());

		
		drawObjects(g, level);
		drawHitbox(g, level);

		bs.show();
	}

	private void drawObjects(Graphics2D g, Level level) {
		for (Object o : level.objects) {
			g.drawImage(o.getTexture(), (int) o.x, (int) o.y, (int) o.getHitbox().width, (int) o.getHitbox().height,
					null);
		}
	}

	private void drawHitbox(Graphics2D g, Level level) {
		for (Object o : level.objects) {
			g.setColor(Color.RED);
			g.drawRect((int) o.x, (int) o.y, (int) o.getHitbox().width, (int) o.getHitbox().height);
		}
	}

}
