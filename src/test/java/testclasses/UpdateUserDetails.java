package testclasses;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import dataclasses.DataSets;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilityclasses.BaseClass;

public class UpdateUserDetails extends BaseClass{

	@Test(description="This test is used to update an user's details")
	public void updateAnUser()  
	{		
		//Get Test Data
        DataSets data=new DataSets();
		data=data.updateUserData();		
		String first_name=data.getUserFirstName();
        String last_name=data.getUserLastName();
        String avatar=data.getUserAvatar();
        String userId=data.getUserId();
		
        //Prepare request data
        JSONObject requestParams = new JSONObject();
        requestParams.put("first_name", first_name); 
        requestParams.put("last_name", last_name);
        requestParams.put("avatar", avatar);
               
        //Make Put Request
        Response response=apiPostCallMethod("users"+userId,requestParams) ;       
        System.out.println("Response for Test updateAnUser is \n "+ response.getBody().asString());
        Reporter.log("Response for Test updateAnUser is -> "+ response.getBody().asString());
        
        //Check status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201,"Incorrect status code "+statusCode+" found");
        
        //Assert on Response 
        JsonPath jsonRes=new JsonPath(response.body().asString());
        Assert.assertEquals(jsonRes.getString("first_name"),first_name,"Value for User's first_name is not matching");
        Assert.assertEquals(jsonRes.getString("last_name"),last_name, "Value for User's last_name is not matching");
        Assert.assertEquals(jsonRes.getString("avatar"),avatar, "Value for User's avatar is not matching");        
	}
	
}
