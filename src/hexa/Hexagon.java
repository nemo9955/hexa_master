package hexa;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.StateBasedGame;

public class Hexagon {

    protected int id;
    protected Image img;
    protected Polygon poly;
    protected Color color ;
    protected int x ;
    protected int y ;

    public Hexagon(float x, float y, int marime , int id) {
        this.id = id;
        setPoly(x, y, marime);
        Culoare();
        Imagine();
    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        
    }

    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
        g.setColor(color);
//        g.fill(poly);
        g.draw(poly);
    }
    
    protected void Culoare(){
        System.out.println("default");
        color = Color.white ;
    }
    
    protected void Imagine(){
        img = null ;
    }
    
    public void setPoly(float x, float y, int marime) {
        float pcte[] = { x - (marime / 2), y - pit(marime), x + (marime / 2), y - pit(marime), x + marime, y, x + (marime / 2), y + pit(marime), x - (marime / 2), y + pit(marime), x - marime, y, x - (marime / 2), y - pit(marime) };
        poly = new Polygon(pcte);
        poly.closed();
    }

    public static float pit(float lun) {
        return (float) ((float) (lun / 2) * Math.sqrt(3));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Polygon getPoly() {
        return poly;
    }
}
