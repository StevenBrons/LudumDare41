import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {

	ArrayList<Object> objects = new ArrayList<>();
	private BufferedImage background = Loader.getTexture("background1");

	public static final int SIZE = 1000;

	public Level() {
		objects.add(new Platform(0, 0));
		objects.add(new Platform(200, 0));
		objects.add(new Platform(400, 0));
		objects.add(new Platform(600, 150));
		objects.add(new Platform(500, 400));

		
		objects.add(new Player(0, 10));
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
