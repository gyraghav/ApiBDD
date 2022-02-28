package utility;

import java.util.HashMap;
import java.util.List;

import config.DataLoad;
import io.restassured.http.Headers;
import io.restassured.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class RestResponse {
	
	public static Response response;

    public static void initialize(Response restResponse){
        response = restResponse;
        DataLoad dataLoad = DataLoad.getInstance();
        dataLoad.setStatusCode(Integer.toString(response.getStatusCode()));
        dataLoad.setResponse(response.body().prettyPrint());
    }
    
    public static String getStatusLine(){
        return response.getStatusLine();
    }

    public static int getStatusCode(){
        return response.getStatusCode();
    }

    public static ResponseBody getBody(){
        return response.getBody();
    }

    public static Headers getHeaders(){
        return response.getHeaders();
    }

    public static String getHeader(String header){
        return response.getHeader(header);
    }


    public static <T> T  getValue(String key){
       return getBody().jsonPath().get(key);
    }

    public static List<HashMap<String,String>> getList(String path){
       return getBody().jsonPath().getList(path);
    }

    public static String getAsString(){
       return  response.body().asString();
    }

    public static List<HashMap<Object,Object>> getArrayResponseList(){
        return getBody().as(new TypeRef<List<HashMap<Object,Object>>>() {});
    }

    public static List getResponseList(String jasonPath){
        List<String> list = getBody().jsonPath().getList(jasonPath);
        return list;
    }


}
