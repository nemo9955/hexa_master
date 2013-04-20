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
    protected boolean exist ;
    
    protected int pozx;
    protected int pozy;

    public Hexagon(int x, int y, int marime , int id , int pozx  ,int pozy) {
        this.pozx=pozx;
        this.pozy=pozy;
        this.id = id;
        setPoly(x, y, marime);
        Culoare();
        Imagine();
        setExist(true);
    }
    
    public Hexagon() {
        setExist(false);
    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) {
        
    }

    public void render(GameContainer gc, StateBasedGame sb, Graphics g) {
        g.setColor(color);
        g.fill(poly);
        g.draw(poly);
//        g.setColor(Color.white);
//        g.setLineWidth(1);
//        g.drawString("mere", x+25, y+25) ;
    }
    
    protected void Culoare(){
//        System.out.println("default");
        color = Color.white ;
    }
    
    protected void Imagine(){
        img = null ;
    }
    
    public void setPoly(int x, int y, int marime) {
        float pcte[] = { x - (marime / 2), y - pit(marime) , x + (marime / 2), y - pit(marime), x + marime, y, x + (marime / 2), y + pit(marime), x - (marime / 2), y + pit(marime), x - marime, y};
       
        poly = new Polygon(pcte);
        poly.setClosed(true);
        poly.setAllowDuplicatePoints(false);
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
    
    public boolean isExist() {
        return exist;
    }
    
    public void setExist(boolean exist) {
        this.exist = exist;
    }
    
}
