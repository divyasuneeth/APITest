package com.restapi.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.restapi.constants.SourcePath;

public class ReadPropertyFile {
	public static String readProperty(String prop) {
		try {
			File file = new File(SourcePath.PROP_PATH);
			FileInputStream fs = new FileInputStream(file);
			Properties p = new Properties();
			p.load(fs);
			return p.getProperty(prop);
		} catch (IOException e) {

			e.printStackTrace();
			return "";
		}

	}
}
