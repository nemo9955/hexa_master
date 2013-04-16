package game;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameplayState extends BasicGameState {

    private int ID;
    private int marime = 30;
    private Input input;

    private List<Polygon> fagure = new ArrayList<Polygon>();

    private Random zar = new Random();

    public GameplayState(int ID) {
        this.ID = ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        input = gc.getInput();

        float i, j = 0, row = 1;
        for( i = 0; i <= gc.getHeight(); i += pit(marime) ) {
            if( row % 2 == 0 )
                for( j = 0; j <= gc.getWidth() + marime; j += marime * 3 ) {
                    // g.setColor(new Color(zar.nextInt(225), zar.nextInt(225), zar.nextInt(225)));
                    fagure.add(hex(j, i, marime - 2));
                }
            else
                for( j = 0; j <= gc.getWidth() + marime; j += marime * 3 ) {
                    // g.setColor(new Color(zar.nextInt(225), zar.nextInt(225), zar.nextInt(225)));
                    fagure.add(hex(j + marime * 1.5f, i, marime - 2));
                }
            row++;
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {

        for( Polygon poly : fagure ) {

        }

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
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {

        for( Polygon poly : fagure ) {
            g.draw(poly);
        }

    }

    private Polygon hex(float x, float y, int mar) {
        float pcte[] = { x - (mar / 2), y - pit(mar), x + (mar / 2), y - pit(mar), x + mar, y, x + (mar / 2), y + pit(mar), x - (mar / 2), y + pit(mar), x - mar, y, x - (mar / 2), y - pit(mar) };

        Polygon poly = new Polygon(pcte);
        poly.closed();

        return poly;
    }

    private float pit(float lun) {
        return (float) ((float) (lun / 2) * Math.sqrt(3));
    }

    @Override
    public int getID() {
        return ID;
    }

}
