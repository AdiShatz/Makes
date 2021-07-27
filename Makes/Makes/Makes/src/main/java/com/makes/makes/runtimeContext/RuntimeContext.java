package com.makes.makes.runtimeContext;

import com.makes.makes.propertiesProvider.PropertiesProvider;

public class RuntimeContext {

    private static final RuntimeContext instance = new RuntimeContext();
    private PropertiesProvider properties = null;

    private RuntimeContext(){}

    public static RuntimeContext getInstance(){
        return instance;
    }

    public PropertiesProvider getProperties(){
        if(properties == null) {
            RuntimeContextLoader.getInstance().loadProperties();
        }
        return properties;
    }

    void setProperties(String path){
        this.properties = new PropertiesProvider(path);
        properties.loadProperties();
    }
}
