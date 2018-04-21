import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Screen extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static double scale = 1;

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

		scale = (getWidth() / (double) Level.SIZE) + Level.ZOOM;

		drawBackground(g, level);

		g.scale(scale, scale);

		g.translate(-Level.SIZE * Level.ZOOM * (level.player.x / Level.SIZE), 0);

		drawObjects(g, level);
		drawHitbox(g, level);

		bs.show();
	}

	private void drawBackground(Graphics2D g, Level level) {
		BufferedImage bg = level.getBackground();
		double jumpmax = 0.05;
		double f1 = (getWidth() / (double) bg.getWidth()) + jumpmax;
		double f2 = (getHeight() / (double) bg.getHeight()) + jumpmax;
		double factor = f1 > f2 ? f1 : f2;
		double jumpeffect = (level.player.y / (Level.SIZE * 1.5));
		g.drawImage(bg, (int) (getWidth() / 2 - (bg.getWidth() / 2 * factor)),
				(int) (getHeight() / 2 - (jumpeffect * bg.getHeight() / 2) - (bg.getHeight() / 2 * factor) + (jumpeffect * bg.getHeight())),
				(int) (bg.getWidth() * factor), (int) (bg.getHeight() * factor), null);

	}

	private void drawObjects(Graphics2D g, Level level) {
		for (Object o : level.objects) {
			g.drawImage(o.getTexture(), (int) o.x, (int) ((getHeight() / scale) - o.y - o.getHitbox().height),
					(int) o.getHitbox().width, (int) o.getHitbox().height, null);
		}
	}

	private void drawHitbox(Graphics2D g, Level level) {
		for (Object o : level.objects) {
			g.setColor(Color.RED);
			g.drawRect((int) o.x, (int) ((getHeight() / scale) - o.y - o.getHitbox().height), (int) o.getHitbox().width,
					(int) o.getHitbox().height);
		}
	}

}
