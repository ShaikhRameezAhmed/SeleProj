package baseModelling.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PropertiesOperation {

	static Properties prop;
	
	
	
	//Method for loading the properties
	//Load property with the path
		public static Properties loadProperty(String propertyPath) throws IOException {
		
		prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyPath));
		if(prop!=null) {
		 return prop;
			
		}
		else
			return null;
	
	}
		
		//Load property with the path and put in hashmap
		public static void loadProperty(String propertyPath, HashMap<String, String> loader) throws IOException {
			Properties prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyPath));
			
			//adding the property in the hasmap
			if(prop!=null) {
				Enumeration<?> enumf = prop.keys();
				while(enumf.hasMoreElements()) {
					String key = (String) enumf.nextElement();
					String value = prop.getProperty(key);
					loader.put(key, value)	;			
				
				}
						
			}
			
			
			
			
		}
		

		

}
