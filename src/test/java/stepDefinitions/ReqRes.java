package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import config.DataLoad;
import config.Payload;
import config.ResourceData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.GenericUtil;
import utility.RestResponse;
import utility.RestUtil;
import utility.StepUtil;

public class ReqRes {
	

@When("^I get the following API endpoint to create user$")
public void i_get_the_following_API_endpoint(DataTable dataTable)  {
   
	System.out.println("First test case");
	
	RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.create"));
	RestUtil.get(null,null);

    String responseString = RestResponse.getBody().jsonPath().get().toString();
	System.out.println("responseString: "+responseString);
	GenericUtil genericUtil = new GenericUtil();
    String payload = genericUtil.getFileData(ResourceData.PAYLOADS_JSON);
    Map<String, String> dataMap = StepUtil.toMap(dataTable);
    HashMap hashMap = new HashMap<String, String>();
//    dataMap.put("name", hashMap.get("name").toString());
//    dataMap.put("job", hashMap.get("job").toString());
    System.out.println(hashMap);
    System.out.println(dataMap);
    String jsonData = genericUtil.jsonConstruct(dataMap, payload);
    System.out.println("jsonData:"+ jsonData);
    
	RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.update"));
    RestUtil.post(null,null,jsonData);
//    Assert.assertEquals(201, RestResponse.getStatusCode());
    Assert.assertEquals(201,RestResponse.getStatusCode(),"User created sucessgully ");
    String responseString1 = RestResponse.getBody().jsonPath().get().toString();
    
    System.out.println("resp"+responseString1);
    
    String surveyName = dataMap.get("name");
    String engagementKey = dataMap.get("job");
	

    System.out.println("completed first");
   
}

@Then("^user list will be displayed$")
public void user_list_will_be_displayed() {
	System.out.println("Second started");
	
	
}

@Then("^Validate the status code (\\d+)$")
public void validate_the_status_code(int arg1){
	
}

}
