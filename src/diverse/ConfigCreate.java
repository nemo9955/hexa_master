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
        x.format(String.format("marime = %d\n\n", 50));
        
        x.format("# distanta dintre hexagoane , 0 inseamna ca nu exista nici un spatiu intre hexagoane\n");
        x.format(String.format("distanta = %d\n\n", 5));
        
        x.format("# id-ul / culoarea hexagonului sa fie aleatorie\n");
        x.format(String.format("random = %b\n\n", true));
        
        x.format("# daca id-ul nu e aleatoriu , selectati un id default\n");
        x.format(String.format("id_def = %d\n\n", 5));
    }

    public void closeFile() {
        x.close();
    }

    public boolean hasCfg() {
        File cfg_is = new File("Config/fagure.cfg");
        return cfg_is.exists();

    }
    
    public void delCfg(){
        File cfg_is = new File("Config/fagure.cfg");
         cfg_is.delete();
    }

}
