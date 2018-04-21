import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

public class Object {

	double x;
	double y;

	double velx;
	double vely;

	double accx;
	double accy;

	boolean onGround = false;

	public void show(Graphics2D g) {
	}

	public boolean intersects(Rectangle2D rect, Object o) {
		return rect.intersects(new Rectangle2D.Double(o.x, o.y, o.getHitbox().getWidth(), o.getHitbox().getHeight()));
	}

	public BufferedImage getTexture() {
		return null;
	}

	public Dimension getHitbox() {
		return null;
	}

	public void update(Level level) {

	}

	public void move(Level level) {
		if (velx == 0 && vely == 0 && accx == 0 && accy == 0) {
			return;
		}

		velx += accx;
		vely += accy;

		boolean hitx = false;
		boolean hity = false;

		for (Object o : level.objects) {
			if (!o.equals(this)) {
				Rectangle2D newPosX = new Rectangle2D.Double(x + velx, y, getHitbox().getWidth(),
						getHitbox().getHeight());
				boolean ix = intersects(newPosX, o);
				Rectangle2D newPosY = new Rectangle2D.Double(x, y + vely, getHitbox().getWidth(),
						getHitbox().getHeight());
				boolean iy = intersects(newPosY, o);

				if (ix) {
					hitx = true;
					if (velx > 0) {
						x = o.x - getHitbox().width;
					} else {
						x = o.x + o.getHitbox().width;
					}
				}
				if (iy) {
					hity = true;
					if (vely > 0) {

					} else {
						onGround = true;
						y = o.y + o.getHitbox().height;
					}
				}
			}
		}

		if (!hitx) {
			x += velx;
		}
		if (!hity) {
			y += vely;
			if (vely > 0) {
				onGround = false;
			}
		}

		accx *= 0.4;
		accy *= 0.8;

		velx *= 0.1;
		vely *= 0.3;
	}

}
