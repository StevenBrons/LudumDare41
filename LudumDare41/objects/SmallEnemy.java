import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class SmallEnemy extends Object {

	public SmallEnemy(double x, double y) {
		super(x, y);
	}

	private BufferedImage texture = Loader.getTexture("small_enemy1");
	private Dimension hitbox = new Dimension(100, 150);

	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	@Override
	public Dimension getHitbox() {
		return hitbox;
	}

}
