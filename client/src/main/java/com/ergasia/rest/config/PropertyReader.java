package com.ergasia.rest.config;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyReader {
	private static final String PROPERTY_FILE = "/home/properties/client.properties";
	private static String ip;
	private static String port;

	private static final String propertyFilePath;

	static {
		propertyFilePath = retreiveConfig();
		getProperties();
	}

	private static void getProperties() {
		Properties prop = loadPropertyFile();
		ip = getDefaultValueIfNull(prop.getProperty("ip"), "192.168.1.111");
		port = getDefaultValueIfNull(prop.getProperty("port"), "8080");

	}

	private static String getDefaultValueIfNull(String s, String defaultVal) {
		if (s == null || s.trim().equals(""))
			return defaultVal;
		else
			return s;
	}

	private static Properties loadPropertyFile() {
		String propertyPath = retrievePropertyFilePath(PROPERTY_FILE);
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(propertyPath));
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

		return props;
	}

	private static String retrievePropertyFilePath(String propertyFile) {
		Path configPath = Paths.get(propertyFilePath);
		return configPath.resolve(propertyFile).toAbsolutePath().toString();
	}

	private static String retreiveConfig() {
        String propertyFilePath = System.getenv("PATH");
        System.out.println("Got path: " + propertyFilePath);
                
        if (propertyFilePath == null)
        {
        	Path currentPath = Paths.get(".");
            propertyFilePath = currentPath.toAbsolutePath().toString();
        }
        return propertyFilePath;
	}

	public static String getIp() {
		return ip;
	}

	public static String getPort() {
		return port;
	}

}

