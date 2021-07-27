package com.makes.makes.propertiesProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesProvider {

    private Properties properties;
    private String filePath;
    private static final Logger log = LoggerFactory.getLogger(PropertiesProvider.class.getName());

    public PropertiesProvider(String filePath) {
        this.properties = new Properties();
        this.filePath = filePath;
    }

    public void loadProperties() {
        try (InputStream in = new FileInputStream(filePath)) {
            properties.load(in);
        } catch (IOException error) {
            properties = null;
            log.error("Error occurred while loading the Properties File:",error);
        }
    }

    public String getPropertyAsString(String key) {
        if (properties == null) {
            return null;
        }
        return properties.getProperty(key);
    }

    public List<String> getPropertyAsList(String key) {
        String property = getPropertyAsString((key));
        if (property == null) {
            return null;
        }
        return Arrays.asList(property.split(","));
    }
}
