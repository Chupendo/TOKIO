package com.tokio.school.log4j.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tokio.school.utils.ReadPropertiesUtils;

/*
 * 
 * https://notearena.com/lesson/log4j2-in-a-maven-project/
 * mvn clean compile exec:java
 */
public class MyApp {
	private static final Logger logger = LogManager.getLogger(MyApp.class);

	private static final int NUM_OF_ITERATIONS = 50;
	private static final int MILLISECONDS_TO_SLEEP = 2000;

	public static void main(String[] args) throws InterruptedException {
		/*
		MyApp app = new MyApp();
        Properties prop = app.loadPropertiesFile("config.properties");
        prop.forEach((k, v) -> System.out.println(k + ":" + v));
        */
		ReadPropertiesUtils.loadPropertiesFile(MyApp.class);
		ReadPropertiesUtils.PROPERITES.forEach((k, v) -> System.out.println(k + ":" + v));
        logger.debug("Hello from Log4j 2");
        
	}
	
	public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();
        System.out.println(filePath);
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}