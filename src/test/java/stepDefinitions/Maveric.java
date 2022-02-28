package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import config.DataLoad;
import config.ResourceData;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import utility.GenericUtil;
import utility.RestResponse;
import utility.RestUtil;
import utility.StepUtil;

public class Maveric {
	
	@When("^I am able to get the following end point$")
	public void i_am_able_to_get_the_following_end_point(DataTable arg1) {
		
		RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.update"));
	}

	@When("^I send request for create user with below details$")
	public void i_send_request_for_create_user_with_below_details(DataTable dataTable) {
		
		GenericUtil genericUtil = new GenericUtil();
	    String payload = genericUtil.getFileData(ResourceData.PAYLOADS_JSON);
	    Map<String, String> dataMap = StepUtil.toMap(dataTable);
	    HashMap <String,String> store= new HashMap<String, String>();
	    System.out.println(dataMap);
	    String jsonData = genericUtil.jsonConstruct(dataMap, payload);
	    System.out.println("jsonData:"+ jsonData);    
		RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.update"));
	    RestUtil.post(null,null,jsonData);
	    System.out.println("Status Line: "+RestResponse.getStatusLine());	    
	    store.put("name", dataMap.get("name"));
	    store.put("job", dataMap.get("job"));
	    store.put("id", RestResponse.getValue("id").toString());	    
	    DataLoad.getInstance().setUserdetails(store);
	    System.out.println(store);
	    System.out.println(RestResponse.getStatusCode());
	    
		
	}

	@Then("^I should see user created successfully$")
	public void i_should_see_user_created_successfully() {

		Assert.assertEquals(201, RestResponse.getStatusCode(),"User Created sucessfully");

		
	}

	@When("^I am able to get the following API endpoint$")
	public void i_am_able_to_get_the_following_API_endpoint(DataTable dataTable) {

		
		RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.get"));
		
		
	}

	@When("^I send get request for created user$")
	public void i_send_get_request_for_created_user() {
		HashMap<String, String> pathparams = new HashMap<String, String>();
		System.out.println( DataLoad.getInstance().getUserdetails("id"));
        pathparams.put("id", DataLoad.getInstance().getUserdetails("id"));
        System.out.println(pathparams);
        RestUtil.get(pathparams,null);
		
	}

	@Then("^I should see newly created user details in response$")
	public void i_should_see_newly_created_user_details_in_response(){
		System.out.println("************Pending all validation************");
		RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.get"));
		HashMap<String, String> pathparams = new HashMap<String, String>();
        pathparams.put("id", "3");
		RestUtil.get(pathparams,null);

		
	}
	
	
	/*@When("^I send get request for user “TestId”$")
	public void i_send_get_request_for_user_TestId() {
		RestUtil.initialize(ResourceData.getEnvironmentURL("QA.userServices"),ResourceData.getEndPoint("users.get"));
	}*/

	@Then("^I should see user fetched successfully$")
	public void i_should_see_user_fetched_successfully() {
		Assert.assertEquals(201, RestResponse.getStatusCode(),"User Created sucessfully");
	}
	

}
