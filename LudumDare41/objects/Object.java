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

	public Object(double x, double y) {
		this.x = x;
		this.y = y;
	}

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
						o.getSolidState() == Solid.TOP ? 0.001 : getHitbox().getHeight());
				boolean ix = intersects(newPosX, o);
				Rectangle2D newPosY = new Rectangle2D.Double(x, y + vely, getHitbox().getWidth(),
						o.getSolidState() == Solid.TOP ? 0.001 : getHitbox().getHeight());
				boolean iy = intersects(newPosY, o);

				if (iy) {
					hity = true;
					if (vely > 0) {
						onGround = false;
						if (o.getSolidState() != Solid.TOP) {
							y = o.y - getHitbox().height;
						}
					} else {
						onGround = true;
						y = o.y + o.getHitbox().height;
					}
				}

				if (ix) {
					hitx = true;
					if (velx > 0 && !hity) {
						x = o.x - getHitbox().width;
					} else {
						x = o.x + o.getHitbox().width;
					}
				}

			}
		}

		if (!hitx) {
			x += velx;
		} else {
			velx = 0;
			accx = 0;
		}
		if (!hity) {
			y += vely;
			if (vely > 0) {
				onGround = false;
			}
		} else {
			vely = 0;
			accy = 0;
		}

		accx *= 0.4;
		accy *= 0.7;

		velx *= 0.1;
		vely *= 0.3;
	}

	public Solid getSolidState() {
		return Solid.NONE;
	}

}

enum Solid {
	FULL, TOP, NONE;
}