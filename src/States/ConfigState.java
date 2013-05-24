package States;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import diverse.Main;
import diverse.ManipImage;
import diverse.TextFieldHandeler;

public class ConfigState extends BasicGameState {

    private int ID;
    private ManipImage start;

    private ArrayList<TextFieldHandeler> text = new ArrayList<TextFieldHandeler>();

    public ConfigState(int ID) {
        this.ID = ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        text.add(new TextFieldHandeler(gc, 400, 100, "Marime hexagon:"));
        text.add(new TextFieldHandeler(gc, 400, 150, "Distanta dintre hexagoane:"));
        text.add(new TextFieldHandeler(gc, 400, 200, "Id default:"));
        text.add(new TextFieldHandeler(gc, 400, 250, "Id default:"));
        start = new ManipImage(100, 300, 200, 50);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        for( TextFieldHandeler elem : text ) {
            elem.update(gc);
        }
        if( start.inZon(gc.getInput().getMouseX(), gc.getInput().getMouseY()) )
            if( gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) )
                sb.enterState(Main.GAMEPLAYSTATE);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
        for( TextFieldHandeler elem : text ) {
            elem.render(gc, g);
        }
        start.render(g);
    }

    @Override
    public int getID() {
        return ID;
    }

}
