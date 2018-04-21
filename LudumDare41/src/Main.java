
public class Main {

	public static boolean running = true;

	static Frame frame = new Frame();
	static Level level = new Level();

	public static void main(String args[]) {
		System.out.println("Hello World!");
		run();
	}

	public static void run() {
		Thread draw = new Thread(new Runnable() {
			@Override
			public void run() {

				while (running) {
					long t = System.currentTimeMillis();
					frame.screen.drawAll(level);
					try {
						Thread.sleep(100 - (t - System.currentTimeMillis()));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		draw.start();

		Thread update = new Thread(new Runnable() {
			@Override
			public void run() {

				while (running) {
					level.update();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		update.start();

	}

}
