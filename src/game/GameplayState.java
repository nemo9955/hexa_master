package game;

import hexa.HexStandard;
import hexa.Hexagon;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private int marime = 50;
    private Input input;

    private Hexagon fagur[][];
    private int lat;
    private int inalt;

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

        lat = (int) (Math.floor(gc.getWidth() / (marime * 1.5f)))/2;
        inalt = (int) (gc.getHeight() /  marime);

        fagur = new Hexagon[lat][inalt];

        System.out.println(lat + " " + inalt);

        for( int i = 0; i < inalt; i++ )
            for( int j = 0; j < lat; j++ ) {
                //                System.out.println(j + " " + i);
                if( i % 2 == 1 )
                    fagur[j][i] = new HexStandard((int) marime + (marime * 3 * j), (int) (Hexagon.pit(marime) + (Hexagon.pit(marime) * i)), marime - 5, (1 + zar.nextInt(6)));
                else
                    fagur[j][i] = new HexStandard((int) (((int) marime + (marime * 3 * j)) + marime*1.5f), (int) (Hexagon.pit(marime) + (Hexagon.pit(marime) * i)), marime - 5, (1 + zar.nextInt(6)));
            }

        /* fagure.clear();
         int i, j = 0, row = 2;
         for( i = (int) Hexagon.pit(marime); i <= gc.getHeight() - Hexagon.pit(marime); i += Hexagon.pit(marime) ) {
             for( j = marime; j <= gc.getWidth() - marime; j += marime * 3f ) {
                 if( row % 2 == 0 )
                     fagure.add(new HexStandard(j, i, marime - 5, (1 + zar.nextInt(6))));
                 else
                     fagure.add(new HexStandard((int) (j + marime * 1.5f), i, marime - 5, (1 + zar.nextInt(6))));
             }
             row++;
         }*/

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {

        for( int i = 0; i < inalt; i++ )
            for( int j = 0; j < lat; j++ ) {
                fagur[j][i].update(gc, sb, delta);
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

        if( gc.getWidth() != Main.getWidth() || gc.getHeight() != Main.getHeight() ) {
            Main.setWidth(gc.getWidth());
            Main.setHeight(gc.getHeight());
//            System.out.println("update");
            makeComb(gc);
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
        //        g.setBackground(Color.black);
        g.setLineWidth(1);
        //       g.setColor(Color.white);
        for( int i = 0; i < inalt; i++ )
            for( int j = 0; j < lat; j++ ) {
                fagur[j][i].render(gc, sb, g);
            }

    }

    @Override
    public int getID() {
        return ID;
    }

}
