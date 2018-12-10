package testclasses;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import dataclasses.DataSets;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilityclasses.BaseClass;

public class AddAnUser extends BaseClass{

	@Test(description="This test is used  to add an user")
	public void addAnUser()  
	{
		//Get Test Data
        DataSets data=new DataSets();
		data=data.createUserData();		
		String name=data.getUserFirstName();
		String job=data.getUsersJob();
		
		//Prepare request data
		JSONObject requestParams = new JSONObject();
        requestParams.put("name", name); 
        requestParams.put("job", job);
        
        //Make Post Request
        Response response=apiPostCallMethod("users",requestParams) ;       
        System.out.println("Response for Test addAnUser is \n"+ response.getBody().asString());
        Reporter.log("Response for Test addAnUser is -> "+ response.getBody().asString());
        
        //Check status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201,"Incorrect status code "+statusCode+" found");
       
        //Assert on Response 
        JsonPath jsonRes=new JsonPath(response.body().asString());        
        Assert.assertEquals(jsonRes.getString("name"),name,"Value for User's Name is not matching");
        Assert.assertEquals(jsonRes.getString("job"),job, "Value for User's job is not matching");
        Assert.assertFalse(jsonRes.getString("id").isEmpty(),"id");        
	}
	
}
