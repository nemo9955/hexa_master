package hexa;

import org.newdawn.slick.Color;


public class HexStandard extends Hexagon {

    public HexStandard(float x, float y, int marime , int id) {
        
        super(x, y, marime, id);
        
    }
    
    protected void Culoare(){
        switch(id){
            case 1 : color = Color.red; break;
            case 2 : color = Color.blue; break;
            case 3 : color = Color.green; break;
            case 4 : color = Color.yellow; break;
            default : color = Color.white;
        }
    }

}
