package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadTextFile {
	
	public static String readTextFile(final String route) {
		String content = "";
		InputStream imputBytes = ClassLoader.class.getResourceAsStream(route);
		BufferedReader reader = new BufferedReader(new InputStreamReader(imputBytes));
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (imputBytes != null) {
					imputBytes.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return content;
	}
}
