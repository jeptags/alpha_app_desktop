package com.lue.jeptags.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lue
 */
public class UrlProperties {


    static Properties properties;
    
    public UrlProperties() {

        File file = new File(System.getProperty("user.dir") + "\\" + "url.properties");
        try (FileInputStream fileInput = new FileInputStream(file)) {
            properties = new java.util.Properties();
            properties.load(fileInput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UrlProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UrlProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return 
     */
    public static Properties getProperties() {
        return properties;
    }
}
