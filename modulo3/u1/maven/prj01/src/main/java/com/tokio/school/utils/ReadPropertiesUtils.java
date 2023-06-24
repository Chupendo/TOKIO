package com.tokio.school.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.tokio.school.common.AppConstants;

public class ReadPropertiesUtils {
	
	public static Properties PROPERITES;
	
	public static Properties loadPropertiesFile(Class<?> clazz) {
		return loadPropertiesFile(clazz,AppConstants.FILE_PATH_CONF_PROPERTIES);
	}
	
	public static Properties loadPropertiesFile(Class<?> clazz,String filePath) {

        Properties prop = new Properties();
        System.out.println(filePath);
        try (InputStream resourceAsStream = clazz.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
            PROPERITES = prop;
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
