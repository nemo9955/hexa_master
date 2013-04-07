
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;

public class Main extends BasicGame {

    private static String title = "hexagon";
    private int marime = 30;
    private Input input ;

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
        input=gc.getInput();
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        if( input.isKeyPressed(Input.KEY_P) ) {
            Image target = new Image(gc.getWidth(), gc.getHeight());
            gc.getGraphics().copyArea(target, 0, 0);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH,mm,ss");
            Date date = new Date();
            File x = new File("screenshot");
            if( !x.exists() )
                x.mkdir();
            String pozaTit = String.format("screenshot/screen%s.jpg", dateFormat.format(date));
            ImageOut.write(target.getFlippedCopy(false, false), pozaTit, false);
            target.destroy();
        }
    }

    @Override
    public void render(GameContainer argcg0, Graphics g) throws SlickException {
        float i, j = 0, row = 1;
        for( i = 50; i <= 300; i += pit(marime) ) {
            if( row % 2 == 0 )
                
                for( j = 50; j <= 300; j += marime * 3 )
                    hex(j, i, marime, g);
            else
                for( j = 50; j <= 300; j += marime * 3 )
                    hex(j+marime*1.5f, i, marime, g);
            row++;
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
