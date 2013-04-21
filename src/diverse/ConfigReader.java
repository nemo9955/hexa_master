package diverse;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties configFile;

    public ConfigReader() {

        configFile = new java.util.Properties();
        try {

            final InputStream cfg = new FileInputStream("Config/fagure.cfg");

            try {
                configFile.load(cfg);
            } finally {
                cfg.close();
            }
            
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String value = this.configFile.getProperty(key);
        return value;
    }
}