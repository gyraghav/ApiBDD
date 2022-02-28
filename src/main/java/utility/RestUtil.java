package utility;

import java.util.HashMap;
import java.util.Map;

import config.DataLoad;
import config.ResourceData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
	
	public static void initialize(String baseURI,String path){
		
		RestAssured.baseURI= baseURI;
        RestAssured.basePath = path;
        DataLoad dataLoad = DataLoad.getInstance();
        dataLoad.setRequestURL(baseURI+path);
        System.out.println("URL = "+dataLoad.getRequestURL());
		
	}
	
	public static String getRequestURL(String environmentURL, String endpoint){
        String envURL = ResourceData.getEnvironmentURL(ResourceData.getEnvironment()+"."+environmentURL);
        String endpoints = ResourceData.getEndPoint(endpoint);
        return envURL+endpoints;
    }
	
	 public static void get(){
	        get();
	    }

   
    public static void post(String payload){
        post(payload);
    }

    public static void delete(Map<String, String> queryParams){
        delete(queryParams);
    }
    
    public static void get(HashMap<String, String> pathParams,Map<String, String> queryParams){
        RequestSpecification httpRequest = RestAssured.given();
//        if(authorization){
//            DataLoad dataLoad = DataLoad.getInstance();
//            httpRequest.header("Authorization","Bearer "+dataLoad.getParticipantToken());
//        }
        if(pathParams!=null) {
            httpRequest.pathParams(pathParams);
        }
        if(queryParams!=null) {
            httpRequest.queryParams(queryParams);
        }
        RestResponse.initialize(httpRequest.get());
    }


    public static void post(HashMap<String, String> pathParams,Map<String, String> queryParams, String payload){
        RequestSpecification httpRequest = RestAssured.given();
//        if(authorization){
//            DataLoad dataLoad = DataLoad.getInstance();
//            httpRequest.header("Authorization","Bearer "+dataLoad.getParticipantToken());
//        }
//        httpRequest.headers(APIHeaders.defaultHeaders());
        if(pathParams!=null) {
            httpRequest.pathParams(pathParams);
        }
        if(queryParams!=null) {
            httpRequest.queryParams(queryParams);
        }
        httpRequest.body(payload);
        RestResponse.initialize(httpRequest.post());
    }


}   


