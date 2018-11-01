package tutorial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject {

	
	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		Random r = new Random();
		velY = r.nextInt(20)-10;
		velX = r.nextInt(20)-10;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		if (y <= 0 || y >= game.HEIGHT-50) velY *= -1;//벽에 닿으면 반대로감
		if (x <= 0 || x >= game.WIDTH-16) velX *= -1;//위와 동
		
		handler.addObject(new Trail(x,y,ID.Trail,Color.red,16,16,0.08f,handler));

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}
