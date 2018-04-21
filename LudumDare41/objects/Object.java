import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Object {

	double x;
	double y;

	public void show(Graphics2D g) {
	}

	public boolean intersects(Object o) {
		return (new Rectangle2D.Double(x, y, getHitbox().getWidth(), getHitbox().getHeight()))
				.intersects(new Rectangle2D.Double(o.x, o.y, o.getHitbox().getWidth(), o.getHitbox().getHeight()));
	}

	public BufferedImage getTexture() {
		return null;
	}

	public Dimension getHitbox() {
		return null;
	}

	public void update() {

	}

}
