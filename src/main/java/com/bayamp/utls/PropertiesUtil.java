package com.bayamp.utls;

/**
 * Created by naresh on 1/30/2016.
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties prop = new Properties();
    private static InputStream output = null;

    public static String getProperty(String propertyName) {
        String propertyValue = null;
        if (output == null) {
            try {
                output = new FileInputStream("src/main/resources/Framework.properties");
                prop.load(output);
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        propertyValue = prop.getProperty(propertyName);

        return propertyValue;
    }
}