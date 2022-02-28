package config;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

public class ResourceData {
	
	 public static final String CONFIG_PROPERTIES = "C:\\E_Personal\\LearnigJ2EE\\RestAPI_U_BDD\\src\\main\\java\\resources\\config.properties";
	    public static final String ENDPOINTS_JSON = "C:\\E_Personal\\LearnigJ2EE\\RestAPI_U_BDD\\src\\main\\java\\resources\\endPoints.json";
	    public static final String ENVIRONMENTS_JSON = "C:\\E_Personal\\LearnigJ2EE\\RestAPI_U_BDD\\src\\main\\java\\resources\\environment.json";
	    public static final String PAYLOADS_JSON = "C:\\E_Personal\\LearnigJ2EE\\RestAPI_U_BDD\\src\\main\\java\\payloads\\payLoads.json";

	    private static final String EnvironmentVariableKey = "JAVA_ENV";


	    public static String getConfigProperty(String propertyName) {

	        return getProperty(CONFIG_PROPERTIES,propertyName);
	    }
	    
	    public static String getEnvironment(){
	        /**
	         * Seems we want this to be obtained 
	         * FIRST from Environment var
	         * Secondly from Config.
	         */
	        String environment = getEnvironmentVariable(EnvironmentVariableKey);
	        if (environment != null) {
	            return environment;
	        }

	        return getConfigProperty("environment");
	    }

	    public static String getEnvironmentURL(String path){
	        return getValueFromJson(ENVIRONMENTS_JSON,path);
	    }

	    public static String getEndPoint(String path){
	        return getValueFromJson(ENDPOINTS_JSON,path);
	    }
	    
	    public static String getValueFromJson(String jsonFile, String path){
	        String jsonValue="";
	        try {
	            String json = readFileAsString(jsonFile);
	            JsonPath jsonPath = new JsonPath(json);
	            jsonValue = jsonPath.get(path).toString();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return jsonValue;
	    }

	    public static String readFileAsString(String file)throws Exception
	    {
	        return new String(Files.readAllBytes(Paths.get(file)));
	    }

	    /**
	     * This method reads the propertyFile and return the matching propertyValue for the propertyName
	     * @param propertyFile
	     * @param propertyName
	     * @return propertyValue
	     */
	    public static String getProperty(String propertyFile, String propertyName) {

	        String propertyValue="";

	        try {
	            FileReader fileReader = new FileReader(propertyFile);

	            Properties properties = new Properties();
	            properties.load(fileReader);

	            propertyValue = properties.getProperty(propertyName);

	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return propertyValue;
	    }

	    public static String getEnvironmentVariable(String variableName) {
	        return System.getenv(variableName);
	    }
	    
}
