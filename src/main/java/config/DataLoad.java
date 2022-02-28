package config;


import java.util.HashMap;
import java.util.List;

public class DataLoad {
	
	private String requestURL;
    private String request;
    private String response;
    private String statusCode;
	private String Name;
	private String job;
	
	private static HashMap<String,String> userdetails;
	private static List<HashMap<String, String>> dataList;
	private static DataLoad singleInstance = null;

    public static DataLoad getInstance() {
        if (singleInstance == null) {
            singleInstance = new DataLoad();
           
        }
        return singleInstance;
    }
    
    public List<HashMap<String, String>> getDataList() {
    	 return dataList;
    }          
        
    public void setDataList(HashMap<String, String> dataValidator) {
        dataList.add(dataValidator);
    }
    
    public void resetDataList() {
        dataList.clear();
    }
    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

	public static String getUserdetails(String userkey) {
		return userdetails.get(userkey);
	}

	public static void setUserdetails(HashMap<String,String> userdetails1) {
		userdetails =new HashMap<String, String>();
		userdetails.putAll(userdetails1);
		
	}
}
