package diverse ;

import game.GameplayState;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    private static String title = "hexagon";
    
    private static int width ;
    private static int height ;
    
    private static final int GAMEPLAYSTATE = 0 ;
    
    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main(title));
        app.setDisplayMode(500, 500, false);
        app.setResizable(true);
        app.setShowFPS(true);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        addState(new GameplayState(GAMEPLAYSTATE));
        
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Main.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Main.height = height;
    }

    
    
}
