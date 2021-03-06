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

import diverse.ConfigCreate;
import diverse.ConfigReader;
import diverse.Main;

public class GameplayState extends BasicGameState {

    private int ID;
    private Input input;

    private Hexagon fagur[][];
    private int lat;
    private int inalt;
    private boolean diferit;

    private Random zar = new Random();

    private int marime = 50;
    private int distanta = 1;
    private boolean color_rand = true;
    private int id_default = 6;

    public GameplayState(int ID) {
        this.ID = ID;
    }

    public void enter(GameContainer gc, StateBasedGame sb) throws SlickException {
        loadConfig();
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        input = gc.getInput();
        makeComb(gc);
    }

    private void loadConfig() {
        
        File x = new File("Config");
        if( !x.exists() )
            x.mkdir();
        
        ConfigCreate cc = new ConfigCreate();
        if( !cc.hasCfg() ) {
            cc.openFile();
            cc.addRecords();
            cc.closeFile();
        }


        try{
        ConfigReader cfg = new ConfigReader();
        color_rand = Boolean.parseBoolean(cfg.getProperty("random"));
        marime = Integer.parseInt(cfg.getProperty("marime"));
        distanta = Integer.parseInt(cfg.getProperty("distanta"));
        if( !color_rand )
            id_default = Integer.parseInt(cfg.getProperty("id_def"));
        } catch(Exception e){
            cc.delCfg();
            loadConfig();
        }

    }

    private void makeComb(GameContainer gc) {

        lat = (int) Math.floor(gc.getWidth() / (marime * 1.5f)) - 1 + (int) Math.floor(gc.getWidth() / ((((int) (gc.getWidth() / (marime * 1.5f))) * (marime * 1.5f)) + marime / 2));
        inalt = (int) Math.floor(gc.getHeight() / (Hexagon.pit(marime))) + 1;
        diferit = inalt % 2 == 1;

        //        System.out.println( inalt );

        inalt /= 2;
        inalt -= (diferit ? 0 : 1);

        fagur = new Hexagon[lat][inalt];

        for( int i = 0; i < inalt; i++ )
            for( int j = 0; j < lat; j++ ) {
                if( diferit && i == inalt - 1 && j % 2 == 1 )
                    fagur[j][i] = new Hexagon();
                else
                    fagur[j][i] = new HexStandard((int) (marime + (marime * 1.5f * j)), (int) ((j % 2 == 0) ? Hexagon.pit(marime) + (Hexagon.pit(marime) * 2 * i) : Hexagon.pit(marime) * 2 + (Hexagon.pit(marime) * 2 * i)), marime - distanta, (color_rand ? (1 + zar.nextInt(6)) : id_default), j, i);
            }

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {

        for( int i = 0; i < inalt; i++ )
            for( int j = 0; j < lat; j++ ) {
                if( fagur[j][i].isExist() )
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
                if( fagur[j][i].isExist() )
                    fagur[j][i].render(gc, sb, g);
            }

    }

    @Override
    public int getID() {
        return ID;
    }

}
