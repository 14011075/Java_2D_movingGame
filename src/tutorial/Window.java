package tutorial;

import java.awt.*;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = 5398482868712359277L;

	public Window(int width, int height, String title, game Game)
	{
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(Game);
		frame.setVisible(true);
		Game.start();
		
	}
}
