package tutorial;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	private int Skeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		scoreKeep += 3;

		if (scoreKeep >= 150*Skeep) {
			scoreKeep = 0;
			Skeep ++;
			hud.setLevel(hud.getLevel()+1);
			int a = r.nextInt(1);
			if(a == 0)
				handler.addObject(new BasicEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50), ID.BasicEnemy, handler));
			else if(a == 1)
				handler.addObject(new FastEnemy(r.nextInt(game.WIDTH-50),r.nextInt(game.HEIGHT-50), ID.FastEnemy, handler));
			
		}
	}
}
