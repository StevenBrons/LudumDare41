import java.awt.Dimension;

public class Wall extends Object {

	private static Dimension hitbox = new Dimension(100, 1000);

	public Wall(double x, double y) {
		super(x, y);
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
