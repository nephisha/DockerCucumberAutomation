package support;


import java.io.*;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();
    InputStream inputStream = null;
    OutputStream outputstream = null;

    public PropertyReader(String proptype) {
        loadProperties(proptype);
    }

    private void loadProperties(String proptype) {
        try {
            inputStream = new FileInputStream("src/test/resources/properties/" + proptype + ".properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    public void writeProperty(String proptype, String key, String value){
        try{
            properties.setProperty(key,value);
            File filename = new File("src/test/resources/properties/" + proptype + ".properties");
            outputstream = new FileOutputStream(filename);
            properties.store(outputstream, "Updating the " + proptype + " property file");
            outputstream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

