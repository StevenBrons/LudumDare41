import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class SmallEnemy extends Object {

	double gravity = 5;
	double speed = 7;
	int jumpTime = 0;
	boolean right = true;

	public SmallEnemy(double x, double y) {
		super(x, y);
	}

	private BufferedImage texture = Loader.getTexture("small_enemy1");
	private Dimension hitbox = new Dimension(50, 75);

	@Override
	public BufferedImage getTexture() {
		return texture;
	}

	@Override
	public Dimension getHitbox() {
		return hitbox;
	}

	@Override
	public void update(Level level) {
		if (right && !onGround) {
			accx += speed;
		}
		if (!right && !onGround) {
			accx += -speed;
		}
		
		if (onGround) {
			right = Math.random() > 0.5;
			if (jumpTime > 30) {
				accy += gravity * 12;
				jumpTime = 0;
			} else {
				jumpTime++;
			}
		}

		accy -= gravity;

		accx *= 0.4;
		accy *= 0.9;

		velx *= 0.1;
		vely *= 0.3;
	}

}
