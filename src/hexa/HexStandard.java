package hexa;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class HexStandard extends Hexagon {

    public HexStandard(int x, int y, int marime, int id) {

        super(x, y, marime, id);
        //        System.out.print(id);

    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        if( gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON) && poly.contains((float) gc.getInput().getMouseX(), (float) gc.getInput().getMouseY()) ) {
            id++;
            System.out.println(id + " " + gc.getInput().getMouseX() + " " + gc.getInput().getMouseY());
            Culoare();
        }
        if( gc.getInput().isMousePressed(Input.MOUSE_RIGHT_BUTTON) && poly.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) ) {
            id--;
            System.out.println(id + " " + gc.getInput().getMouseX() + " " + gc.getInput().getMouseY());
            Culoare();
        }
        /*         if( gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    System.out.println(id + " " + gc.getInput().getMouseX() + " " + gc.getInput().getMouseY());
                }
         */
    }

    protected void Culoare() {
        //        System.out.println(" standard ");
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
            default :
                color = Color.darkGray;
        }
    }

}
