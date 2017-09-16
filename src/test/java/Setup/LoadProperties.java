package Setup;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeSuite;

import baseModelling.Util.PropertiesOperation;

public class LoadProperties {
    
    public HashMap<String, String> MaploadingProperties = new HashMap<String, String>();
   
    @BeforeSuite
    public void loadAllProperties(){
	loadAlltestDataFromExcel();
	try {
	    PropertiesOperation.loadProperty("configuration.properties", MaploadingProperties);
	    System.out.println(MaploadingProperties.get("testdatapath"));
	
	
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
    }
    
    public void loadAlltestDataFromExcel() {
	
	
	
    }


}
