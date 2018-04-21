import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JPanel main = new JPanel();
	Screen screen = new Screen();
	CardLayout cards = new CardLayout();

	public Frame() {
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640, 400);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());

		main.setLayout(cards);

		add(main, BorderLayout.CENTER);
		main.add(screen, "game");

		screen.addKeyListener(new UserInput());
		showView("game");
	}

	public void showView(String name) {
		cards.show(main, name);
	}

}
