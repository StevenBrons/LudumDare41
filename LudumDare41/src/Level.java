import java.util.ArrayList;

public class Level {

	ArrayList<Object> objects = new ArrayList<>();

	public static final int WIDTH = 1600;
	public static final int HEIGHT = 1000;

	public Level() {
		objects.add(new Platform(0, 0));
	}

	public void update() {
		for (int i = objects.size() - 1; i >= 0; i--) {
			objects.get(i).update();
		}
	}

}
