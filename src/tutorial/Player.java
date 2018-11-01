package tutorial;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	public void tick() {
		x+=velX;
		y+=velY;
		
		x = game.clamp(x, 0, game.WIDTH-40);
		y = game.clamp(y, 0, game.HEIGHT-70);
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.white,32,32,0.2f,handler));


		collision();
	}
	private void collision() {
		for(int i = 0 ; i < handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy)
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 1;
				}
		}
	}
	
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green);
		g2d.draw(getBounds());
		
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
}
