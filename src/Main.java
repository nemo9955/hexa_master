import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	private static String title = "hexagon";
	private int marime = 30;

	public Main(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main(title));
		app.setDisplayMode(800, 600, false);
		app.setTargetFrameRate(60);
		app.setResizable(true);
		app.setShowFPS(true);
		app.start();
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer argcg0, Graphics g) throws SlickException {
		for (float i = 50; i <= 300; i += pit(marime)*2)
			for (int j = 50; j <= 300; j += marime*2) {
				if (((i - marime) / marime) % 2 == 0)
					hex(j, i, marime, g);
				else
					hex(j - (marime / 2), i, marime, g);
			}
	}

	private void hex(float x, float y, int mar, Graphics g) {
		g.drawLine(x - (mar / 2), y - pit(mar), x + (mar / 2), y - pit(mar));
		g.drawLine(x - (mar / 2), y + pit(mar), x + (mar / 2), y + pit(mar));

		g.drawLine(x - mar, y, x - (mar / 2), y - pit(mar));
		g.drawLine(x + mar, y, x + (mar / 2), y - pit(mar));

		g.drawLine(x - mar, y, x - (mar / 2), y + pit(mar));
		g.drawLine(x + mar, y, x + (mar / 2), y + pit(mar));
	}

	private float pit(float lun) {
		return (float) ((float) (lun / 2) * Math.sqrt(3));
	}

}
