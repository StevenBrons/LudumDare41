import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {

	ArrayList<Object> objects = new ArrayList<>();
	private BufferedImage background = Loader.getTexture("background1");

	public static final int SIZE = 1000;
	public static final double ZOOM = 0.05;

	public Player player;

	public Level() {

		addWalls();

		addObject(new Ground(-50, -150));

		addObject(new Platform(200, 150));
		addObject(new Platform(600, 150));
		addObject(new Platform(400, 300));

		addObject(new SmallEnemy(50, 50));
		addObject(new SmallEnemy(800, 50));

		addObject(new Player(0, 50));
	}

	private void addWalls() {
		addObject(new Wall(-100, -100));
		addObject(new Wall(1025, -100));
	}

	private void addObject(Object object) {
		if (object instanceof Player) {
			player = (Player) object;
		}

		objects.add(object);
	}

	public void update() {
		for (int i = objects.size() - 1; i >= 0; i--) {
			objects.get(i).update(this);
			objects.get(i).move(this);
		}

	}

	public BufferedImage getBackground() {
		return background;
	}

}
