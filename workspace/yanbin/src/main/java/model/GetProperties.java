package model;

import java.io.FileInputStream;
import java.util.Properties;

public class GetProperties {
	private static String propertyName="/home/yanbin/workspace/yanbin/src/hadoop.properties";
	public static String getProperties(String key)throws Exception{
	    String property=null;
	    Properties pps = new Properties();
        pps.load(new FileInputStream(propertyName));
        property=pps.getProperty(key).toString();
        return property;
	    }	
}
