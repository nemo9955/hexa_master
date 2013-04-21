package hexa;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class HexStandard extends Hexagon {

    public HexStandard(int x, int y, int marime, int id, int pozx, int pozy) {

        super(x, y, marime, id, pozx, pozy);
        //        System.out.print(id);

    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        if( poly.contains((float) gc.getInput().getMouseX(), (float) gc.getInput().getMouseY()) ) {
            
            if( gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) ) {
                id ++;
                //                System.out.println(id + " " + poly.getCenterX() + " " + poly.getCenterY());
                Culoare();
            }
            
            if( gc.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON) ) {
                id--;
                //                System.out.println(id + " " + poly.getCenterX() + " " + poly.getCenterY());
                Culoare();
            }
            
        }
        if( poly.contains((float) gc.getInput().getMouseX(), (float) gc.getInput().getMouseY()) )
            if( gc.getInput().isMousePressed(Input.MOUSE_MIDDLE_BUTTON) ) {

            }
    }
    
 /*   public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
        g.setColor(color);
        g.fill(poly);
        g.draw(poly);
        g.setColor(Color.white);
        g.setLineWidth(1);
        g.drawString("mere", x+25, y+25) ;
    }*/

    protected void Culoare() {
        //        System.out.println(" standard ");
        if( id > 0 )
            color = Color.darkGray;
        else
            color = Color.lightGray;

        switch ( id ) {
            case 1 :
                color = Color.red;
                break;
            case 2 :
                color = Color.blue;
                break;
            case 3 :
                color = Color.green;
                break;
            case 4 :
                color = Color.yellow;
                break;
            case 5 :
                color = Color.cyan;
                break;
            case 6 :
                color = Color.pink;
                break;
        }
    }

}
