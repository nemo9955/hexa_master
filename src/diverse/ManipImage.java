package diverse;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class ManipImage {

    private Rectangle zon = null;
    private Image img = null;
    private Vector2f poz = null;
    private float raport = 1;

    public ManipImage(Image imag, float pozX, float pozY) {
        img = imag;
        zon = new Rectangle(pozX, pozY, imag.getWidth(), imag.getHeight());
        poz = new Vector2f(pozX, pozY);
    }
    
    public ManipImage(int pozX, int pozY , int w , int h) {
        zon = new Rectangle(pozX, pozY, w, h);
        poz = new Vector2f(pozX, pozY);
    }

    public void render(Graphics g) {
 //       img.draw(poz.x, poz.y, raport);
        g.fill(zon);
        g.draw(zon);
    }

    public void render(int x, int y) {
        img.draw(poz.x + x, poz.y + y);
    }

    public boolean inZon(float x, float y) {
        if( zon.contains(x, y) ) {
            raport = 1.1f;
            return true;
        } else {
            raport = 1f;
            return false;
        }
    }
}