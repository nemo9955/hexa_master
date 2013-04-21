package diverse;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.TextField;

public class TextFieldHandeler {
    
    private int x;
    private int y;
    private String mesaj ;
    private String val ;
    private TextField txt ;
    private Color opak = new Color(0,0,0,0);
    private Font font2;
    
    public TextFieldHandeler(GameContainer gc , int x , int y , String mesaj  ) {
        this.x=x;
        this.y=y;
        this.mesaj=mesaj;
        Font font = new TrueTypeFont(new java.awt.Font(java.awt.Font.DIALOG,java.awt.Font.BOLD , 15), false);
        txt = new TextField(gc , font , x+5 , y , 60 , 20 );
        txt.setTextColor(Color.white);
        txt.setBackgroundColor(Color.blue);
        txt.setAcceptingInput(true);
        txt.setBorderColor(opak);
        txt.setMaxLength(5);
        font2 = new TrueTypeFont(new java.awt.Font(java.awt.Font.MONOSPACED ,java.awt.Font.BOLD , 20), false);
    }
    
    public void update(GameContainer gc){
        
    }
    
    public void render(GameContainer gc ,Graphics g){
        g.setFont(font2);
        g.drawString(mesaj , x-(mesaj.length()*12), y-5);
        txt.render(gc, g);
    }
    
    public String getVal(){
        return val ;
    }

}
