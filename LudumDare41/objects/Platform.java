import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Platform extends Object {

	private static BufferedImage texture = Loader.getTexture("platform1");
	private static Dimension hitbox = new Dimension(200, 30);

	public Platform(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	@Override
	public Dimension getHitbox() {
		return hitbox;
	}
	
}
