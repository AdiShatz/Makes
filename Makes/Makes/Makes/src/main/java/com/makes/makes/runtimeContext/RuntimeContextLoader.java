package com.makes.makes.runtimeContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeContextLoader {

    private static final RuntimeContextLoader instance = new RuntimeContextLoader();
    private static final Logger log = LoggerFactory.getLogger(RuntimeContextLoader.class.getName());
    private static final String PropertiesFilePath = "src\\main\\resources\\Chuka.properties";

    private RuntimeContextLoader(){};

    public static RuntimeContextLoader getInstance(){ return instance; }

    public void loadRuntimeContext(){
        loadProperties();
    }

    public void loadProperties(){
        log.info("Trying to load the runtime context properties from: " + PropertiesFilePath);
        RuntimeContext.getInstance().setProperties(PropertiesFilePath);
    }
}
