package diverse;

import java.io.File;
import java.util.Formatter;

public class ConfigCreate {

    private Formatter x;

    public void openFile() {
        try {
            x = new Formatter("Config/fagure.cfg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecords() {
        x.format("# aspectul fagurelui\n\n");
        
        x.format("# marimea unui hexagon\n");
        x.format("marime = 40\n\n");
        
        x.format("# distanta dintre hexagoane , 0 inseamna ca nu exista nici un spatiu intre hexagoane\n");
        x.format("distanta = 5\n\n");
        
        x.format("# id-ul / culoarea hexagonului sa fie aleatorie\n");
        x.format("random = false\n\n");
        
        x.format("# daca id-ul nu e aleatoriu , selectati un id default\n");
        x.format("id_def = 5\n\n");
    }

    public void closeFile() {
        x.close();
    }

    public boolean hasCfg() {
        File cfg_is = new File("Config/fagure.cfg");
        return cfg_is.exists();

    }

}
