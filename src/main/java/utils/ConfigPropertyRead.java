package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyRead {

    private static Properties config = null;

    /**
     * This method returns the configuration instance
     *
     * @return ConfigPropertyRead
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static Properties readproperty() throws FileNotFoundException, IOException {
        if (config == null) {
            config = new Properties();
            config.load(new FileInputStream("config.properties"));
        }
        return config;
    }
}
