package game;

import hexa.HexStandard;
import hexa.Hexagon;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import diverse.Main;

public class GameplayState extends BasicGameState {

    private int ID;
    private int marime = 30;
    private Input input;

    private List<Hexagon> fagure = new ArrayList<Hexagon>();

    private Random zar = new Random();

    public GameplayState(int ID) {
        this.ID = ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        input = gc.getInput();
        makeComb(gc);
    }

    private void makeComb(GameContainer gc) {

        float i, j = 0, row = 1;
        for( i = 0; i <= gc.getHeight(); i += Hexagon.pit(marime) ) {
            if( row % 2 == 0 )
                for( j = 0; j <= gc.getWidth() + marime; j += marime * 3 ) {
                    fagure.add( new HexStandard(j, i, marime-3, (1+zar.nextInt(4) ) ) );
                } 
            else
                for( j = 0; j <= gc.getWidth() + marime; j += marime * 3 ) {
                    fagure.add( new HexStandard(j + marime * 1.5f , i, marime-3, (1+zar.nextInt(4) ) ) );
                }
            row++;
        }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        
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

        if( gc.getWidth() != Main.getWidth() || gc.getHeight() != Main.getHeight() ) {
            Main.setWidth(gc.getWidth());
            Main.setHeight(gc.getHeight());
            makeComb(gc);
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
//        g.setBackground(Color.black);
        g.setLineWidth(1);
 //       g.setColor(Color.white);
        for( Hexagon hexag : fagure ) {
            hexag.render(gc, sb, g);
        }

    }

    @Override
    public int getID() {
        return ID;
    }

}
