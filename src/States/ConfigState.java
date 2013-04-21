package States;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ConfigState extends BasicGameState {
    
    private int ID ;
    
    private TextField text1 ;

    public ConfigState(int ID) {
        this.ID=ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        Font font = new TrueTypeFont(new java.awt.Font(java.awt.Font.SERIF,java.awt.Font.BOLD , 26), false);
        text1 = new TextField(gc,font, 30, 30, 100, 40);
        text1.setText("cevkhgbszd");
        text1.setTextColor(Color.white);
        text1.setBackgroundColor(Color.blue);
        text1.setAcceptingInput(true);
        text1.setBorderColor(Color.red);
        text1.setInput(gc.getInput());
        text1.setMaxLength(5);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ENTER)){
            System.out.println(text1.getText());
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
        text1.render(gc, g);
    }

    @Override
    public int getID() {
        return ID;
    }

}
