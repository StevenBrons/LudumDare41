import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Ground extends Object {

	private static BufferedImage texture = Loader.getTexture("platform1");
	private static Dimension hitbox = new Dimension(1200, 180);

	public Ground(double x, double y) {
		super(x, y);
	}

	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	@Override
	public Dimension getHitbox() {
		return hitbox;
	}

	@Override
	public Solid getSolidState() {
		return Solid.FULL;
	}
}
