import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class Player extends Object {

	public Player(double x, double y) {
		super(x, y);
	}

	public static boolean UP = false;
	public static boolean DOWN = false;
	public static boolean LEFT = false;
	public static boolean RIGHT = false;

	private BufferedImage texture = Loader.getTexture("player_idle");
	private Dimension hitbox = new Dimension(50, 100);

	double speed = 7;
	double gravity = 5;

	@Override
	public void update(Level level) {
		if (LEFT) {
			accx -= speed;
		}
		if (RIGHT) {
			accx += speed;
		}
		if (UP) {
			if (onGround) {
				accy += gravity * 12;
			}
		}
		accy -= gravity;
		
		accx *= 0.4;
		accy *= 0.9;

		velx *= 0.1;
		vely *= 0.3;
	}

	@Override
	public Dimension getHitbox() {
		return hitbox;
	}

	@Override
	public BufferedImage getTexture() {
		return texture;
	}
	
}
